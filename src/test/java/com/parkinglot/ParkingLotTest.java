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
        Car fetchCar = parkingLot.fetch(car, parkingTicket);

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
        Car fetchCar1 = parkingLot.fetch(car1, parkingTicket1);
        Car fetchCar2 = parkingLot.fetch(car2, parkingTicket2);

        //then
        assertEquals(car1, fetchCar1);
        assertEquals(car2, fetchCar2);
    }

    @Test
    void should_return_nothing_when_fetch_car_given_parking_lot_and_wrong_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket(false);
        Car car = new Car();

        //when & then
        parkingLot.park(car);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(car, unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_return_nothing_when_fetch_car_given_parking_lot_and_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket(true);
        Car car = new Car();

        //when & then
        parkingLot.park(car);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(car, unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_park_car_given_without_any_parking_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(11);
        Car car = new Car();

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> parkingLot.park(car));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    void should_throw_unrecognized_ticket_exception_when_fetch_given_an_unrecognized_ticket() {
        //given
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket(false);
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();

        //when & then
        parkingLot.park(car);
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(car, unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

}
