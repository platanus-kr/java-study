package org.codepractice.SocketCommunicate;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DataServer {

    public static void main(String[] args) {
        try{
            ServerSocket sock = new ServerSocket(6013);

            while(true){
                Socket client = sock.accept();

                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                pout.println(new Date().toString());
                client.close();
            }
        }
        catch (IOException e){
            System.err.println(e);
        }
    }

}
