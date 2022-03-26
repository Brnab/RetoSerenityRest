package co.com.sofka.stepDefinition;

import co.com.sofka.question.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static co.com.sofka.task.postComment.postComment;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class postStepDefinition {

    private static final Logger LOGGER = Logger.getLogger(postStepDefinition.class);
    private static final String restApi = "https://jsonplaceholder.typicode.com/";
    Actor Bernabe = Actor.named("Bernabe");
    private String Body;

    @Given("me encuentro en la pagina web")
    public void me_encuentro_en_la_pagina_web() {
        Bernabe.can(CallAnApi.at(restApi));
        LOGGER.info(Body);




    }



    @When("solicito la peticion de comentar")
    public void solicito_la_peticion_de_comentar() {

        Bernabe.attemptsTo(

                postComment()
        );

    }



    @Then("debo ver el codigo de respuesta exitoso")
    public void debo_ver_el_codigo_de_respuesta_exitoso() {
        Bernabe.should(
                seeThat("El codigo de respuesta es ", new ResponseCode(), equalTo(HttpStatus.SC_CREATED))

        );
        LastResponse.received().answeredBy(Bernabe).prettyPrint();

    }

}
