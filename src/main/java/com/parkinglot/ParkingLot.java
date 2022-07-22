package com.parkinglot;

public class ParkingLot {


    private int parkCount;


    public int getParkCount() {
        return parkCount;
    }

    public ParkingLot(){}

    public void setParkCount(int parkCount) {
        this.parkCount = parkCount;
    }

    public ParkingLot(int parkCount) {
        this.parkCount = parkCount;
    }

    public ParkingTicket park(Car car) {
        return new ParkingTicket( true);
    }

    public Car fetch(ParkingLot parkingLot, Car partedCar, ParkingTicket parkingTicket) {
        if (parkingTicket.isUsed()) {
            parkingLot.setParkCount(parkingLot.parkCount-1);
            parkingTicket.setUsed(false);
            return partedCar;
        }
        return null;
    }
}
