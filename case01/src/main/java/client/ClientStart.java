package client;

import java.io.DataOutputStream;
import java.net.Socket;

public class ClientStart {
    public static void main(String[] args) {
        System.out.println("Hello Client Start");

        try{
            Socket s = new Socket("localhost", 5000);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF("Hello Server");
            dos.flush();
            dos.close();
            s.close();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
