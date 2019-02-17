package io.github.xlair.decisiontable;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.xlair.decisiontable.parkingdiscount.ParkingDiscount;
import io.github.xlair.decisiontable.parkingdiscount.ParkingDiscountAction;
import io.github.xlair.decisiontable.parkingdiscount.ParkingDiscountDecisionTable;
import io.github.xlair.decisiontable.parkingdiscount.SimpleParkingDiscountDecisionTable;
import io.github.xlair.decisiontable.parkingdiscount.rules.MoreThan100dollarsAndLessThan300dollers;
import io.github.xlair.decisiontable.parkingdiscount.rules.MoreThan300dollars;
import io.github.xlair.decisiontable.parkingdiscount.rules.MoreThan30dollarsAndLessThan100dollars;
import io.github.xlair.decisiontable.parkingdiscount.rules.MovieRuleInput;
import io.github.xlair.decisiontable.parkingdiscount.rules.PaymentPriceRule;
import io.github.xlair.decisiontable.parkingdiscount.rules.PriceRuleInput;
import io.github.xlair.decisiontable.parkingdiscount.rules.WatchTheMovieRule;

public class DecisionTableTest {

    ParkingDiscountDecisionTable decisionTable = new ParkingDiscountDecisionTable();
    SimpleParkingDiscountDecisionTable simpleDecisionTable = new SimpleParkingDiscountDecisionTable();

    MoreThan30dollarsAndLessThan100dollars moreThan30dollarsAndLessThan100dollars = new MoreThan30dollarsAndLessThan100dollars();
    MoreThan100dollarsAndLessThan300dollers moreThan100dollarsAndLessThan300dollers = new MoreThan100dollarsAndLessThan300dollers();
    MoreThan300dollars moreThan300dollars = new MoreThan300dollars();
    PaymentPriceRule paymentPriceRule = new PaymentPriceRule();
    WatchTheMovieRule watchTheMovieRule = new WatchTheMovieRule();

    @Test
    public void test01() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(20);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test02() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(50);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.ONE_HOUR, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test03() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(170);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test04() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(450);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test05() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(1);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test06() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(70);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test07() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(200);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test08() {
        // input
        PriceRuleInput priceRuleInput = new PriceRuleInput(1000);
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(moreThan30dollarsAndLessThan100dollars, priceRuleInput);
        conditionStub.when(moreThan100dollarsAndLessThan300dollers, priceRuleInput);
        conditionStub.when(moreThan300dollars, priceRuleInput);
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = decisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test09() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(20));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test10() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(50));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.ONE_HOUR, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test11() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(170));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test12() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(450));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(false));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test13() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(1));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test14() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(70));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test15() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(200));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.TWO_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }

    @Test
    public void test16() {
        // input
        ConditionStub conditionStub = new ConditionStub();
        conditionStub.when(paymentPriceRule, new PriceRuleInput(1000));
        conditionStub.when(watchTheMovieRule, new MovieRuleInput(true));

        // execute
        ParkingDiscountAction parkingDiscountAction = simpleDecisionTable.resolve(conditionStub);

        // verify
        assertEquals(ParkingDiscount.THREE_HOUR_THIRTY_MINUTE, parkingDiscountAction.getDiscount());
    }
}
