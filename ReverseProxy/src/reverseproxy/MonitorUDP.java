package reverseproxy;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
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
public class MonitorUDP implements Runnable{
   
   private final static String address = "239.8.8.8";
   private static int port = 8888;
    
    public MonitorUDP() throws SocketException, IOException{
  

        
    }
    
    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     */
    public static void main(String[] args) throws IOException {
        for(int i=0; i<3; i++){
            Thread ag = new Thread(new AgenteUDP());
            ag.start();
        }
        Thread m = new Thread(new MonitorUDP());
        m.start();
    }

    @Override
    public void run() {
       try {
           InetAddress addr = InetAddress.getByName(address);
       
        
        try(DatagramSocket ds = new DatagramSocket()) {
            for(int i=0; i<5; i++){
                String msg = "Sent message no " + i;
                
                DatagramPacket pck = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);
                
                ds.send(pck);
                System.out.println("server send packet with message: " + msg);
                Thread.sleep(500);
            }
       } catch (UnknownHostException ex) {

           Logger.getLogger(MonitorUDP.class.getName()).log(Level.SEVERE, null, ex);
       }
        } catch (SocketException ex) {
           Logger.getLogger(MonitorUDP.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(MonitorUDP.class.getName()).log(Level.SEVERE, null, ex);
       } catch (InterruptedException ex) {
           Logger.getLogger(MonitorUDP.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }
    
}
