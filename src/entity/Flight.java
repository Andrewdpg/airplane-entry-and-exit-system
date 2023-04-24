package entity;

public class Flight {

    public static final String PATH = "data/flight/";

    private Plane plane;
    private Passenger[][] passengers;
    private int onBoard;

    transient int currentX = -1;
    transient int currentY = 0;
    transient int xCount = 0;

    public Flight() {
    }

    public Flight(Plane plane, Passenger[][] passengers) {
        this.plane = plane;
        this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
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

    public int getOnBoard() {
        return onBoard;
    }

    public void setOnBoard(int onBoard) {
        this.onBoard = onBoard;
    }

    public Passenger nextPassenger() {
        Passenger current = null;
        nextX();
        for (; currentY < plane.getRows(); currentY++) {
            for (; xCount < plane.getColumns();) {
                xCount++;
                if ((current = passengers[currentY][currentX]) != null) {
                    onBoard--;
                    return current;
                }
                nextX();
            }
            xCount = 0;
        }
        return current;
    }

    public void extractPassenger() {
        passengers[currentY][currentX] = null;
    }

    public void nextX() {
        if (currentX == -1) {
            currentX = plane.getColumns() / 2 - 1;
            return;
        }
        int middleLeft = plane.getColumns() / 2 - 1;
        if (currentX <= middleLeft) {
            currentX = middleLeft + Math.abs(middleLeft - currentX) + 1;
        } else {
            if (currentX != plane.getColumns() - 1) {
                currentX = middleLeft - Math.abs(middleLeft - currentX);
            } else {
                currentX = middleLeft;
            }
        }
    }
}
