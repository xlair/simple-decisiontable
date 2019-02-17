package io.github.xlair.decisiontable;

import java.util.HashMap;
import java.util.Map;

public abstract class DecisionTable<A extends DecisionAction> {

    private Map<Integer, ConditionEntry<A>> decisionTable = new HashMap<>();

    public DecisionTable() {
        initialize();
    }

    protected abstract void initialize();

    protected void entry(ConditionEntry<A> conditionEntry) {
        decisionTable.put(conditionEntry.getId(), conditionEntry);
    }

    public A resolve(ConditionStub conditionStub) {
        // execute rule
        ConditionEntry<A> result = new ConditionEntry<>();
        conditionStub.getRules().forEach((R, I) -> {
            result.when(R.getClass(), R.evaluate(I));
        });
        // search action
        Integer key = result.getId();
        if (decisionTable.containsKey(key)) {
            return decisionTable.get(key).getAction();
        }
        return null;
    }
}
