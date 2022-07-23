package com.parkinglot;

import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingBoy() {
    }

    public ParkingTicket park(Car car) {
        return parkingLots.get(0).park(car);
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLots.get(0).fetch(parkingTicket);
    }
}
