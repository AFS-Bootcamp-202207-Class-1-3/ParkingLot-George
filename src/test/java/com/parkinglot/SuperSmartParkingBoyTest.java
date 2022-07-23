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

//    @Test
//    void should_park_to_more_empty_parking_lot_when_smart_boy_park_car_given_full_first_parking_lot_and_second_available()
//    {
//        //given
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(5), new ParkingLot()));
//
//        //when
//        smartParkingBoy.park(new Car());
//
//        //then
//        assertEquals(1, smartParkingBoy.parkingLots.get(1).ticketCarMap.size());
//    }
//
//    @Test
//    void should_return_right_car_when_smart_parking_boy_fetch_car_given_2_parking_lots_and_2_parked_cars() {
//        //given
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
//        Car exceptedCar1 = new Car();
//        Car exceptedCar2 = new Car();
//        ParkingTicket parkingTicket1 = smartParkingBoy.parkingLots.get(0).park(exceptedCar1);
//        ParkingTicket parkingTicket2 = smartParkingBoy.parkingLots.get(1).park(exceptedCar2);
//
//        //when
//        Car car1 = smartParkingBoy.fetch(parkingTicket1);
//        Car car2 = smartParkingBoy.fetch(parkingTicket2);
//
//        //then
//        assertEquals(exceptedCar1, car1);
//        assertEquals(exceptedCar2, car2);
//    }
//
//    @Test
//    void
//    should_throw_unrecognized_parking_ticket_exception_when_smart_boy_fetch_car_given_2_parking_lots_unrecognized_ticket() {
//        //given
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
//        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();
//
//
//        //when & then
//        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
//                () -> smartParkingBoy.fetch(unRecognizedParkingTicket));
//        assertEquals("Unrecognized parking ticket", exception.getMessage());
//    }
//
//    @Test
//    void
//    should_throw_unrecognized_parking_ticket_exception_when_smart_boy_fetch_car_given_2_parking_lots_used_parking_ticket() {
//        //given
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
//        ParkingTicket parkingTicket = smartParkingBoy.park(new Car());
//        smartParkingBoy.fetch(parkingTicket);
//
//
//        //when & then
//        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
//                () -> smartParkingBoy.fetch(parkingTicket));
//        assertEquals("Unrecognized parking ticket", exception.getMessage());
//    }
//
//    @Test
//    void
//    should_throw_no_available_position_exception_when_smart_boy_fetch_car_given_2_parking_lots_without_any_position() {
//        //given
//        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot(1)));
//        Car car = new Car();
//        smartParkingBoy.park(car);
//        smartParkingBoy.park(car);
//
//        //when & then
//        Exception exception = assertThrows(NoAvailablePositionException.class,
//                () -> smartParkingBoy.park(car));
//        assertEquals("No available position", exception.getMessage());
//    }
}
