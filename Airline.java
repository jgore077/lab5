import java.util.*;
import java.io.*;
public class Airline {

    Passenger[] passengers;
    int first=10;
    int buisness=10;
    int economy =20;
    public Airline(){
    passengers =new Passenger[40];
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
    public void boardPlane(){
        int multipleOfTen=1;
        for(int i=0;i<40;i++){
            //returing and jumping
            if(passengers[i]==null){
                if(i>20){
                    return;
                }
                i = 10*multipleOfTen;
                multipleOfTen++;
            }
            System.out.println(passengers[i]);
            passengers[i]=null;

        }

    }

    public void readPassengersFromFile(String filename) throws FileNotFoundException{

		// Scanner object to read from the file
     
		Scanner scanner = new Scanner(new File(filename));

		//// Reading the current line and spliting it into an array of Strings
		int index = 0;
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] data = line.split(" ");
			//// Creating a new Passenger object using the data above and adding it to the passengerList array
			addPassenger(new Passenger(data[0]+" "+data[1], data[3],Integer.parseInt(data[2])));
		}
    }

    /*
     * Designing testing will be wills job
     */
    public static void  main(String[] args) throws FileNotFoundException {
      Airline delta = new Airline();
      delta.readPassengersFromFile("Delta.txt");
      delta.boardPlane();
    }
}
