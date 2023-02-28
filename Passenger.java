import java.util.Set;

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
    @Override
    public String toString(){
        return name+", "+seatClass+", "+seatNumber;
    }
    public static void  main(String[] args) {
        
    }
}
