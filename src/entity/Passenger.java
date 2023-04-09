package entity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import entity.enums.PassengerPreference;

public class Passenger implements Comparable<Passenger> {

    private String name;
    private String id;
    private String nationality;
    private LocalDate birthday;
    private Seat seat;
    private PassengerPreference preference;

    public Passenger() {
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
        return 0.0;
    }
}