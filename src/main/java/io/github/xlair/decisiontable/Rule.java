package io.github.xlair.decisiontable;

public interface Rule<I extends RuleInput> {

    Object evaluate(RuleInput input);

    @SuppressWarnings("unchecked")
    default I getInput(RuleInput input) {
        return (I) input;
    }
}
