package io.github.xlair.decisiontable.parkingdiscount.rules;

import io.github.xlair.decisiontable.Rule;
import io.github.xlair.decisiontable.RuleInput;

public class WatchTheMovieRule implements Rule<MovieRuleInput> {

    @Override
    public Object evaluate(RuleInput input) {
        MovieRuleInput movieRuleInput = getInput(input);
        return movieRuleInput.isWatchTheMovie();
    }
}
