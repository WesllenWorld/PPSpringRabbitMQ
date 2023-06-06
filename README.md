# PPSpringRabbitMQ
Um pequeno projeto da faculdade utilizando o RabbitMQ em conjunto com o Spring Boot. É uma abstração de uma venda de ingressos

## O que é feito?
Existem dois pacotes Spring neste projeto: um producer e um consumer.

O producer deve produzir o objeto ingresso e envia-lo pela fila.

O consumer recebe, imprime uma mensagem confirmando a compra do ingresso e realiza um toString nele.

## Como é feito?

Ambos os pacotes utilizam as dependências Web, RabbitMQ for Spring e Lombok.

Utilizam uma entidade ingresso, que possui atributos.

O producer usa um método POST para enviar um ingresso pela fila, sendo testado localmente com o POSTMAN.

Ambos utilizam classes de configurações para realizar a conexão com a fila pelo CloudAMQP (para mais detalhes, verificar o arquivo application.yml)
