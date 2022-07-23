package com.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static final int DEFAULT_CAPACITY = 10;
    Map<ParkingTicket, Car> ticketCarMap;
    public final int capacity;

    public ParkingLot() {
        this(DEFAULT_CAPACITY);
    }

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        ticketCarMap = new HashMap<>();
    }

    public ParkingTicket park(Car car) throws NoAvailablePositionException {
        if (isHasPosition()) {
            ParkingTicket parkingTicket = new ParkingTicket();
            ticketCarMap.put(parkingTicket, car);
            return parkingTicket;
        }
        throw new NoAvailablePositionException();
    }

    private boolean isHasPosition() {
        return ticketCarMap.size() < capacity;
    }

    public Car fetch(ParkingTicket parkingTicket) throws UnrecognizedParkingTicketException{
        if (isRecognizedParkingTicket(parkingTicket)) {
            Car car = ticketCarMap.get(parkingTicket);
            ticketCarMap.remove(parkingTicket);
            return car;
        }
        throw new UnrecognizedParkingTicketException();
    }

    private boolean isRecognizedParkingTicket(ParkingTicket parkingTicket) {
        return ticketCarMap.containsKey(parkingTicket);
    }
}
