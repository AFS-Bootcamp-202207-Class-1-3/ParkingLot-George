package com.parkinglot;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy() {
    }

    public ParkingTicket park(Car car) {
        return parkingLot.park(car);
    }

    public Car fetch(Car exceptedCar, ParkingTicket parkingTicket) {
        return parkingLot.fetch(parkingTicket);
    }
}