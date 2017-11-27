package server;


import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;

public class WorkerThread implements Callable{

    Socket socket;

    public WorkerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public Object call() throws Exception {

        try(DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); ){

            String request = dis.readUTF();
            System.out.println("socket port : "+socket.getPort() + " request : "+request);

            String message = "Hello this is repsonse";
            dos.writeUTF(message);
            dos.flush();

            System.out.println("send message to "+socket.getPort()+" : "+message);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            socket.close();
        }

        return null;
    }
}
