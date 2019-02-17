package io.github.xlair.decisiontable.parkingdiscount;

import io.github.xlair.decisiontable.ConditionEntry;
import io.github.xlair.decisiontable.DecisionTable;
import io.github.xlair.decisiontable.parkingdiscount.rules.PaymentPriceRule;
import io.github.xlair.decisiontable.parkingdiscount.rules.WatchTheMovieRule;

public class SimpleParkingDiscountDecisionTable extends DecisionTable<ParkingDiscountAction> {

    @Override
    protected void initialize() {
        // #1
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 0)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.THIRTY_MINUTE))
                .build());
        // #2
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 1)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.ONE_HOUR))
                .build());
        // #3
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 2)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #4
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 3)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE))
                .build());
        // #5
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 0)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #6
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 1)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #7
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 2)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #8
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(PaymentPriceRule.class, 3)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE))
                .build());
    }
}
