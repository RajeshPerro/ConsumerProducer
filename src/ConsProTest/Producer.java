/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsProTest;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author rajesh
 */
public class Producer implements Runnable{
    public byte [] message;
    private BlockingQueue <Message> queue;

    public Producer(BlockingQueue<Message> q) {
        this.queue = q;
    }
    

    @Override
    public void run() {
        for(int i =0 ; i<100 ; i++)
        {
           
            //setMsg((byte) i, (byte) (i+1), (byte) (i+2),(byte)(i+3));
            Message msg = new Message( setMsg((byte) i, (byte) (i+1), (byte) (i+2),(byte)(i+3)));
            try{
                Thread.sleep(200);
                queue.put(msg);
                System.out.println("Producing Message : "+Arrays.toString(msg.getServerResponse()));
                
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
   
    public byte[] setMsg(byte a, byte b, byte c, byte d)
    {
        message = new byte[4];
        
        message [0] = a;
        message [1] = b;
        message [2] = c;
        message [3] = d; 
        
    return message;
    }
}
