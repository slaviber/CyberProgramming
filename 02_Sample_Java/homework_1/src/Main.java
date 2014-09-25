import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Map<String, Integer> countries = new HashMap<String, Integer>();
		Scanner inputStream = new Scanner(new File("countries.csv"));
		while(inputStream.hasNextLine()){
			String data = inputStream.nextLine();
			String[] values = data.split(", ");
			countries.put(values[0], Integer.parseInt(values[1]));
		}
		inputStream.close();
		for(String country : countries.keySet()){
			if(countries.get(country) > 10000000){
				System.out.println(country);
			}
		}
		
	}
}
