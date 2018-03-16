package reverseproxy;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
import java.net.MulticastSocket;
import java.net.InetAddress;
import java.net.DatagramPacket;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.net.*;

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
     String address = "239.8.8.8";
     int port = 8888;
     protected byte[] buf = new byte[256];
    
    public AgenteUDP() throws SocketException, IOException{
        
    }
    
    @Override
    public void run(){
        try{
            MulticastSocket s = new MulticastSocket(8888);
            InetAddress group = InetAddress.getByName("239.8.8.8");
            s.joinGroup(group);
            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                s.receive(packet);
        
                String received = new String(
                packet.getData(), 0, packet.getLength());
                System.out.println(received);
                if ("end".equals(received)) {
                    break;
                }
            }
            s.leaveGroup(group);
            s.close();
        } catch(IOException ex){
            Logger.getLogger(AgenteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}