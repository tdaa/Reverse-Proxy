import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class ReadData implements Runnable {

	private Socket serverSocket;
	private Socket clientSocket;

	public ReadData(Socket socket, Socket sc){
		this.serverSocket = socket;
		this.clientSocket = sc;
	}

	public void run(){
		try{
			
			System.out.println("Started Reading!");

			byte[] s = new byte[256];

            String aux;
            int tamanho;

            InputStream ist = this.clientSocket.getInputStream();
            OutputStream ostServer = this.serverSocket.getOutputStream();

            while((tamanho=ist.read(s)) != -1){
                
                ostServer.write(s,0,tamanho);
                ostServer.flush();
                aux = new String(s,"UTF-8");
                System.out.println(aux);

            }

            ostServer.close();

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}
}