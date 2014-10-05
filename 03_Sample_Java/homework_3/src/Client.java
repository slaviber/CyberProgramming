import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {

	public static final String IP = "127.0.0.1";
	
	public static void main(String[] args) throws IOException {
		System.out.print("Enter date: ");
		
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		final Socket clientSocket = new Socket(IP, Server.PORT);
		final BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		final PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
		
		final String request = reader.readLine();
		out.println(request);
		out.flush();
		
		System.out.println(in.readLine());
		clientSocket.close();

	}

}
