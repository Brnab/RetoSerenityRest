package co.com.sofka.task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class updateFailUser implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Put.to("api/users/2")
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .body("{\n" +
                                        "    \"name\": \"morpheus\",\n" +
                                        "    \"job\" \"zion resident\"\n" +
                                        "}")
                        )

        );
    }

    public static updateFailUser UPDATEFAILUSER(){
        return new updateFailUser();
    }
}
