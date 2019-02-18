package io.github.xlair.decisiontable;

import java.util.HashSet;
import java.util.Set;

public class ConditionEntry<A extends DecisionAction> {

    private static final String SEPARATOR = "/";

    private Set<String> resultMap;

    private A action;

    public ConditionEntry() {
        this.resultMap = new HashSet<>();
    }

    public ConditionEntry(Set<String> resultMap, A action) {
        super();
        this.resultMap = resultMap;
        this.action = action;
    }

    public int getId() {
        return resultMap.hashCode();
    }

    public A getAction() {
        return action;
    }

    public void when(@SuppressWarnings("rawtypes") Class ruleClass, Object entry) {
        resultMap.add(ruleClass.getSimpleName() + SEPARATOR + entry.toString());
    }

    public void then(A action) {
        this.action = action;
    }

    public static class Builder<A extends DecisionAction> {
        private A action;
        private Set<String> resultMap = new HashSet<>();

        public Builder<A> when(@SuppressWarnings("rawtypes") Class ruleClass, Object entry) {
            resultMap.add(ruleClass.getSimpleName() + SEPARATOR + entry.toString());
            return this;
        }

        public Builder<A> then(A action) {
            this.action = action;
            return this;
        }

        public ConditionEntry<A> build() {
            return new ConditionEntry<A>(resultMap, action);
        }
    }
}
