import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.io.IOException;
import java.lang.management.ManagementFactory;
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
 * @author PL43
*/
public class AgenteUDP implements Runnable {
     String address = "239.8.8.8";
     int port = 8888;
     protected byte[] buf = new byte[256];
     
    public static void main(String[] args) throws IOException {
        Thread m = new Thread(new AgenteUDP());
        m.start();
    }
    
    public AgenteUDP() throws SocketException, IOException{
        
    }
    
    @Override
    public void run(){
        try{
            try (MulticastSocket s = new MulticastSocket(this.port)){
            InetAddress group = InetAddress.getByName(this.address);
       	    s.joinGroup(group);
            while (true) {
               	DatagramPacket packet = new DatagramPacket(buf, buf.length);
                s.receive(packet);
       
                String received = new String(
                packet.getData(), 0, packet.getLength());
                if ("end".equals(received)) {
                    break;
                }
		
		//System.out.println(received);	
	
                com.sun.management.OperatingSystemMXBean osMBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
                long ram = osMBean.getFreePhysicalMemorySize();
                double cpu = osMBean.getProcessCpuLoad();

                SocketAddress add = packet.getSocketAddress();

                String resposta = String.valueOf(" " + ram + " " + cpu);

                DatagramPacket pack = new DatagramPacket(resposta.getBytes(), resposta.length(), add);
                s.send(pack);
            }
            s.leaveGroup(group);
            s.close();
        }
        } catch(IOException ex){
            Logger.getLogger(AgenteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
