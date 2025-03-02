package parkingLot.runner;

import parkingLot.model.Level;
import parkingLot.model.Vehicle;


import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static ParkingLot parkingLot;

    private List<Level> levels = new ArrayList<>();

    public static synchronized ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addLevel(Level level){
        this.levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

}
