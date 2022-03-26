package co.com.sofka.task;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class postComment implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Post.to( "posts").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        .body(fillBody(faker.name().title(), faker.lordOfTheRings().character()))
                )

        );



    }

    public static postComment postComment(){
        return new postComment();
    }

    Faker faker = new Faker();


public String fillBody(String title, String letters){

        String body =

    " {\n" +
            "    \"userId\": 1,\n" +
            "    \"title\": \"" +title+"\",\n" +
            "    \"body\": \"" + letters+" \"\n" +
            "  }"
                ;

        return body;
}
}
