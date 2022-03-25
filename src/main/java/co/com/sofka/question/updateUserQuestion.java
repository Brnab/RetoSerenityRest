package co.com.sofka.question;

import co.com.sofka.model.User;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class updateUserQuestion implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return SerenityRest.lastResponse().as (User.class);
    }
}
