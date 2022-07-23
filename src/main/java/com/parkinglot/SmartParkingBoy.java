package com.parkinglot;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SmartParkingBoy {
    List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        int maxEmptyPosition = calculateEmptyPosition(parkingLots.get(0));
        ParkingLot maxEmptyPositionParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            maxEmptyPositionParkingLot = maxEmptyPosition >= calculateEmptyPosition(parkingLot)
                    ? maxEmptyPositionParkingLot
                    : parkingLot;
        }
        return maxEmptyPositionParkingLot.park(car);
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

    private int calculateEmptyPosition(ParkingLot parkingLot) {
        return parkingLot.capacity - parkingLot.ticketCarMap.size();
    }
}
