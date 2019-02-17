package io.github.xlair.decisiontable.parkingdiscount.rules;

import io.github.xlair.decisiontable.RuleInput;

public class MovieRuleInput implements RuleInput {

    private final boolean watchTheMovie;

    public MovieRuleInput(boolean watchTheMovie) {
        super();
        this.watchTheMovie = watchTheMovie;
    }

    public boolean isWatchTheMovie() {
        return watchTheMovie;
    }
}
