package io.github.xlair.decisiontable.parkingdiscount.rules;

import io.github.xlair.decisiontable.Rule;
import io.github.xlair.decisiontable.RuleInput;

public class PaymentPriceRule implements Rule<PriceRuleInput> {

    @Override
    public Object evaluate(RuleInput input) {
        PriceRuleInput priceRuleInput = getInput(input);
        int paymentPrice = priceRuleInput.getPaymentPrice();
        if (paymentPrice >= 30 && paymentPrice < 100) {
            return 1;
        } else if (paymentPrice >= 100 && paymentPrice < 300) {
            return 2;
        } else if (paymentPrice >= 300) {
            return 3;
        } else {
            return 0;
        }
    }
}
