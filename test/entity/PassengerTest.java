package test.entity;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import entity.Location;
import entity.Passenger;
import entity.Plane;
import entity.Seat;
import entity.Section;
import entity.enums.PassengerPreference;
import entity.enums.SeatType;

public class PassengerTest {

    Plane plane;
    Passenger a;
    Passenger b;

    public void setupPlane() {
        plane = new Plane("A", 6, 20, null);
        plane.setSections(new Section[] { new Section(1, 5), new Section(6, 10), new Section(11, 15),
                new Section(16, 20) });
    }

    public void setupPassengers() {
        a = new Passenger();
        b = new Passenger();
    }

    @Test
    public void priorityPerSectionTest() {
        setupPlane();
        setupPassengers();

        a.setSeat(new Seat(SeatType.ECONOMIC, new Location(6, "A")));
        b.setSeat(new Seat(SeatType.ECONOMIC, new Location(1, "A")));
        Long initTime = System.currentTimeMillis() - 1000;

        assertTrue(a.getPriority(initTime, plane) > b.getPriority(initTime, plane));
    }

    @Test
    public void priorityPerTimeTest() throws InterruptedException {
        setupPlane();
        setupPassengers();

        a.setSeat(new Seat(SeatType.ECONOMIC, new Location(1, "A")));
        b.setSeat(new Seat(SeatType.ECONOMIC, new Location(1, "B")));
        Long initTime = System.currentTimeMillis() - 1000;
        double arrivedFirstPriority = a.getPriority(initTime, plane);
        Thread.sleep(1000);
        double arrivedSecondPriority = b.getPriority(initTime, plane);

        assertTrue(arrivedFirstPriority > arrivedSecondPriority);
    }

    @Test
    public void priorityPerThirdAgeTest() throws InterruptedException {
        setupPlane();
        setupPassengers();

        a.setSeat(new Seat(SeatType.FIRST_CLASS, new Location(1, "A")));
        b.setSeat(new Seat(SeatType.FIRST_CLASS, new Location(1, "B")));
        a.setBirthday(LocalDate.parse("10/10/1950", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        b.setBirthday(LocalDate.parse("10/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        Long initTime = System.currentTimeMillis() - 1000;

        assertTrue(a.getPriority(initTime, plane) > b.getPriority(initTime, plane));
    }
    
    @Test
    public void priorityPerMilesTest() throws InterruptedException {
        setupPlane();
        setupPassengers();

        a.setSeat(new Seat(SeatType.FIRST_CLASS, new Location(1, "A")));
        b.setSeat(new Seat(SeatType.FIRST_CLASS, new Location(1, "B")));
        a.setBirthday(LocalDate.parse("10/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        b.setBirthday(LocalDate.parse("10/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        a.setMiles(1000);
        b.setMiles(500);
        Long initTime = System.currentTimeMillis() - 1000;

        assertTrue(a.getPriority(initTime, plane) > b.getPriority(initTime, plane));
    }
    
    @Test
    public void priorityPerMedicalAttentionTest() throws InterruptedException {
        setupPlane();
        setupPassengers();

        a.setSeat(new Seat(SeatType.FIRST_CLASS, new Location(1, "A")));
        b.setSeat(new Seat(SeatType.FIRST_CLASS, new Location(1, "B")));
        a.setBirthday(LocalDate.parse("10/10/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        b.setBirthday(LocalDate.parse("10/10/1950", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        a.setMiles(0);
        b.setMiles(20000);
        a.setPreference(PassengerPreference.MEDICAL_ATTENTION);
        b.setPreference(PassengerPreference.NONE);
        Long initTime = System.currentTimeMillis() - 1000;

        assertTrue(a.getPriority(initTime, plane) > b.getPriority(initTime, plane));
    }
}
