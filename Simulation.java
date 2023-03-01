package lab5;
import java.util.*;
import java.io.*;

public class Simulation {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		String input = "";
		String flight = "";
		String bookName = "";
		String bookClass = "";
		int bookSeatNum = 0;
		boolean backToStart = true;
		
		Airline delta = new Airline("Delta");
		delta.readPassengersFromFile("Delta.txt");
		Airline united = new Airline("United");
		united.readPassengersFromFile("United.txt");
		
		while (backToStart == true) {
			System.out.println("\nWelcome to Eclipse International Airport!");
			System.out.println("Choose an option to continue:");
			System.out.println("1) Check-in");
			System.out.println("2) Book");
			System.out.println("3) Board");
			backToStart = false;
			input = sc.nextLine();
			if (input.compareTo("1") == 0) {
				boolean invalidSelection = true;
				System.out.println("You have selected check-in.");
				System.out.println("Choose which airline the passenger is checking in for:");
				System.out.println("1) Delta\n2) United");
				while (invalidSelection == true) {
					input = sc.nextLine();
					if (input.compareTo("1") == 0) {
						flight = "Delta";
						invalidSelection = false;
					}
					else if (input.compareTo("2") == 0) {
						flight = "United";
						invalidSelection = false;
					}
					else {
						System.out.println("Invalid selection. Enter 1 for Delta or 2 for United.");
					}
				}
				System.out.println("Enter the name of the passenger who is checking in:");
				input = sc.nextLine();
				if (flight.compareTo("Delta") == 0) {
					delta.checkInAtGate(delta, input);
				}
				else if (flight.compareTo("United") == 0) {
					united.checkInAtGate(united, input);
				}
				backToStart = true;
			}
			else if (input.compareTo("2") == 0) {
				boolean invalidSelection = true;
				System.out.println("You have selected booking.");
				System.out.println("Choose which airline you are booking for:");
				System.out.println("1) Delta\n2) United");
				while (invalidSelection == true) {
					input = sc.nextLine();
					if (input.compareTo("1") == 0) {
						flight = "Delta";
						invalidSelection = false;
					}
					else if (input.compareTo("2") == 0) {
						flight = "United";
						invalidSelection = false;
					}
					else {
						System.out.println("Invalid selection. Enter 1 for Delta or 2 for United.");
					}
				}
				System.out.println("Enter your name:");
				bookName = sc.nextLine();
				System.out.println("Choose the seat class you would like to book for:");
				System.out.println("1) First class\n2) Business class\n3) Economy class");
				invalidSelection = true;
				while (invalidSelection == true) {
					input = sc.nextLine();
					if (input.compareTo("1") == 0) {
						// first class
						bookClass = "F";
						invalidSelection = false;
					}
					else if (input.compareTo("2") == 0) {
						// business class
						bookClass = "B";
						invalidSelection = false;
					}
					else if (input.compareTo("3") == 0) {
						// economy class
						bookClass = "E";
						invalidSelection = false;
					}
					else {
						System.out.println("Invalid selection. Enter 1 for first class, 2 for business class, or 3 for economy class.");
					}
				}
				if (bookClass == "F") {
					for (int i = 0; i < 10; i++) {
						if (flight.compareTo("Delta") == 0) {
							if (delta.passengers[i] == null) {
								bookSeatNum = i + 1;
								break;
							}
						}
						else if (flight.compareTo("United") == 0) {
							if (united.passengers[i] == null) {
								bookSeatNum = i + 1;
								break;
							}
						}
					}
				}
				else if (bookClass == "B") {
					for (int i = 10; i < 20; i++) {
						if (flight.compareTo("Delta") == 0) {
							if (delta.passengers[i] == null) {
								bookSeatNum = i  - 9;
								break;
							}
						}
						else if (flight.compareTo("United") == 0) {
							if (united.passengers[i] == null) {
								bookSeatNum = i - 9;
								break;
							}
						}
					}	
				}
				else if (bookClass == "E") {
					for (int i = 20; i < 40; i++) {
						if (flight.compareTo("Delta") == 0) {
							if (delta.passengers[i] == null) {
								bookSeatNum = i  - 19;
								break;
							}
						}
						else if (flight.compareTo("United") == 0) {
							if (united.passengers[i] == null) {
								bookSeatNum = i - 19;
								break;
							}
						}
					}	
				}
				Passenger newPassenger = new Passenger(bookName, bookClass, bookSeatNum);
				if (flight == "Delta") {
					delta.addPassenger(newPassenger);
				}
				else if (flight == "United") {
					united.addPassenger(newPassenger);
				}
				backToStart = true;

			}
			else if (input.compareTo("3") == 0) {
				System.out.println("You have selected boarding.");
				int decision = Airline.generateDecision();
				// generate random outcome for delta flight
				if (decision == 1) {
					Random rand = new Random();
					boolean removedPassenger = false;
					while (removedPassenger == false) {
						int index = rand.nextInt(39);
						if (delta.passengers[index] != null) {
							System.out.print(delta.passengers[index].name + " did not show up for their flight.");
							delta.passengers[index] = null;
							removedPassenger = true;
						}
					}
				}
				else if (decision == 2) {
					// add 1-10 passengers to flight
					System.out.println("New passengers have booked for the Delta flight.");
				}
				
				decision = Airline.generateDecision();
				// generate random outcome for united flight
				if (decision == 1) {
					Random rand = new Random();
					boolean removedPassenger = false;
					while (removedPassenger == false) {
						int index = rand.nextInt(39);
						if (united.passengers[index] != null) {
							System.out.print(united.passengers[index].name + " did not show up for their flight.");
							united.passengers[index] = null;
							removedPassenger = true;
						}
					}
				}
				else if (decision == 2) {
					// add 1-10 passengers to flight
					System.out.println("New passengers have booked for the United flight.");
				}
				
				delta.boardPlane();
				united.boardPlane();
			}
			else {
				System.out.println("Invalid selection. Enter 1 for check-in, 2 for booking, or 3 for boarding.");
				backToStart = true;
			}
		}
	}
	
}
