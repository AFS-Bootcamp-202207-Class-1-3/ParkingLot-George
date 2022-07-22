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
        ParkingTicket parkingTicket = new ParkingTicket(true);
        Car partedCar = new Car();

        //when
        Car fetchCar = parkingLot.fetch(parkingLot, partedCar, parkingTicket);

        //then
        assertEquals(partedCar, fetchCar);
        assertEquals(2, parkingLot.getParkCount());
        assertFalse(parkingTicket.isUsed());
    }

    @Test
    void should_return_right_car_when_fetch_car_given_parking_lot_and_two_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket parkingTicket1 = new ParkingTicket(true);
        ParkingTicket parkingTicket2 = new ParkingTicket(true);
        Car partedCar1 = new Car();
        Car partedCar2 = new Car();

        //when
        Car fetchCar1 = parkingLot.fetch(parkingLot, partedCar1, parkingTicket1);
        Car fetchCar2 = parkingLot.fetch(parkingLot, partedCar2, parkingTicket2);

        //then
        assertEquals(partedCar1, fetchCar1);
        assertEquals(partedCar2, fetchCar2);
        assertEquals(1, parkingLot.getParkCount());
        assertFalse(parkingTicket1.isUsed());
        assertFalse(parkingTicket2.isUsed());
    }

    @Test
    void should_return_nothing_when_fetch_car_given_parking_lot_and_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket parkingTicket = new ParkingTicket(false);
        Car partedCar = new Car();

        //when
        Car fetchCar = parkingLot.fetch(parkingLot, partedCar, parkingTicket);

        //then
        assertNull(fetchCar);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_parking_lot_and_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket parkingTicket = new ParkingTicket(true);
        Car partedCar = new Car();

        //when
        Car fetchCar = parkingLot.fetch(parkingLot, partedCar, parkingTicket);

        //then
        assertNull(fetchCar);
    }

}
