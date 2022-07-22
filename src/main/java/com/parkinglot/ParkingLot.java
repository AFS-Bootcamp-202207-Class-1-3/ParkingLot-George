package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private static int capacity = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();


    public ParkingLot(){}



    public ParkingLot(int capacity) {
        ParkingLot.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (capacity <= 10) {
            ParkingTicket parkingTicket = new ParkingTicket(false);
            ticketCarMap.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    public Car fetch(Car partedCar, ParkingTicket parkingTicket) {
        if (!parkingTicket.isUsed() && ticketCarMap.get(parkingTicket) == partedCar) {
            parkingTicket.setUsed(true);
            return partedCar;
        }
        throw new UnrecognizedParkingTicketException();
    }
}
