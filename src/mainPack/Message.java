/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPack;

/**
 *
 * @author rajesh
 */
public class Message 
{
    private byte[] serverResponse;
    

    public Message() 
    {
       
    }

    public void setServerResponse(byte[] serverResponse) {
        this.serverResponse = serverResponse;
    }

  
    public byte[] getServerResponse() {
        return serverResponse;
    }
    
}
