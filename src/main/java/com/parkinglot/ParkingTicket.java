package com.parkinglot;

public class ParkingTicket {

    private boolean isUsed;

    public ParkingTicket( boolean isUsed) {
        this.isUsed = isUsed;
    }


    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }
}
