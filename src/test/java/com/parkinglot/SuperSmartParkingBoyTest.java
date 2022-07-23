package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_super_smart_boy_park_car_given_parking_boy_manage_2_parking_lots() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy
                = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));

        //when
        superSmartParkingBoy.park(new Car());

        //then
        assertEquals(1, superSmartParkingBoy.parkingLots.get(0).ticketCarMap.size());
    }

    @Test
    void
    should_park_to_larger_rate_parking_lot_when_super_smart_boy_park_car_given_2_parking_lot_and_second_one_is_larger_rate()
    {
        //given
        SuperSmartParkingBoy superSmartParkingBoy
                = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(3), new ParkingLot(2)));
        superSmartParkingBoy.park(new Car());

        //when
        superSmartParkingBoy.park(new Car());

        //then
        assertEquals(1, superSmartParkingBoy.parkingLots.get(1).ticketCarMap.size());
    }

    @Test
    void should_return_right_car_when_super_smart_parking_boy_fetch_car_given_2_parking_lots_and_2_parked_cars() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        Car exceptedCar1 = new Car();
        Car exceptedCar2 = new Car();
        ParkingTicket parkingTicket1 = superSmartParkingBoy.parkingLots.get(0).park(exceptedCar1);
        ParkingTicket parkingTicket2 = superSmartParkingBoy.parkingLots.get(1).park(exceptedCar2);

        //when
        Car car1 = superSmartParkingBoy.fetch(parkingTicket1);
        Car car2 = superSmartParkingBoy.fetch(parkingTicket2);

        //then
        assertEquals(exceptedCar1, car1);
        assertEquals(exceptedCar2, car2);
    }

    @Test
    void
    should_throw_unrecognized_parking_ticket_exception_when_super_smart_boy_fetch_car_given_2_parking_lots_unrecognized_ticket() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();


        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> superSmartParkingBoy.fetch(unRecognizedParkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void
    should_throw_unrecognized_parking_ticket_exception_when_super_smart_boy_fetch_car_given_2_parking_lots_used_parking_ticket() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
        ParkingTicket parkingTicket = superSmartParkingBoy.park(new Car());
        superSmartParkingBoy.fetch(parkingTicket);

        //when & then
        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
                () -> superSmartParkingBoy.fetch(parkingTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void
    should_throw_no_available_position_exception_when_smart_boy_fetch_car_given_2_parking_lots_without_any_position() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot(1)));
        Car car = new Car();
        superSmartParkingBoy.park(car);
        superSmartParkingBoy.park(car);

        //when & then
        Exception exception = assertThrows(NoAvailablePositionException.class,
                () -> superSmartParkingBoy.park(car));
        assertEquals("No available position", exception.getMessage());
    }
}
