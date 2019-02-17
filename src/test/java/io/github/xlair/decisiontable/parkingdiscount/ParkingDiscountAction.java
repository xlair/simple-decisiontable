package io.github.xlair.decisiontable.parkingdiscount;

import io.github.xlair.decisiontable.DecisionAction;

public class ParkingDiscountAction implements DecisionAction {

    private final ParkingDiscount discount;

    public ParkingDiscountAction(ParkingDiscount discount) {
        super();
        this.discount = discount;
    }

    public ParkingDiscount getDiscount() {
        return discount;
    }
}
