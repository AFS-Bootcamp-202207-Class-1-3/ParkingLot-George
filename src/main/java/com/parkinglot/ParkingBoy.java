package com.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingBoy() {
    }

    public ParkingTicket park(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            ParkingTicket parkingTicket = generateParkingTicket(car, parkingLot);
            if (parkingTicket != null) return parkingTicket;
        }
        throw new NoAvailablePositionException();
    }

    private ParkingTicket generateParkingTicket(Car car, ParkingLot parkingLot) {
        List<String> exceptionMessages = new ArrayList<>();
        try {
            return parkingLot.park(car);
        } catch (NoAvailablePositionException e) {
            exceptionMessages.add(e.getMessage());
            if (exceptionMessages.size() == parkingLots.size()) {
                throw new NoAvailablePositionException();
            }
        }
        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = generateParkedCar(parkingTicket, parkingLot);
            if (car != null) return car;
        }
        throw new UnrecognizedParkingTicketException();
    }

    private Car generateParkedCar(ParkingTicket parkingTicket, ParkingLot parkingLot) {
        List<String> exceptionMessages = new ArrayList<>();
        try {
            return parkingLot.fetch(parkingTicket);
        }catch (UnrecognizedParkingTicketException e) {
            exceptionMessages.add(e.getMessage());
            if (exceptionMessages.size() == parkingLots.size()) {
                throw new UnrecognizedParkingTicketException();
            }
        }
        return null;
    }
}
