import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class WriteData implements Runnable {
	
	private Socket serverSocket;
	private Socket clientSocket;

	public WriteData(Socket socket, Socket socketClient){
		this.serverSocket = socket;
		this.clientSocket = socketClient;
	}

	public void run(){
		try{
			
			System.out.println("Started Writing!");

            byte[] dadosCliente = new byte[256];
            byte[] dadosServer = new byte[256];

            OutputStream ost = this.clientSocket.getOutputStream();
            InputStream istServer = this.serverSocket.getInputStream();

            while(istServer.read(dadosServer) != -1){
                
                ost.write(dadosServer);

            }

            ost.flush();
            ost.close();

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}
}