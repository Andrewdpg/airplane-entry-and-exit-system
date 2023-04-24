package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import entity.enums.PassengerPreference;
import entity.enums.SeatType;

public class Passenger implements Comparable<Passenger> {

    public static final int ON_BOARD = 2;
    public static final int LISTED = 1;
    public static final int UNLISTED = 0;

    private String name;
    private String id;
    private String nationality;
    private LocalDate birthday;
    private int miles;
    private Seat seat;
    private PassengerPreference preference;

    transient int state;

    public Passenger() {
        state = UNLISTED;
    }

    public int getRow() {
        return getSeat().getLocation().getRow() - 1;
    }

    public int getColumn() {
        return getSeat().getLocation().getColumnValue() - 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthday, LocalDate.now());
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public PassengerPreference getPreference() {
        return preference;
    }

    public void setPreference(PassengerPreference preference) {
        this.preference = preference;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getState() {
        return this.state;
    }

    public static String[] headers() {
        return new String[] { "Nombre", "ID", "Nacionalidad", "Asiento" };
    }

    public String[] getTableData() {
        return new String[] { name, id, nationality, seat.toString() };
    }

    @Override
    public String toString() {
        return name + " - " + id + " - " + nationality + " - " + birthday.toString() + " - " + seat.toString();
    }

    @Override
    public int compareTo(Passenger o) {
        return id.compareTo(o.id);
    }

    public Double getPriority(Long initTime, Plane plane) {
        Double valuePerSection = valuePerSection(plane);
        Double priority = valuePerSection;
        if (seat.getType() == SeatType.FIRST_CLASS) {
            if (preference == PassengerPreference.MEDICAL_ATTENTION) {
                return valuePerSection * 1.9999999999;
            }
            if (getAge() >= 60) {
                priority += 2.2;
            }
            priority += 2.7 - (2.7 / (miles + 1));
        }
        priority += 5 / ((System.currentTimeMillis() - initTime) / 1000);
        return priority;
    }

    public Double valuePerSection(Plane plane) {
        for (int i = 1; i < plane.getSections().length+1; i++) {
            if (getRow() + 1 >= plane.getSections()[i-1].getStart() &&
                    getRow() + 1 <= plane.getSections()[i-1].getEnd()) {
                return 10.0 * i;
            }
        }
        return Double.MIN_VALUE;
    }
}