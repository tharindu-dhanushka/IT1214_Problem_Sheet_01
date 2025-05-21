class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    public Vehicle(String licensePlate, String ownerName, int hoursParked) {
        setLicensePlate(licensePlate);
        setOwnerName(ownerName);
        setHoursParked(hoursParked);
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    @Override
    public String toString() {
        return "License Plate: " + licensePlate + ", Owner: " + ownerName + ", Hours Parked: " + hoursParked;
    }
}

class ParkingLot {
    private Vehicle[] vehicles;
    private int count;

    public ParkingLot(int capacity) {
        vehicles = new Vehicle[capacity];
        count = 0;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (count < vehicles.length) {
            vehicles[count] = vehicle;
            count++;
            System.out.println("Vehicle parked: " + vehicle.getLicensePlate());
        } else {
            System.out.println("Parking lot is full.");
        }
    }

    public void removeVehicle(String licensePlate) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Vehicle not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            vehicles[i] = vehicles[i + 1];
        }

        vehicles[count - 1] = null;
        count--;
        System.out.println("Vehicle removed: " + licensePlate);
    }

    public void displayVehicles() {
        if (count == 0) {
            System.out.println("No vehicles parked.");
        } else {
            System.out.println("Parked Vehicles:");
            for (int i = 0; i < count; i++) {
                System.out.println(vehicles[i]);
            }
        }
    }
}

public class Question02 {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(5);

        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        lot.removeVehicle("XYZ789");

        lot.displayVehicles();
    }
}