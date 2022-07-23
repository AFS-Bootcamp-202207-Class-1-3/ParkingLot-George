package com.parkinglot;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {

    private static final List<ParkingLot> DEFAULT_EMPTY_PARKING_LOTS
            = Arrays.asList(new ParkingLot(),
            new ParkingLot());
    @Test
    void should_return_parking_ticket_when_parking_boy_park_given_parking_lot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));
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
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));
        Car exceptedCar = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(exceptedCar);

        //when
        Car car = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(exceptedCar, car);
    }

    @Test
    void should_return_right_car_when_parking_boy_fetch_car_given_parked_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));
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
    void should_throw_unrecognized_parking_ticket_exception_when_parking_boy_fetch_car_given_unrecognized_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));
        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingBoy.fetch(unRecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_unrecognized_parking_ticket_exception_when_parking_boy_fetch_car_given_used_parking_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));
        ParkingTicket parkingTicket = parkingBoy.park(new Car());
        parkingBoy.fetch(parkingTicket);


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void should_throw_no_available_position_exception_when_parking_boy_fetch_car_given_without_any_position() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Collections.singletonList(parkingLot));
        Car car = new Car();
        parkingBoy.park(car);

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> parkingBoy.park(car));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    void should_park_to_first_parking_lot_when_parking_boy_park_car_given_parking_boy_manage_2_parking_lots() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(DEFAULT_EMPTY_PARKING_LOTS);

        //when
        parkingBoy.park(new Car());

        //then
        assertEquals(1, parkingBoy.parkingLots.get(0).ticketCarMap.size());
    }

    @Test
    void should_park_to_second_parking_lot_when_parking_boy_park_car_given_full_first_parking_lot_and_second_available()
    {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot()));
        parkingBoy.park(new Car());

        //when
        parkingBoy.park(new Car());

        //then
        assertEquals(1, parkingBoy.parkingLots.get(1).ticketCarMap.size());
    }
}
