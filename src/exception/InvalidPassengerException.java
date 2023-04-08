package exception;

import entity.Passenger;

public class InvalidPassengerException extends Exception {

    private Passenger passenger;

    public InvalidPassengerException(Passenger passenger) {
        this.passenger = passenger;
    }

    public InvalidPassengerException(String message) {
        super(message);
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

}
