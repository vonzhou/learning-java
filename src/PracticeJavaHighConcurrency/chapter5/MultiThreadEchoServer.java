package PracticeJavaHighConcurrency.chapter5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadEchoServer {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8000);
        Socket clientSocket = null;

        System.out.println("Server listening ....");
        while (true) {
            clientSocket = ss.accept();
            executorService.execute(new HandleMsg(clientSocket));
        }
    }

    static class HandleMsg implements Runnable {
        Socket clientSocket;


        public HandleMsg(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;
            try {
                long start = System.currentTimeMillis();
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                os = new PrintWriter(clientSocket.getOutputStream(), true);
                String inputLine;
                while ((inputLine = is.readLine()) != null) {
                    os.println(inputLine);
                }
                System.out.println(String.format("Cost %s ms", (System.currentTimeMillis() - start)));
            } catch (Exception e) {

            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (os != null) {
                        os.close();
                    }
                } catch (Exception e) {

                }

            }
        }
    }
}
