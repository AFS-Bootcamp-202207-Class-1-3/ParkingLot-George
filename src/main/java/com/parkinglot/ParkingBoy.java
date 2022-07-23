package com.parkinglot;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

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
        ParkingTicket parkingTicket = null;
        List<String> exceptionMessages = new ArrayList<>();
        for (ParkingLot parkingLot : parkingLots) {
            try {
                parkingTicket = parkingLot.park(car);
                if (parkingTicket != null) {
                    return parkingTicket;
                }
            } catch (NoAvailablePositionException e) {
                exceptionMessages.add(e.getMessage());
                if (exceptionMessages.size() == parkingLots.size()) {
                    throw new NoAvailablePositionException();
                }
            }
        }
        return parkingTicket;
    }

    public Car fetch(ParkingTicket parkingTicket) {
        return parkingLots.get(0).fetch(parkingTicket);
    }
}
