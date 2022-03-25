package co.com.sofka.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.rest.interactions.Put;



public class updateUser implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
            Put.to("api/users/2")
                    .with(requestSpecification -> requestSpecification.header("setContentType(\"application json;charset = UTF-8\")",
                                    "aplication/json")
                            .body("{\"name\": \"morpheus\",\"job\": \"zion resident\"}")
                    )

    );
    }

    public static updateUser updateUser(){
        return new updateUser();
    }
}
