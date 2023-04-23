package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import entity.Flight;
import entity.Location;
import entity.Passenger;
import entity.Plane;
import entity.Seat;
import entity.enums.PassengerPreference;
import entity.enums.SeatType;
import exception.InvalidPassengerException;
import lambda.LoadToTable;

public class Storage {

    public static <T> Boolean saveJsonTo(String path, T obj) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            String data = new Gson().toJson(obj);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(data);
            writer.flush();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static <T> T loadJsonFrom(String path, Class<T> type) throws IOException, FileNotFoundException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String content = "";
        String line = "";
        while ((line = reader.readLine()) != null) {
            content += line + "\n";
        }
        T data = new Gson().fromJson(content, type);
        reader.close();
        return data;
    }

    public static String[] getFileNamesAt(String path) {
        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            return null;
        }
        return folder.list();
    }

    public static boolean deleteFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
    }

    public static String[] currentFlights() {
        return Storage.getFileNamesAt(Flight.PATH);
    }

    public static String[] availablePlanes() {
        int flightCount = 0;
        String[] currentFlights = Storage.getFileNamesAt(Flight.PATH);
        String[] temp = Storage.getFileNamesAt(Plane.PATH);
        Data.quicksort(currentFlights);
        Data.quicksort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (Data.binarySearch(currentFlights, temp[i]) != -1) {
                temp[i] = null;
                flightCount++;
            }
        }
        String[] availablePlane = new String[temp.length - flightCount];
        for (int i = 0, j = 0; i < availablePlane.length;) {
            if (temp[j] != null) {
                availablePlane[i] = temp[j];
                i++;
            }
            j++;
        }
        return availablePlane;
    }

    public static HashTable<String, Passenger> loadPassengersTxtFrom(String path, LoadToTable tableAction)
            throws IOException, FileNotFoundException, InvalidPassengerException {
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        HashTable<String, Passenger> hashTable = new HashTable<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            Passenger passenger = new Passenger();
            passenger.setName(line.split(";")[0]);
            passenger.setId(line.split(";")[1]);
            passenger.setNationality(line.split(";")[2]);
            passenger.setBirthday(LocalDate.of(Integer.parseInt(line.split(";")[3].split("/")[2]),
                    Integer.parseInt(line.split(";")[3].split("/")[1]),
                    Integer.parseInt(line.split(";")[3].split("/")[0])));
            passenger.setMiles(Integer.parseInt(line.split(";")[4]));
            passenger.setSeat(new Seat(SeatType.values()[Integer.parseInt(
                    line.split(";")[5])], new Location(
                            Integer.parseInt(line.split(";")[7]), line.split(";")[6])));
            passenger.setPreference(PassengerPreference.values()[Integer.parseInt(
                    line.split(";")[8])]);
            hashTable.put(passenger.getId(), passenger);
            tableAction.load(passenger);
        }
        reader.close();
        if (hashTable.size() == 0) {
            return null;
        }
        return hashTable;
    }
}
