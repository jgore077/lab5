 public class Passenger {

    protected String seatClass;
    protected int seatNumber;
    protected String name;
    protected boolean checkedIn;
   
    public Passenger(String passengerName, String seat, int number){
        seatClass=seat;
        name=passengerName;
        seatNumber =number;
        checkedIn = false;
    }
    public static void  main(String[] args) {
        
    }
}
