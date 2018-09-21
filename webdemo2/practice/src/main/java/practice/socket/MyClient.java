package practice.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[]args){
        try {
            //负责将用户键入的内容 放到socket的输出流中
            Socket socket = new Socket("127.0.0.1",3000);
            new Thread(new ClientThread(socket)).start();
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            String line ="";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while ((line = bufferedReader.readLine()) != null) {
                printStream.println(line);
            }
            new Thread(()->{
                System.out.println("dfasdafsfd ");
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
