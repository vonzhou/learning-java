package PracticeJavaHighConcurrency.chapter5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws Exception  {
        Socket client = new Socket();
        client.connect(new InetSocketAddress("localhost", 8000));
        PrintWriter writer = new PrintWriter(client.getOutputStream());
        writer.println("hello");
        writer.flush();

        BufferedReader is = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(is.readLine());


        is.close();
        writer.close();


    }
}
