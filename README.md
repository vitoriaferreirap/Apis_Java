# Apis_Java

Este projeto tem como objetivo estudar o funcionamento do protocolo HTTP
e a criação de uma API sem frameworks, comparando duas abordagens:

1. Implementação manual do servidor HTTP
2. Uso da implementação HTTP nativa da JDK

## HttpServer.java

### Objetivo

Demonstrar, de forma explícita, como um servidor HTTP funciona internamente.

### O que este código faz

- Cria um servidor TCP manualmente
- Abre uma porta de rede
- Aceita conexões de clientes
- Lê bytes da requisição HTTP
- Interpreta o texto do protocolo HTTP
- Monta manualmente a resposta HTTP
- Envia bytes de resposta ao cliente
- Encerra a conexão

### Foco

Entender **como o protocolo HTTP funciona na prática**, sem abstrações.


## HttpServerNativo.java

### Objetivo

Demonstrar a criação de uma API HTTP utilizando a implementação nativa do Java,
sem frameworks externos.

### O que este código faz

- Utiliza o servidor HTTP fornecido pela JDK
- Abre e gerencia a porta TCP automaticamente
- Realiza o parsing da requisição HTTP
- Expõe a requisição via `HttpExchange`
- Permite definir status, headers e corpo da resposta
- Envia a resposta ao cliente

### Foco

Entender **como trabalhar com HTTP em nível de aplicação**, sem lidar
diretamente com sockets e parsing manual.


## Observação

Frameworks como Spring Boot abstraem ainda mais essas etapas,
mas ambos os exemplos representam APIs HTTP reais.
