/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsProTest;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajesh
 */
public class InteruptionTh implements Runnable {

    private BlockingQueue<Message> queue;

    public InteruptionTh(BlockingQueue<Message> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
           int i=1;
            while (true) {
                 Thread.sleep(200);
                if (queue.size() == 10*i) {
                    System.out.println("Queue Size = "+queue.size());
                    System.out.println("<<<----Interuption---->>>\n");
                    i++;
                }
                if(i==10)
                {
                    break;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(InteruptionTh.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
