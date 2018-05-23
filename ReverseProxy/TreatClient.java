
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.lang.*;

/**
 *
 * @author Tiago
 */
public class TreatClient implements Runnable{

    private Table tab;
    private Socket clientSocket;

    public TreatClient(Table t, Socket ss){
        tab = t;
        clientSocket = ss;
    }

    public void run(){

        StateTable st = tab.bestServer();

        try {
            InetSocketAddress ip = (InetSocketAddress) st.getIP();

            System.out.println(ip.getHostName());

            Socket serverSocket = new Socket(ip.getHostName(),80);
            
            ReadData read = new ReadData(serverSocket, this.clientSocket);
            WriteData write = new WriteData(serverSocket, this.clientSocket);
            Thread rd = new Thread(read);
            Thread wd = new Thread(write);
            rd.start();
            wd.start();

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



}