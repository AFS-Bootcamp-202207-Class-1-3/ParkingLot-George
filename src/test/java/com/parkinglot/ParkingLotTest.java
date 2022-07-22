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
    }

    @Test
    void should_return_parked_car_when_fetch_car_given_parking_lot_and_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(parkingLot, car, parkingTicket);

        //then
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_parking_lot_and_two_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);

        Car car1 = new Car();
        Car car2 = new Car();

        //when
        ParkingTicket parkingTicket1 = parkingLot.park(car1);
        ParkingTicket parkingTicket2 = parkingLot.park(car2);
        Car fetchCar1 = parkingLot.fetch(parkingLot, car1, parkingTicket1);
        Car fetchCar2 = parkingLot.fetch(parkingLot, car2, parkingTicket2);

        //then
        assertEquals(car1, fetchCar1);
        assertEquals(car2, fetchCar2);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_parking_lot_and_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket parkingTicket = new ParkingTicket(false);
        Car car = new Car();

        //when
        parkingLot.park(car);
        Car fetchCar = parkingLot.fetch(parkingLot, car, parkingTicket);

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

    @Test
    void should_return_nothing_when_fetch_car_given_without_any_parking_position_and_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        Car car = new Car();

        //when
        ParkingTicket ticket = parkingLot.park(car);

        //then
        assertNotNull(ticket);
    }

}
