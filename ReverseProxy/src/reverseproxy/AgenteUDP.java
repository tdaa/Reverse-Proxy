package reverseproxy;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
import java.net.MulticastSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class AgenteUDP implements Runnable {
     private final static String address = "239.8.8.8";
     private static int port = 8888;
    
    public AgenteUDP() throws SocketException, IOException{
        
    }
    
    @Override
    public void run(){
        try{
            InetAddress addr = InetAddress.getByName("239.8.8.8");
            byte[] buf = new byte[256];
            try(MulticastSocket ms = new MulticastSocket(port)) {
                
                ms.joinGroup(addr);
                while(true){
                    DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                    ms.receive(msgPacket);
                    String msg = new String(buf,0,buf.length);
                    System.out.println("Socket 1 receive msg: " + msg);
                }
                
            }
            
        } catch(IOException ex){
            Logger.getLogger(AgenteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}