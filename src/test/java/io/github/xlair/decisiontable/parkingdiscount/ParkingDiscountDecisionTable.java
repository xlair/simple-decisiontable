package io.github.xlair.decisiontable.parkingdiscount;

import io.github.xlair.decisiontable.ConditionEntry;
import io.github.xlair.decisiontable.DecisionTable;
import io.github.xlair.decisiontable.parkingdiscount.rules.MoreThan100dollarsAndLessThan300dollers;
import io.github.xlair.decisiontable.parkingdiscount.rules.MoreThan300dollars;
import io.github.xlair.decisiontable.parkingdiscount.rules.MoreThan30dollarsAndLessThan100dollars;
import io.github.xlair.decisiontable.parkingdiscount.rules.WatchTheMovieRule;

public class ParkingDiscountDecisionTable extends DecisionTable<ParkingDiscountAction> {

    @Override
    protected void initialize() {
        // #1
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, false)
                .when(MoreThan100dollarsAndLessThan300dollers.class, false)
                .when(MoreThan300dollars.class, false)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.THIRTY_MINUTE))
                .build());
        // #2
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, true)
                .when(MoreThan100dollarsAndLessThan300dollers.class, false)
                .when(MoreThan300dollars.class, false)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.ONE_HOUR))
                .build());
        // #3
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, false)
                .when(MoreThan100dollarsAndLessThan300dollers.class, true)
                .when(MoreThan300dollars.class, false)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #4
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, false)
                .when(MoreThan100dollarsAndLessThan300dollers.class, false)
                .when(MoreThan300dollars.class, true)
                .when(WatchTheMovieRule.class, false)
                .then(new ParkingDiscountAction(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE))
                .build());
        // #5
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, false)
                .when(MoreThan100dollarsAndLessThan300dollers.class, false)
                .when(MoreThan300dollars.class, false)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #6
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, true)
                .when(MoreThan100dollarsAndLessThan300dollers.class, false)
                .when(MoreThan300dollars.class, false)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #7
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, false)
                .when(MoreThan100dollarsAndLessThan300dollers.class, true)
                .when(MoreThan300dollars.class, false)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE))
                .build());
        // #8
        entry(new ConditionEntry.Builder<ParkingDiscountAction>()
                .when(MoreThan30dollarsAndLessThan100dollars.class, false)
                .when(MoreThan100dollarsAndLessThan300dollers.class, false)
                .when(MoreThan300dollars.class, true)
                .when(WatchTheMovieRule.class, true)
                .then(new ParkingDiscountAction(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE))
                .build());
    }
}
