package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_to_first_parking_lot_when_smart_boy_park_car_given_parking_boy_manage_2_parking_lots() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));

        //when
        smartParkingBoy.park(new Car());

        //then
        assertEquals(1, smartParkingBoy.parkingLots.get(0).ticketCarMap.size());
    }

//    @Test
//    void should_park_to_second_parking_lot_when_parking_boy_park_car_given_full_first_parking_lot_and_second_available()
//    {
//        //given
//        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot()));
//        parkingBoy.park(new Car());
//
//        //when
//        parkingBoy.park(new Car());
//
//        //then
//        assertEquals(1, parkingBoy.parkingLots.get(1).ticketCarMap.size());
//    }
//
//    @Test
//    void should_return_right_car_when_parking_boy_fetch_car_given_2_parking_lots_and_2_parked_cars() {
//        //given
//        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
//        Car exceptedCar1 = new Car();
//        Car exceptedCar2 = new Car();
//        ParkingTicket parkingTicket1 = parkingBoy.parkingLots.get(0).park(exceptedCar1);
//        ParkingTicket parkingTicket2 = parkingBoy.parkingLots.get(1).park(exceptedCar2);
//
//        //when
//        Car car1 = parkingBoy.fetch(parkingTicket1);
//        Car car2 = parkingBoy.fetch(parkingTicket2);
//
//        //then
//        assertEquals(exceptedCar1, car1);
//        assertEquals(exceptedCar2, car2);
//    }
//
//    @Test
//    void
//    should_throw_unrecognized_parking_ticket_exception_when_boy_fetch_car_given_2_parking_lots_unrecognized_ticket() {
//        //given
//        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
//        ParkingTicket unRecognizedParkingTicket = new ParkingTicket();
//
//
//        //when & then
//        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
//                () -> parkingBoy.fetch(unRecognizedParkingTicket));
//        assertEquals("Unrecognized parking ticket", exception.getMessage());
//    }
//
//    @Test
//    void
//    should_throw_unrecognized_parking_ticket_exception_when_boy_fetch_car_given_2_parking_lots_used_parking_ticket() {
//        //given
//        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(), new ParkingLot()));
//        ParkingTicket parkingTicket = parkingBoy.park(new Car());
//        parkingBoy.fetch(parkingTicket);
//
//
//        //when & then
//        Exception exception = assertThrows(UnrecognizedParkingTicketException.class,
//                () -> parkingBoy.fetch(parkingTicket));
//        assertEquals("Unrecognized parking ticket", exception.getMessage());
//    }
//
//    @Test
//    void
//    should_throw_no_available_position_exception_when_parking_boy_fetch_car_given_2_parking_lots_without_any_position() {
//        //given
//        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(1), new ParkingLot(1)));
//        Car car = new Car();
//        parkingBoy.park(car);
//        parkingBoy.park(car);
//
//        //when & then
//        Exception exception = assertThrows(NoAvailablePositionException.class,
//                () -> parkingBoy.park(car));
//        assertEquals("No available position", exception.getMessage());
//    }
}
