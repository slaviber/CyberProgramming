import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		final BufferedReader capitalize = new BufferedReader(new InputStreamReader(System.in));
		for(;;){
			System.out.print("CapsLock v.2 /> ");
			System.out.println(capitalize.readLine().toUpperCase());
		}

	}
}
