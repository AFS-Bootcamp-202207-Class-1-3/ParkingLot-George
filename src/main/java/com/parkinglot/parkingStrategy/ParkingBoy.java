package com.parkinglot.parkingStrategy;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingTicket;

public interface ParkingBoy {
    ParkingTicket park(Car car);
}
