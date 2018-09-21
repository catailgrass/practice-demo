package practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * 向s所有ocket中输入从客户端传来的消息
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private BufferedReader bufferedReader;

    public ServerThread(Socket socket) throws Exception{
        this.socket = socket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String line = "";
        try {
            while ((line = bufferedReader.readLine())!=null){
                for (Socket s :MyServer.socketList){
                    PrintStream printStream = new PrintStream(s.getOutputStream());
                    printStream.println(line);
                }
            }
        } catch (IOException e) {
            MyServer.socketList.remove(socket);
        }
    }

}
