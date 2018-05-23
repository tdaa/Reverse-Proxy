import java.net.SocketTimeoutException;
import java.net.SocketAddress;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.*;
import sun.net.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PL43
 */
public class MonitorUDP implements Runnable{
   
   private final static String address = "239.8.8.8";
   private static int port = 8888;
   private DatagramSocket ds = new DatagramSocket();
   protected byte[] buf = new byte[256];
   private Table t;

    public MonitorUDP(Table table) throws SocketException, IOException{
        Thread t = new Thread(new MonitorUDPReader(table, ds));
        t.start();
        Thread t2 = new Thread(new MonitorTabela(table));
        t2.start();
        this.t = table;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     */
    
    @Override
    public void run() {
       try {
           InetAddress addr = InetAddress.getByName(address);

      	   while(true){
                  String msg = "Sent message";
                      
                  DatagramPacket pck = new DatagramPacket(msg.getBytes(), msg.getBytes().length, addr, port);

                  for(SocketAddress sa: this.t.getServidores().keySet()){
                    this.t.getServidores().get(sa).setInicio();
                  }

                  ds.send(pck);
                //  System.out.println("server send packet with message: " + msg);
                  Thread.sleep(1000);
      	   }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
       
    }
  
}	
