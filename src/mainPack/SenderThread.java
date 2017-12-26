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

    private BlockingQueue<mainPack.Message> queue;
    Socket serverClient;

    public SenderThread(Socket inSocket, BlockingQueue<Message> que) {
        this.queue = que;
        this.serverClient = inSocket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());
            Message msg = new Message();
            System.out.println("\nSender Thread Started!!\n");
            int i = 0;
            boolean loop= true;
            while (loop) 
            {
                String str1 = Arrays.toString(msg.getServerResponse());
                if(!queue.isEmpty())
                {
                    if(str1.equalsIgnoreCase("[5, 5, 5]"))
                    {
                        System.out.println("\n----->>>>>>Interruption------>>>>>>>\n");
                        System.out.println("Server is going to Shutdown for maintenance.\n");
                    }
                    else
                    {
                        try
                        {
                            outStream.write(msg.getServerResponse(), 0, 3);
                        }catch(Exception e){
                            System.out.println(e);
                        }
                        System.out.println("From the Message in Sender: "+Arrays.toString(msg.getServerResponse())+"\n");
                    }
                   
                    
                }
               else
                {
                    System.out.println("I am here nothing found in Queue!");
                     loop=false;
                     Thread.sleep(200);
                     
                }
            }
           
        }catch(Exception e){ }

    }
}
