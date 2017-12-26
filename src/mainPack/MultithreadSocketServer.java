/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author rajesh
 */
public class MultithreadSocketServer {
    public static int counter = 0;
    public static void main(String[] args) throws Exception {
        int PortNum = 9999;
         BlockingQueue<mainPack.Message> queue = new ArrayBlockingQueue<>(1024);
        try {
            ServerSocket server = new ServerSocket(PortNum);
            System.out.println("Waiting for client on port " + server.getLocalPort() + "...");
            while (true) {
                counter++;
                Socket serverClient = server.accept();
                System.out.println("Just connected to " + serverClient.getRemoteSocketAddress());
                System.out.println(" -->>>> " + "Client No:" + counter + " started!--->>>>>>");
//                Thread t = new Thread(new GameRules(serverClient));
//                t.start();
               
                //All thread begin here......-->>>>>>>>>>>
                GameRules gamerul = new GameRules(serverClient, queue);
                SenderThread sndrth = new SenderThread(serverClient, queue);
                InteruptionTh intupth = new InteruptionTh(queue);
                
                Thread tgame = new Thread(gamerul);
                Thread tsndr = new Thread(sndrth);
                Thread tintp = new Thread(intupth);
                
                tgame.start();
               
                tsndr.start();
                tintp.start();
            
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
