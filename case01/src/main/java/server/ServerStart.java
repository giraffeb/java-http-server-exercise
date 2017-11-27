package server;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStart {
    public static void main(String[] args) {
        System.out.println("Hello new world");

        try{
            ServerSocket ss = new ServerSocket(5000);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());

            String buffer = (String)dis.readUTF();

            System.out.println("message = "+buffer);
            ss.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
