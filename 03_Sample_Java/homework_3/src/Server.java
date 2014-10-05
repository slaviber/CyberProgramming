import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Server {
	
	public static final int PORT = 1337;

	public void listen() throws IOException {
		ServerSocket serverSocket = null;
		try{
			serverSocket = new ServerSocket(PORT);
			while (true) {
				final Socket clientSocket = serverSocket.accept();
				new ClientHandler(clientSocket).start();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			serverSocket.close();
		}
	}
	
	class ClientHandler extends Thread{
		
		private final Socket clientSocket;
		
		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			try {
				
				final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				final PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
				
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				Date date = formatter.parse(in.readLine());
				long diff = new Date().getTime() - date.getTime();
				out.println(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
				
				out.flush();
				clientSocket.close();
				
			} 
			catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		new Server().listen();

	}

}
