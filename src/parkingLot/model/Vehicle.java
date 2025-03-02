package parkingLot.model;

public abstract class Vehicle {
    private String numberPlate;

    private VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType vehicleType){
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
