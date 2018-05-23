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
public class MonitorUDPReader implements Runnable{
   
   private final static String address = "239.8.8.8";
   private static int port = 8888;
   private DatagramSocket ds;
   protected byte[] buf = new byte[256];
   private Table tabela;

    public MonitorUDPReader(Table table, DatagramSocket d) throws SocketException, IOException{
	     this.tabela = table;
       this.ds = d;
    }
    
    @Override
    public void run() {
       try {
            while (true){
     	        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        	    ds.receive(packet);

          		SocketAddress sa = packet.getSocketAddress();
              long diff;
              double lg;

              if(this.tabela.getServidores().containsKey(sa)){
                Duration duration = Duration.between(this.tabela.getServidores().get(sa).getInicio(), LocalDateTime.now());
                diff = Math.abs(duration.toMillis());
                double viagem = (double) diff/2;
                lg = packet.getLength()/viagem;
              }
              else{
                diff=0;
                lg=0;
              }
              String received = new String(
            	packet.getData(), 0, packet.getLength());

          		String[] arr = received.split(" ");    

          		float cpu = Float.parseFloat(arr[1]);
          		float ram = Float.parseFloat(arr[2]);

          		StateTable st = new StateTable(sa,cpu,ram,diff,lg);

          		this.tabela.add(sa,st);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
       
    }
  
}	
