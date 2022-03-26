Feature: postear un comentario
  Yo como usuario
  Quiero poder realizar un posteo
  Para poder realizar un comentario en una pagina


  Scenario: Comentario publicado exitosamente
    Given me encuentro en la pagina web
    When solicito la peticion de comentar
    Then debo ver el codigo de respuesta exitoso


    Scenario: Comentario fallido
      Given estoy tratando de realizar un post
      When envio la informacion mal
      Then debo ver un error de servidor
