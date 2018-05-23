/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.Socket;
import java.net.ServerSocket;

/**
 *
 * @author Tiago
 */
public class ReverseProxy {
    

    public static void main(String[] args){

        ServerSocket ss;
        Socket s;

        try {
            
            Table tab = new Table();
          
            MonitorUDP m = new MonitorUDP(tab);
            
            Thread mon = new Thread(m);
            mon.start();

            ss = new ServerSocket(80);
            
            while((s=ss.accept())!=null){
                TreatClient tc = new TreatClient(tab,s);
                Thread t = new Thread(tc);
                t.start();
            }

            mon.join();
            ss.close();
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    
    }

    
}
