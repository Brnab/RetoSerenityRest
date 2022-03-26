package co.com.sofka.stepDefinition;

import co.com.sofka.question.ResponseCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;

import static co.com.sofka.task.updateFailUser.UPDATEFAILUSER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class updateFailUserStepDefinition {
    private static final Logger LOGGER = Logger.getLogger(updateUsuarioStepDefinition.class);
    private static final String restApi = "https://reqres.in/";
    Actor Bernabe = Actor.named("Bernabe");


    @Given("Me encuentro en la pagina web y deseo actualizar un usuario")
    public void me_encuentro_en_la_pagina_web_y_deseo_actualizar_un_usuario() {
        Bernabe.can(CallAnApi.at(restApi));

    }



    @When("Solicito la actualizacion de la informacion de usuario pero no la envio correctamente")
    public void solicito_la_actualizacion_de_la_informacion_de_usuario_pero_no_la_envio_correctamente() {
        Bernabe.attemptsTo(
                UPDATEFAILUSER()
        );

    }


    @Then("el sistema deberia mostrarme el codigo de respuesta fallido")
    public void el_sistema_deberia_mostrarme_el_codigo_de_respuesta_fallido() {
        Bernabe.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(HttpStatus.SC_BAD_REQUEST))
        );

    }

}
