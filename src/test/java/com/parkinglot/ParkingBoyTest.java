package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_parking_boy_park_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parked_car_when_parking_boy_fetch_car_given_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car exceptedCar = new Car();

        //when
        ParkingTicket parkingTicket = parkingBoy.park(exceptedCar);
        Car car = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(exceptedCar, car);
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_car_given_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car exceptedCar1 = new Car();
        Car exceptedCar2 = new Car();
        ParkingTicket parkingTicket1 = parkingBoy.park(exceptedCar1);
        ParkingTicket parkingTicket2 = parkingBoy.park(exceptedCar2);

        //when
        Car car1 = parkingBoy.fetch(parkingTicket1);
        Car car2 = parkingBoy.fetch(parkingTicket2);

        //then
        assertEquals(exceptedCar1, car1);
        assertEquals(exceptedCar2, car2);
    }

    @Test
    void should_throw_unrecognized_paring_ticket_exception_when_parking_boy_fetch_car_given_unrecognized_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingBoy.fetch(unRecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }
}
