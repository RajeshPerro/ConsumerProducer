/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author rajesh
 */
public class SenderThread implements Runnable {

    public BlockingQueue<Message> queue;
    Socket serverClient;
    int poisonPill = Integer.MAX_VALUE;
    public static Message msg = new Message();

    public SenderThread(Socket inSocket, BlockingQueue<Message> que) {
        this.queue = que;
        this.serverClient = inSocket;
        
    }

    @Override
    public void run() {
        try {
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
           
            System.out.println("\nSender Thread Started!!\n");
            System.out.println("\nQueue Size :" + queue.size());
            for (Message message : queue) {
                
                //Message number = queue.take();
                //System.out.println("Data in queue :"+ queue.take());

                String str1 = Arrays.toString(message.getServerResponse());
                
                if (!queue.isEmpty()) {
                        try {
                                outStream.write(message.getServerResponse(), 0, 3);
                                outStream.flush();
                                queue.poll();

                            } catch (Exception e) {
                                System.out.println(e);
                            }
                    
                    if (str1.equalsIgnoreCase("[5, 5, 5]")) {
                        System.out.println("Calling the get method in sender to cehck inturp. : " + str1);
                        System.out.println("\n----->>>>>>Sending Interruption------>>>>>>>\n");
                        outStream.write(message.getServerResponse(),0,3);
                        outStream.flush();
                        queue.poll();
                        //queue.remove();
                    }
                        System.out.println("From the Message in Sender: " + Arrays.toString(message.getServerResponse()) + "\n");
                    

                } else {
                    System.out.println("I am here nothing found in Queue!");
                    //loop=false;
                    Thread.sleep(200);

                }
                
            }

        } catch (Exception e) {
        }

    }
    
//    public static void main(String [] args)
//    {
//        System.out.println("Whats wrong : "+Arrays.toString(msg.getServerResponse()));
//    }
}
