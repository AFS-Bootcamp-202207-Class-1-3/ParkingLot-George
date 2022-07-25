package com.parkinglot.parkingStrategy;

import com.parkinglot.ParkingLot;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.entity.Car;

import java.text.DecimalFormat;
import java.util.List;

public class SuperSmartParkingBoy extends GeneralParkingBoy implements ParkingBoy {
    List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
        this.parkingLots = parkingLots;
    }

    public ParkingTicket park(Car car) {
        float maxEmptyPositionRate = calculatePositionRate(parkingLots.get(0));
        ParkingLot maxEmptyPositionRateParkingLot = parkingLots.stream()
                .reduce((maxRateParkingLot, parkingLot) -> maxEmptyPositionRate <= calculatePositionRate(parkingLot)
                        ? maxRateParkingLot : parkingLot).get();
        return maxEmptyPositionRateParkingLot.park(car);
    }

    private float calculatePositionRate(ParkingLot parkingLot) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return Float.parseFloat(decimalFormat.format((float) parkingLot.ticketCarMap.size() / parkingLot.capacity));
    }

}
