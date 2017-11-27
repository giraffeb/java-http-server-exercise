package server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerStart {


    public static void main(String[] args) {
        System.out.println("Server Start");
        ServerSocket serversocket = null;
        ExecutorService executor = Executors.newFixedThreadPool(5);

        try {
            serversocket = new ServerSocket(5000);
        } catch (Exception e) {
            System.out.println(e);
        }


            /*
            * JAVA의 io방식 중 가장 기본적인 형태는 stream 입력/출력으로 나뉘어저서 단방향 통신이다.
            * 보내는 쪽은 보내고 받는쪽은 받는것만 하는 채널임. 그러니 보내는 스트림, 받는 스트림을 서버와 클라이언트 모두 각각 열어야 한다.
            * 이 코드에서 서버는 받기만 할꺼니깐 하나만 염.
            * */
        while (true) {
            try {
                Socket client = serversocket.accept();
                Callable worker = new WorkerThread(client);
                executor.submit(worker);

            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}
