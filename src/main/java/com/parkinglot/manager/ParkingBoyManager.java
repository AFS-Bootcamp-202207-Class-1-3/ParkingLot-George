package com.parkinglot.manager;

import com.parkinglot.ParkingLot;
import com.parkinglot.parkingboy.GeneralParkingBoy;
import com.parkinglot.parkingboy.ParkingBoy;
import com.parkinglot.parkingboy.SmartParkingBoy;
import com.parkinglot.parkingboy.SuperSmartParkingBoy;
import com.parkinglot.enums.ParkingBoyTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingBoyManager {
    private final Map<ParkingBoyTypes, ParkingBoy> PARKING_BOYS;

    public ParkingBoyManager(List<ParkingLot> parkingLots) {
        PARKING_BOYS = new HashMap<>();
        PARKING_BOYS.put(ParkingBoyTypes.GENERAL_PARKING_BOY, new GeneralParkingBoy(parkingLots));
        PARKING_BOYS.put(ParkingBoyTypes.SMART_PARKING_BOY, new SmartParkingBoy(parkingLots));
        PARKING_BOYS.put(ParkingBoyTypes.SUPER_SMART_PARKING_BOY, new SuperSmartParkingBoy(parkingLots));
    }

    public ParkingBoy distributeParkingBoyByType(ParkingBoyTypes type) {
        return PARKING_BOYS.get(type);
    }

}
