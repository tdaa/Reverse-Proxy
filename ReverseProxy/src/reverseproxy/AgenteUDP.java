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
    private MulticastSocket multic;
    private InetAddress address;
    
    public AgenteUDP() throws SocketException, IOException{
        this.multic=new MulticastSocket(8888);
        this.address.getByName("239.8.8.8");
    }
    
    @Override
    public void run(){
        try{
            multic.joinGroup(address);
            byte buf[] = new byte[1024];
            DatagramPacket pack = new DatagramPacket(buf, buf.length);
            multic.receive(pack);
            System.out.println("Received data from: " + pack.getAddress().toString() +
                ":" + pack.getPort() + " with length: " +
                pack.getLength());
            System.out.write(pack.getData(),0,pack.getLength());
            System.out.println();
        } catch(IOException ex){
            Logger.getLogger(AgenteUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}