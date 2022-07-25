package com.parkinglot.parkingStrategy;

import com.parkinglot.exception.UnrecognizedParkingTicketException;
import com.parkinglot.ParkingLot;
import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingTicket;

import java.util.*;

public class SmartParkingBoy extends GeneralParkingBoy implements ParkingBoy{
    List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
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

    private int calculateEmptyPosition(ParkingLot parkingLot) {
        return parkingLot.capacity - parkingLot.ticketCarMap.size();
    }
}
