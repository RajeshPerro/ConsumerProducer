/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsProTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author rajesh
 */
public class Service {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        //Creating BlockingQueue of size 100
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(100);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        InteruptionTh interupt = new InteruptionTh(queue);
        Thread tp = new Thread(producer);
        Thread tc = new Thread(consumer);
        Thread ti = new Thread(interupt);
        tp.start();
        tc.start();
        ti.start();
        System.out.println("Producer and Consumer has been started");
    }
    
}
