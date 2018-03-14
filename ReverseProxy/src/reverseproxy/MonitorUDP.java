package reverseproxy;

import java.net.DatagramSocket;
import java.net.SocketException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tiago
 */
public class MonitorUDP {
    
    private DatagramSocket ds;
    
    public MonitorUDP() throws SocketException{
        ds = new DatagramSocket(8888);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.net.SocketException
     */
    public static void main(String[] args) {
        
    }
    
}
