package com.parkinglot;

import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;
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
        ParkingTicket parkingTicket = parkingLot.park(car);

        //when
        Car fetchCar = parkingLot.fetch(parkingTicket);

        //then
        assertEquals(car, fetchCar);
    }

    @Test
    void should_return_right_car_when_fetch_car_given_parking_lot_and_two_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);

        Car car1 = new Car();
        Car car2 = new Car();
        ParkingTicket parkingTicket1 = parkingLot.park(car1);
        ParkingTicket parkingTicket2 = parkingLot.park(car2);

        //when
        Car fetchCar1 = parkingLot.fetch(parkingTicket1);
        Car fetchCar2 = parkingLot.fetch(parkingTicket2);

        //then
        assertEquals(car1, fetchCar1);
        assertEquals(car2, fetchCar2);
    }

    @Test
    void
    should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_and_unrecognized_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        ParkingTicket unrecognizedParkingTicket = new ParkingTicket();

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(unrecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_fetch_car_given_parking_lot_and_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(3);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingLot.park(car);
        parkingLot.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLot.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_park_car_given_without_any_parking_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        parkingLot.park(car);

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> parkingLot.park(car));
        assertEquals("No available position", exception.getMessage());
    }

}
