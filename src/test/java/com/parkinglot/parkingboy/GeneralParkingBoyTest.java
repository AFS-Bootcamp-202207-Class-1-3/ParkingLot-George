package com.parkinglot.parkingboy;

import com.parkinglot.ParkingLot;
import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.exception.NoAvailablePositionException;
import com.parkinglot.exception.UnrecognizedParkingTicketException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralParkingBoyTest {
    @Test
    void should_return_parking_ticket_when_parking_boy_park_given_parking_lot_and_car() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Collections.singletonList(new ParkingLot()));
        Car car = new Car();

        //when
        ParkingTicket parkingTicket = generalParkingBoy.park(car);

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parked_car_when_parking_boy_fetch_car_given_parking_ticket() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Collections.singletonList(new ParkingLot()));
        Car exceptedCar = new Car();
        ParkingTicket parkingTicket = generalParkingBoy.park(exceptedCar);

        //when
        Car car = generalParkingBoy.fetch(parkingTicket);

        //then
        assertEquals(exceptedCar, car);
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_car_given_parked_cars() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Collections.singletonList(new ParkingLot()));
        Car exceptedCar1 = new Car();
        Car exceptedCar2 = new Car();
        ParkingTicket parkingTicket1 = generalParkingBoy.park(exceptedCar1);
        ParkingTicket parkingTicket2 = generalParkingBoy.park(exceptedCar2);

        //when
        Car car1 = generalParkingBoy.fetch(parkingTicket1);
        Car car2 = generalParkingBoy.fetch(parkingTicket2);

        //then
        assertEquals(exceptedCar1, car1);
        assertEquals(exceptedCar2, car2);
    }

    @Test
    void
    should_throw_unrecognized_parking_ticket_exception_when_parking_boy_fetch_car_given_unrecognized_parking_ticket() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> generalParkingBoy.fetch(unRecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_parking_boy_fetch_car_given_used_parking_ticket() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Collections.singletonList(new ParkingLot()));
        ParkingTicket parkingTicket = generalParkingBoy.park(new Car());
        generalParkingBoy.fetch(parkingTicket);


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> generalParkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_parking_boy_fetch_car_given_without_any_position() {
        //given
        GeneralParkingBoy generalParkingBoy
                = new GeneralParkingBoy(Collections.singletonList(new ParkingLot(1)));
        Car car = new Car();
        generalParkingBoy.park(car);

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> generalParkingBoy.park(car));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    void should_park_to_first_parking_lot_when_parking_boy_park_car_given_parking_boy_manage_2_parking_lots() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));

        //when
        generalParkingBoy.park(new Car());

        //then
        assertEquals(1, generalParkingBoy.parkingLots.get(0).ticketCarMap.size());
    }

    @Test
    void
    should_park_to_second_parking_lot_when_parking_boy_park_car_given_full_first_parking_lot_and_second_available() {
        //given
        GeneralParkingBoy generalParkingBoy
                = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot()));
        generalParkingBoy.park(new Car());

        //when
        generalParkingBoy.park(new Car());

        //then
        assertEquals(1, generalParkingBoy.parkingLots.get(1).ticketCarMap.size());
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_car_given_2_parking_lots_and_2_parked_cars() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        Car exceptedCar1 = new Car();
        Car exceptedCar2 = new Car();
        ParkingTicket parkingTicket1 = generalParkingBoy.parkingLots.get(0).park(exceptedCar1);
        ParkingTicket parkingTicket2 = generalParkingBoy.parkingLots.get(1).park(exceptedCar2);

        //when
        Car car1 = generalParkingBoy.fetch(parkingTicket1);
        Car car2 = generalParkingBoy.fetch(parkingTicket2);

        //then
        assertEquals(exceptedCar1, car1);
        assertEquals(exceptedCar2, car2);
    }

    @Test
    void
    should_throw_unrecognized_parking_ticket_exception_when_boy_fetch_car_given_2_parking_lots_unrecognized_ticket() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> generalParkingBoy.fetch(unRecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void
    should_throw_unrecognized_parking_ticket_exception_when_boy_fetch_car_given_2_parking_lots_used_parking_ticket() {
        //given
        GeneralParkingBoy generalParkingBoy = new GeneralParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        ParkingTicket parkingTicket = generalParkingBoy.park(new Car());
        generalParkingBoy.fetch(parkingTicket);


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> generalParkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void
    should_throw_no_available_position_exception_when_parking_boy_fetch_car_given_2_parking_lots_without_any_position() {
        //given
        GeneralParkingBoy generalParkingBoy
                = new GeneralParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot(1)));
        Car car = new Car();
        generalParkingBoy.park(car);
        generalParkingBoy.park(car);

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class, () -> generalParkingBoy.park(car));
        assertEquals("No available position", exception.getMessage());
    }
}
