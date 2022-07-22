package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_parking_ticket_when_park_car_given_parking_lot_and_car() {
        //given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);

        //then
        assertNotNull(parkingTicket);
        assertTrue(parkingTicket.isUsed());
    }

    @Test
    void should_return_parked_car_when_fetch_car_given_parking_lot_and_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket parkingTicket = new ParkingTicket(false);
        Car partedCar = new Car();

        //when
        Car fetchCar = parkingLot.fetch(parkingLot, partedCar, parkingTicket);

        //then
        assertEquals(partedCar, fetchCar);
        assertEquals(2, parkingLot.getParkCount());
        assertFalse(parkingTicket.isUsed());
    }

}
