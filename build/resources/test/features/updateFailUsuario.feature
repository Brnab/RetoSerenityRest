Feature: Actualizacion de usuario
  Yo como consumidor de una pagina
  Quiero poder actualizar la informacion de un usuario
  Para poder tener al dia su informacion

  Scenario: actualizacion fallida
    Given Me encuentro en la pagina web y deseo actualizar un usuario
    When Solicito la actualizacion de la informacion de usuario pero no la envio correctamente
    Then el sistema deberia mostrarme el codigo de respuesta fallido