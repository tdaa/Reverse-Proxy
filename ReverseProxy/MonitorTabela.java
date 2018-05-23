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
public class MonitorTabela implements Runnable{
   
   private Table t;

    public MonitorTabela(Table table) throws SocketException, IOException{
        this.t=table;
    }
    
    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     */
    
    @Override
    public void run() {
       try {
          ArrayList<SocketAddress> sadd = new ArrayList<SocketAddress>();
          HashMap<SocketAddress,StateTable> servidores;
      	   while(true){
                 servidores = t.getServidores();
                 for(SocketAddress sa: servidores.keySet()){
                  Duration duration = Duration.between(servidores.get(sa).getTempo(), LocalDateTime.now());
                  long diff = Math.abs(duration.toMillis());

                  if(diff>5000){
                      sadd.add(sa);
                  }
                }

                for(SocketAddress sa: sadd){
                  servidores.remove(sa,servidores.get(sa));
                  System.out.println("removi o " + sa);
                }

                t.setServidores(servidores);
                sadd = new ArrayList<SocketAddress>();

                //  System.out.println("server send packet with message: " + msg);
                  Thread.sleep(2000);
      	   }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
       
    }
  
}	
