/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reverseproxy;

import java.net.ServerSocket;

/**
 *
 * @author Tiago
 */
public class ReverseProxy {
    

    public static void main(String[] args){

        ServerSocket ss;
        Server s;

        try {
            
            Table tab = new Table();
            MonitorUDP m = new MonitorUDP(tab);
            
            m.start();

            ss = new ServerSocket(80);
            while((s=ss.accept())!=null){
                TreatClient tc = new TreatClient(tab,s);
                tc.start();
            }

            m.join();
            ss.close();
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }

    
}
