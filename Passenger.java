package lab5;
import java.util.*;

public class Passenger {

    protected String seatClass;
    protected int seatNumber;
    protected String name;
    protected boolean checkedIn;
   
    public Passenger(String passengerName, String seat, int number){
        seatClass = seat;
        name = passengerName;
        seatNumber = number;
        checkedIn = false;
    }
    
    public void randomName() {
    	String[] first = new String[]{"Bob", "Bill", "Ted", "James", "Edward", "Lee", "Jeremy", "Rick",
    			"Anna", "Mary", "Beth", "Susan", "Ellie", "Laura", "Kelly", "Nina"};
    	String[] last = new String[] {"Jones", "Smith", "Baker", "Brown", "Wakeman", "Park", "McPhee",
    			"Pine", "O'Malley", "Chung", "Warner", "Goodman", "MacArthur", "Rogers", "Green", "Day"};
    	Random rand = new Random();
    	String randFirst = first[rand.nextInt(15)];
    	String randLast = last[rand.nextInt(15)];
    	name = randFirst + " " + randLast;
    }
    
    @Override
    public String toString(){
        return name + ", " + seatClass + ", " + seatNumber;
    }
    public static void  main(String[] args) {
    	
    	// testing constructor and toString method
    	Passenger test = new Passenger("John Doe", "B", 9);
    	System.out.println(test.toString());
        
    }
}
