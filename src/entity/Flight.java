package entity;

public class Flight {

    public static final String PATH = "data/flight/";

    private Plane plane;
    private Passenger[][] passengers;
    private int onBoard;

    public Flight() {
    }

    public Flight(Plane plane, Passenger[][] passengers) {
        this.plane = plane;
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger){
        passengers[passenger.getRow()][passenger.getColumn()] = passenger;
        onBoard++;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Passenger[][] getPassengers() {
        return passengers;
    }

    public void setPassengers(Passenger[][] passengers) {
        this.passengers = passengers;
    }

    public Passenger extractPassenger(){
        onBoard--;
        return null;
    }

    public int getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(int onBoard) {
        this.onBoard = onBoard;
    }
    
}
