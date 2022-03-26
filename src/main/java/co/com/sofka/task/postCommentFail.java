package co.com.sofka.task;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class postCommentFail implements Task {

Faker faker = new Faker();
    public static postCommentFail postCommentFail(){
        return new postCommentFail();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to( "posts").with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                        .body(fillBodyIncorrectly(faker.name().title(), faker.lordOfTheRings().character()))
                )

        );


    }

    public String fillBodyIncorrectly(String title, String letters){

        String body =

                " {\n" +
                        "    \"userId\": 1,\n" +
                        "    \"title\": \"" +title+"\"\n" +
                        "    \"body\": \"" + letters+" \"\n" +
                        "  }"
                ;

        return body;
    }
}
