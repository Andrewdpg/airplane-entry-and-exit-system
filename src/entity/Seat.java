package entity;

import entity.enums.SeatType;

public class Seat {

    private SeatType type;
    private Location location;

    public Seat(SeatType type, Location location) {
        this.type = type;
        this.location = location;
    }

    public SeatType getType() {
        return type;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return type.name() + "#" + location.toString();
    }
}
