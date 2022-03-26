package co.com.sofka.stepDefinition;

import co.com.sofka.question.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hamcrest.Matchers;

import static co.com.sofka.task.updateFailUser.UPDATEFAILUSER;
;
import static co.com.sofka.task.updateUser.updateUser;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;


public class updateUsuarioStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(updateUsuarioStepDefinition.class);
    private static final String restApi = "https://reqres.in/";
    Actor Bernabe = Actor.named("Bernabe");




    @Given("Me encuentro encuentro en la pagina web y deseo actualizar la informacion")
    public void me_encuentro_encuentro_en_la_pagina_web_y_deseo_actualizar_la_informacion() {
        PropertyConfigurator.configure(USER_DIR.getValue() + LOG4J_PROPERTIES_FILE_PATH.getValue());
        Bernabe.whoCan(CallAnApi.at(restApi));



    }
    @When("solicito la actualizacion de dicha informacion")
    public void solicito_la_actualizacion_de_dicha_informacion() {

        Bernabe.attemptsTo(
                updateUser()
        );

    }
    @Then("el sistema deberia mostrarme el codigo de actualizacion exitosa")
    public void el_sistema_deberia_mostrarme_el_codigo_de_actualizacion_exitosa() {

        Bernabe.should(
                seeThatResponse(response -> response.statusCode(HttpStatus.SC_OK)
                        .body("updatedAt", Matchers.not(isEmptyString())))
        );

    }

}
