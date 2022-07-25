package com.parkinglot.manager;

import com.parkinglot.ParkingLot;
import com.parkinglot.entity.Car;
import com.parkinglot.entity.ParkingTicket;
import com.parkinglot.enums.ParkingBoyTypes;
import com.parkinglot.parkingStrategy.ParkingBoy;
import com.parkinglot.parkingStrategy.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotManagerTest {
    @Test
    void should_return_parking_ticket_when_manager_distribute_general_parking_boy_given_parking_lot() {
        //given
        ParkingBoyManager parkingBoyManager = new ParkingBoyManager(Arrays.asList(new ParkingLot(), new ParkingLot()));

        //when
        ParkingTicket parkingTicket
                = parkingBoyManager.distributeParkingBoyByType(ParkingBoyTypes.GENERAL_PARKING_BOY).park(new Car());

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parking_ticket_when_manager_distribute_smart_parking_boy_given_parking_lot() {
        //given
        ParkingBoyManager parkingBoyManager = new ParkingBoyManager(Arrays.asList(new ParkingLot(), new ParkingLot()));

        //when
        ParkingTicket parkingTicket
                = parkingBoyManager.distributeParkingBoyByType(ParkingBoyTypes.SMART_PARKING_BOY).park(new Car());

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parking_ticket_when_manager_distribute_super_smart_parking_boy_given_parking_lot() {
        //given
        ParkingBoyManager parkingBoyManager = new ParkingBoyManager(Arrays.asList(new ParkingLot(), new ParkingLot()));

        //when
        ParkingTicket parkingTicket
                = parkingBoyManager.distributeParkingBoyByType(ParkingBoyTypes.SUPER_SMART_PARKING_BOY).park(new Car());

        //then
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_parked_car_when_manager_distribute_super_smart_parking_boy_to_fetch_given_parking_ticket() {
        //given
        ParkingBoyManager parkingBoyManager = new ParkingBoyManager(Arrays.asList(new ParkingLot(), new ParkingLot()));
        SuperSmartParkingBoy parkingBoy = (SuperSmartParkingBoy) parkingBoyManager
                .distributeParkingBoyByType(ParkingBoyTypes.SUPER_SMART_PARKING_BOY);
        Car car = new Car();
        ParkingTicket parkingTicket = parkingBoy.park(car);
        //when
        Car fetchCar = parkingBoy.fetch(parkingTicket);

        //then
        assertEquals(car, fetchCar);
    }
}