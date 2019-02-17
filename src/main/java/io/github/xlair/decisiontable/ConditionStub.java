package io.github.xlair.decisiontable;

import java.util.HashMap;
import java.util.Map;

public class ConditionStub {

    private Map<Rule<? extends RuleInput>, RuleInput> rules = new HashMap<>();

    public void when(Rule<? extends RuleInput> rule, RuleInput input) {
        rules.put(rule, input);
    }

    public Map<Rule<? extends RuleInput>, RuleInput> getRules() {
        return rules;
    }
}
