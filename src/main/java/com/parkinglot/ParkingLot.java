package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {


    private int capacity = 10;
    private Map<ParkingTicket, Car> ticketCarMap = new HashMap<>();


    public ParkingLot(){}



    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket park(Car car) {
        if (capacity <= 10) {
            ParkingTicket parkingTicket = new ParkingTicket(false);
            ticketCarMap.put(parkingTicket, car);
            return parkingTicket;
        }
        return null;
    }

    public Car fetch(ParkingLot parkingLot, Car partedCar, ParkingTicket parkingTicket) {
        if (!parkingTicket.isUsed() && parkingLot.ticketCarMap.get(parkingTicket) == partedCar) {
            parkingTicket.setUsed(true);
            return partedCar;
        }
        return null;
    }
}
