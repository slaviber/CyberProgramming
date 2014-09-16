
public class Main {

	public static int ID1 = 10;
	public static int ID2 = 20;
	
	public static void main(String[] args) {
		Person John = new Person(ID1);
		Person Stephen = John;
		if(John == Stephen){
			for(int i = 0; i < 10; ++i){
				Person x = new Person(ID2+i);
				if(!x.equals(Stephen))System.out.println("it works!");
			}
		}
	}

}
