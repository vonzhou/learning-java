package PracticeJavaHighConcurrency.chapter5;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioEchoServer {
    private static Selector selector;
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static Map<Socket, Long> TIME_STAT = new HashMap<>();

    public static void main(String[] args) throws Exception {
       startServer();
    }

    private static void startServer() throws Exception {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(8000);
        ssc.bind(isa);

        SelectionKey selectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

        for (; ; ) {
            selector.select();
            Set readyKeys = selector.selectedKeys();
            Iterator i = readyKeys.iterator();

            while (i.hasNext()) {
                SelectionKey sk = (SelectionKey) i.next();

                // 这里很重要
                i.remove();

                if (sk.isAcceptable()) {
                    doAccept(sk);
                } else if (sk.isValid() && sk.isReadable()) {
                    Socket s = ((SocketChannel) sk.channel()).socket();
                    if (!TIME_STAT.containsKey(s)) {
                        TIME_STAT.put(s, System.currentTimeMillis());
                        doRead(sk);
                    }
                } else if (sk.isValid() && sk.isWritable()) {
                    doWrite(sk);
                    Socket s = ((SocketChannel) sk.channel()).socket();
                    System.out.println(String.format("Cost %s ms", System.currentTimeMillis() - TIME_STAT.remove(s)));
                }
            }
        }


    }

    private static void doWrite(SelectionKey sk) throws Exception {
        SocketChannel channel = (SocketChannel) sk.channel();
        EchoClient echoClient = (EchoClient)sk.attachment();
        ByteBuffer bb = echoClient.getOutputQueue().getLast();

        int len = channel.write(bb);
        if(len == -1){
            disconnect(sk);
            return;
        }

        // 一块写完后，从队列中移除
        if(bb.remaining() == 0){
            echoClient.getOutputQueue().removeLast();
        }

        // WRITE 事件被移除了
        if(echoClient.getOutputQueue().size() == 0){
            sk.interestOps(SelectionKey.OP_READ);
        }

    }

    private static void doRead(SelectionKey sk) throws Exception {
        SocketChannel channel = (SocketChannel) sk.channel();
        ByteBuffer bb = ByteBuffer.allocate(8192);

        int len = channel.read(bb);
        if (len < 0) {
            disconnect(sk);
            return;
        }

        bb.flip();
        executorService.execute(new HandleMsg(sk, bb));

    }

    private static void disconnect(SelectionKey sk) {
    }

    private static void doAccept(SelectionKey sk) throws Exception {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) sk.channel();
        SocketChannel clientChannel = serverSocketChannel.accept();
        clientChannel.configureBlocking(false);

        SelectionKey selectionKey = clientChannel.register(selector, SelectionKey.OP_READ);
        selectionKey.attach(new EchoClient());

        InetAddress clientAddr = clientChannel.socket().getInetAddress();
        System.out.println(String.format("Connection from %s .", clientAddr.getHostAddress()));
    }

    // 暂存Echo client 发送过来的数据
    static class EchoClient {
        private LinkedList<ByteBuffer> outq;

        EchoClient() {
            outq = new LinkedList<>();
        }

        public LinkedList<ByteBuffer> getOutputQueue() {
            return outq;
        }

        public void enqueue(ByteBuffer bb) {
            this.outq.add(bb);
        }
    }

    static class HandleMsg implements Runnable {
        SelectionKey sk;
        ByteBuffer bb;
        Socket clientSocket;


        public HandleMsg(SelectionKey sk, ByteBuffer bb) {
            this.sk = sk;
            this.bb = bb;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) sk.attachment();
            echoClient.enqueue(bb);
            sk.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);

            // selector立即返回
            selector.wakeup();
        }
    }
}
