package org.example.ParkingLot;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

enum VehicleType{
    COMPACT,
    SUV,
    SEDAN
}
class  Vehicle{
    private String vehicleID;
    private  VehicleType type;

    //SETTER
    public  Vehicle(String vehicleID,VehicleType type){
        this.vehicleID=vehicleID;
        this.type=type;
    }
    // getter
    public  String getVehicleID(){
        return  vehicleID;
    }
    //getter
    public  VehicleType getVehicleType(){
        return  type;
    }
}
class  Ticket{
    private UUID ticketID;
    private  Vehicle vehicle;
    private  long entryTime;

    //setter
    public Ticket(Vehicle vehicle){

        this.ticketID=UUID.randomUUID();//Alternatively,vehicleID+ current Time
        this.vehicle=vehicle;
        this.entryTime=System.currentTimeMillis();

    }
    //setter


    public UUID getTicketID() {
        return ticketID;
    }
    //SETTER
    public  Vehicle getVehicle(){
      return  vehicle;
    }
    public long getEntryTime() {
        return entryTime;
    }
}
class  ParkingLot{
    private  int capacity;
    private  int availableSpace;
//    private Map<UUID,Vehicle> parkedVehicle;//parkedVehicle associated with id
private Map<UUID, Ticket> parkedVehicles;
    public  ParkingLot(int capacity){
        this.capacity=capacity;
        this.availableSpace=capacity;
        this.parkedVehicles=new HashMap<>();

    }

    //function
    public Ticket parkVehicle(Vehicle vehicle) {
        if (availableSpace > 0) {
            Ticket ticket = new Ticket(vehicle);

            parkedVehicles.put(ticket.getTicketID(), ticket);

            availableSpace--;

            return ticket;
        }

        System.out.println(" Parking lot full, no available space!");
        return null;
    }
    public void exitVehicle(Ticket ticket) {

        if (parkedVehicles.containsKey(ticket.getTicketID())) {

            parkedVehicles.remove(ticket.getTicketID());

            availableSpace++;

            long duration =
                    System.currentTimeMillis() - ticket.getEntryTime();

            double parkingFee = calculateFee(duration);

            System.out.println(
                    "Vehicle with vehicle number : "
                            + ticket.getVehicle().getVehicleID()
                            + " exit fee : "
                            + parkingFee
            );

        } else {
            System.out.println("Invalid ticket");
        }
    }
    public double calculateFee(long durationMilliSec) {
//        return  durationMilliSec*100;
//        can enforce a minimum one-hour charge:
        double hours = Math.max(
                1,
                Math.ceil(durationMilliSec / (1000.0 * 60 * 60))
        );

        return hours * 100;
    }
    public  int getAvailableSpace(){
        return  availableSpace;
    }
}

public class Main {
    public static void main(String[] args) {
        //here 10 is the park capacity
        ParkingLot parkingLot=new ParkingLot(10);
        Vehicle vehicle=new Vehicle("ABC123",VehicleType.COMPACT);
        Ticket ticket=parkingLot.parkVehicle(vehicle);
        System.out.println("Available space :" + parkingLot.getAvailableSpace()) ;
        System.out.println("Vehicle with id :" + vehicle.getVehicleID()+ " is parked. Ticket ID: " +ticket.getTicketID() );
        parkingLot.exitVehicle(ticket);
        System.out.println("Available space :" + parkingLot.getAvailableSpace()) ;

    }

//    Vehicle
//   ↓
//    parkVehicle()
//   ↓
//    Ticket created
//   ↓
//    Ticket stored in parkedVehicle
//   ↓
//    Vehicle exits
//   ↓
//    calculate duration
//   ↓
//    calculate fee
//   ↓
//    remove vehicle
//   ↓
//    availableSpace++
}
