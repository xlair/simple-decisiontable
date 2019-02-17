package io.github.xlair.decisiontable.parkingdiscount.rules;

import io.github.xlair.decisiontable.RuleInput;

public class PriceRuleInput implements RuleInput {

    private final int paymentPrice;

    public PriceRuleInput(int paymentPrice) {
        super();
        this.paymentPrice = paymentPrice;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }
}
