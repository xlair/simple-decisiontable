package io.github.xlair.decisiontable.parkingdiscount.rules;

import io.github.xlair.decisiontable.Rule;
import io.github.xlair.decisiontable.RuleInput;

public class MoreThan100dollarsAndLessThan300dollers implements Rule<PriceRuleInput> {

    @Override
    public Object evaluate(RuleInput input) {
        PriceRuleInput priceRuleInput = getInput(input);
        int paymentPrice = priceRuleInput.getPaymentPrice();
        if (paymentPrice >= 100 && paymentPrice < 300) {
            return true;
        }
        return false;
    }
}
