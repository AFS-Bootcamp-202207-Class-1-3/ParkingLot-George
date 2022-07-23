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
        return null;
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
        return parkingLots.get(0).fetch(parkingTicket);
    }
}
