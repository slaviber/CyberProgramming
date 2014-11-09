import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.naming.NameNotFoundException;


public class Main {

	private static final int HTTP_PORT = 80;
	private static final String SERVER = "www.example.com";
	private static final String PROTOCOL_VERSION = "HTTP/1.1";
	private static final String HTTP_METHOD_GET = "GET";


	public static void main(String[] args) throws UnknownHostException, IOException {
		Main http = new Main();
		Response response = null;
		String path = new String("/index.html");
		do{
			response = http.createRequest(SERVER, HTTP_METHOD_GET, path);
			try{
				path = response.getLocation();
			}
			catch(NameNotFoundException n){
				break;
			}
			
		}while(response.getStatusLine().split(" ")[1].startsWith("3"));
		System.out.println(response.getBody());


	}
	
	public Response createRequest(String host, String method, String path) throws UnknownHostException, IOException{
		final Socket clientSocket = new Socket(host, HTTP_PORT);

		final InputStream inputStream = clientSocket .getInputStream();
		final OutputStream outputStream = clientSocket.getOutputStream();
		
		final InputStreamReader inputStreamReader =
			new InputStreamReader(inputStream);
		final BufferedReader in = new BufferedReader(inputStreamReader);
		final PrintWriter out = new PrintWriter(outputStream);
		
		writeRequest(out, host, method, path);
		out.flush();
		
		final Response result = parseResponse(in);
		clientSocket.close();
		return result;
	}

	private Response parseResponse(BufferedReader in) throws IOException {
		final Response result = new Response();
		result.setStatusLine(in.readLine());
		String next;
		while(!(next = in.readLine()).equals("")){
			result.getHeaders().add(HttpHeader.createFromHeaderLine(next));
		}
		in.read(result.getBody());
		return result;
	}

	private void writeRequest(PrintWriter out, String host, String method, String path) {
		out.printf("%s %s %s\n", method, path, PROTOCOL_VERSION);
		out.printf("Host: %s\n", host);
		out.printf("\n");
		
	}

}
