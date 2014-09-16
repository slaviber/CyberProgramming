
public class Person {
	public int personID;
	Person(int ID){
		this.personID = ID;
	}
	
	public boolean equals(Person person){
		if(this.personID == person.personID)return true;
		return false;
	}
}
