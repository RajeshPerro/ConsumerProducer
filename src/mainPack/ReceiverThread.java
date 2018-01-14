/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rajesh
 */
public class ReceiverThread implements Runnable{

    Socket socket;
    byte [] response = new byte[4];
    public ReceiverThread(Socket sckt) 
    {
        this.socket = sckt;
    }
   
    @Override
    public void run()
    {
        try {
            DataInputStream inStream = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(ReceiverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
