package lambda;

import entity.Passenger;
import exception.InvalidPassengerException;

public interface LoadToTable {
    
    public void load(Passenger passenger) throws InvalidPassengerException;
}
