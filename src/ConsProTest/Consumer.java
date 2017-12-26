/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsProTest;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajesh
 */
public class Consumer implements Runnable {

    private BlockingQueue<Message> queue;
    int counter = 0;

    public Consumer(BlockingQueue<Message> q) {
        this.queue = q;
    }

    @Override
    public void run() {

        try {
            Message msg = null;
            
            while (true) {
                Thread.sleep(200);
                if(queue.size()!=0)
                {
                    counter++;
                    
                }
                System.out.println("Consumed Item" +counter);

                
                if (counter == 100) {
                    break;
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
