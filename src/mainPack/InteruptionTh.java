/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

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
        System.out.println("\nInterruption Thread called!\n Queue Size :"+queue.size());
    }

    @Override
    public void run() {
        try {
               //Thread.sleep(200);
                byte [] data = {(byte)5,(byte)5,(byte)5};
                Message msg = new Message();
                msg.setServerResponse(data);
                queue.put(msg);
                System.out.println("\nInterruption Thread Inserted!\n Queue Size :"+queue.size());
                Thread.sleep(5000);
                
            
        } catch (InterruptedException ex) {
            Logger.getLogger(InteruptionTh.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
