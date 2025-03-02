package parkingLot.model;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private int floor;

    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    public Level(int floor, int slots){

        int car = slots/2;
        int motorcyle = slots/4;
        int truck = slots/4;

        for(int i = 0;i<car;i++){
            parkingSpots.add(new ParkingSpot(i+1,VehicleType.CAR));
        }
        for(int i = 0;i<motorcyle;i++){
            parkingSpots.add(new ParkingSpot(car+i+1,VehicleType.MOTORCYCLE));
        }
        for(int i = 0;i<truck;i++){
            parkingSpots.add(new ParkingSpot(car+ motorcyle +i+1,VehicleType.TRUCK));
        }

    }

    public boolean parkVehicle(Vehicle vehicle){
        for (ParkingSpot spot : parkingSpots) {
            if (spot.isAvailable() && spot.getVehicleType() == vehicle.getVehicleType()) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;

    }
}
