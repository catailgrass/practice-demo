package com.flycat.common_practice.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());
    public static  void main(String[]args){
        try {
            ServerSocket ss = new ServerSocket(3000);
            while (true){
                Socket s = ss.accept();
                socketList.add(s);
//                PrintStream printStream = new PrintStream(s.getOutputStream());
//                printStream.println("这是服务器的消息！！！--"+"--");
//                printStream.close();
//                s.close();
                new Thread(new ServerThread(s)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
