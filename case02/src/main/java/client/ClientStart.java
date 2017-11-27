package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientStart {

    public static void main(String[] args) {
        System.out.println("Hello Client start");

        try{
            Socket socket = new Socket("localhost", 5000);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String request = "Hello Server";
            dos.writeUTF(request);
            dos.flush();

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String repsonse = dis.readUTF();
            System.out.println("reponse : "+repsonse);

            dos.close();
            dis.close();
            socket.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
