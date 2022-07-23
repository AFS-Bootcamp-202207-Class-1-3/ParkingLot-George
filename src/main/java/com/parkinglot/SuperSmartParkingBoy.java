package com.parkinglot;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class SuperSmartParkingBoy {
    List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        float maxEmptyPositionRate = calculatePositionRate(parkingLots.get(0));
        ParkingLot maxEmptyPositionRateParkingLot = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            maxEmptyPositionRateParkingLot = maxEmptyPositionRate <= calculatePositionRate(parkingLot)
                    ? maxEmptyPositionRateParkingLot
                    : parkingLot;
        }
        return maxEmptyPositionRateParkingLot.park(car);
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

    private float calculatePositionRate(ParkingLot parkingLot) {
        DecimalFormat decimalFormat=new DecimalFormat("0.00");
        return Float.parseFloat(decimalFormat
                .format((float)parkingLot.ticketCarMap.size() / parkingLot.capacity));
    }

}
