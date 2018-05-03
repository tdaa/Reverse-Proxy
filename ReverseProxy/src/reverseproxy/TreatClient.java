package reverseproxy;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Map;

/**
 *
 * @author Tiago
 */
public class TreatClient implements Runnable{

    private Table tab;
    private Socket clientSocket;
    private Socket serverSocket;

    public TreatClient(Table t, Socket ss){
        tab = t;
        clientSocket = ss;
        monitorSocket = null;
    }

    public void run(){

        StateTable st = tab.bestServer();

        try {
        
            System.out.println("Cliente em processo! YaHoooooooo!");
            
            InputStream ist = this.clientSocket.getInputStream();
            OutputStream ost = this.clientSocket.getOutputStream();

            this.serverSocket = new Socket(st.getIp(), 80);
            InputStream istServer = this.serverSocket.getInputStream();
            OutputStream ostServer = this.serverSocket.getOutputStream();

            byte[] dados = new byte[256];

            while(ist.read(data) != -1){
                
            }



            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



}