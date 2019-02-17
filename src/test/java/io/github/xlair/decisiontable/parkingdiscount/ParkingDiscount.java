package io.github.xlair.decisiontable.parkingdiscount;

public enum ParkingDiscount {

    THIRTY_MINUTE(1), ONE_HOUR(2), TWO_HOUR_THIRTY_MINUTE(3), THREE_HOUR_THIRTY_MINUTE(4);

    private int code;

    private ParkingDiscount(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
