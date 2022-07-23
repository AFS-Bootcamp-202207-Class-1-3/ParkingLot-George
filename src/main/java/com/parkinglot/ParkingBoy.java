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
        List<String> exceptionMessages = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
            ParkingTicket parkingTicket = generateParkingTicket(car, exceptionMessages, parkingLot);
            if (parkingTicket != null) return parkingTicket;
        }
        return null;
    }

    private ParkingTicket generateParkingTicket(Car car, List<String> exceptionMessages, ParkingLot parkingLot) {
        ParkingTicket parkingTicket;
        try {
            parkingTicket = parkingLot.park(car);
            if (parkingTicket != null) return parkingTicket;
        } catch (NoAvailablePositionException e) {
            exceptionMessages.add(e.getMessage());
            if (exceptionMessages.size() == parkingLots.size()) {
                throw new NoAvailablePositionException();
            }
        }
        return null;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLots.get(0).fetch(parkingTicket);
    }
}
