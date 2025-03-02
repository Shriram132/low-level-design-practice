package parkingLot.model;

public class ParkingSpot {

    int id;
    private VehicleType vehicleType;
    private Vehicle parkedVehicle;

    public ParkingSpot(int id , VehicleType vehicleType){
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public boolean parkVehicle(Vehicle vehicle){
        if(vehicle.getVehicleType() == vehicleType){
            parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    public boolean isAvailable(){
        return parkedVehicle == null;
    }

    public void unparkVehicle(){
        parkedVehicle = null;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }
}
