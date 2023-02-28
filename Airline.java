import java.util.*;

public class Airline {

    Passenger[] passengers;
    int first=10;
    int buisness=10;
    int economy =20;
    public Airline(){
    passengers =new Passenger[30];
    }

    public void addPassenger(Passenger person){
        switch(person.seatClass){
            case "F":
                passengers[person.seatNumber-1] = person;
                first--;
                break;
            case "B":
                passengers[10+person.seatNumber-1] = person;
                buisness--;
                break;
            default:
                passengers[20+person.seatNumber-1] = person;
                economy--;
            }
    }
    public void checkInAtGate(Airline plane,String passengerName){
        Passenger passenger = null;
		// Find the passenger in the booked passengers list
		for (Passenger pass : plane.passengers) {
			if (pass != null && pass.name.equalsIgnoreCase(passengerName)) {
				passenger = pass;
				break;
			}
		}
		if (passenger == null) {
			System.out.println("Passenger not found!");
			return;
		}
		// Check if the passenger has already checked in
		if (passenger.checkedIn) {
			System.out.println(passenger.name + " has already checked in!");
			return;
		}
		// Mark the passenger as checked in
		passenger.checkedIn = true;
		// Print the boarding pass
		System.out.println("Boarding pass:");
		System.out.println("Passenger name: " + passenger.name);
		System.out.println("Class: " + passenger.seatClass);
		System.out.println("Seat number: " + passenger.seatNumber);
    }

    /*
     * I reccomend you start from index 0 then go till you find a null
     *  then jump to index 10 and then once you find a null in the 10s
     * jump to the 20s.     */
    public void boardPlane(Passenger[] passengersList){
        /*Write your code here */

    }
    //for anusha for example this method would be called readPassengersFromFile(delta.txt)
    public Passenger[] readPassengersFromFile(String filename){
        // Creating an array to store Passenger objects
		Passenger[] passengerList = new Passenger[30];

		// Scanner object to read from the file
		Scanner scanner = new Scanner(new File("Delta.txt"));

		//// Reading the current line and spliting it into an array of Strings
		int index = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(",");

			// Taking out the relevant data
			String name = data[0];
			String seatClass = data[1];
			int seatNumber = Integer.parseInt(data[2]);//parse.Int converts the string to an int primitive data type


			//// Creating a new Passenger object using the data above and adding it to the passengerList array
			passengerList[index] = new Passenger(name, seatClass, seatNumber);
			index++;
		}
		return passengerList;
    }



    /*
     * Designing testing will be wills job
     */
    public static void  main(String[] args) {


    }
}
