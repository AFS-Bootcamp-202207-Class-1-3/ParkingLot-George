package com.parkinglot.parkingStrategy;

import com.parkinglot.ParkingLot;
import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;

import java.util.ArrayList;
import java.util.List;

public class GeneralParkingBoy implements ParkingBoy {

    List<ParkingLot> parkingLots;

    public GeneralParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
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
        } catch (UnrecognizedParkingTicketException e) {
            exceptionMessages.add(e.getMessage());
            if (exceptionMessages.size() == parkingLots.size()) {
                throw new UnrecognizedParkingTicketException();
            }
        }
        return null;
    }
}
