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

    }

    /*
     * I reccomend you start from index 0 then go till you find a null
     *  then jump to index 10 and then once you find a null in the 10s
     * jump to the 20s
     */
    public void boardPlane(ArrayList<Passenger> passengersList){
        /*Write your code here */

    }
    //for anusha for example this method would be called readPassengersFromFile(delta.txt)
    public ArrayList<Passenger> readPassengersFromFile(String filename){
        ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
        /*Write your code here */
        return passengerList;
    }



    /*
     * Designing testing will be wills job
     */
    public static void  main(String[] args) {


    }
}
