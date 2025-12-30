package com.api.httpserver;

import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Java já vem com um servidor HTTP pronto com esse import :
 * import com.sun.net.httpserver.HttpServer
 * Já tras implementado:
 * TCP
 * Socket
 * Aceitar conexão
 * Ler bytes Interpretar HTTP
 * Montar request/response
 * 
 * Biblioteca nativa do java, manualmente só define o que fazer quando a
 * requisição chega
 */

public class HttpServerNativo {
    public static void main(String[] args) throws Exception {

        // cria servidor http e abre porta
        // InetSocketAddress Representa endereço + porta onde o servidor irá escutar
        // conexões TCP.
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // cria um endpoint - rota
        // Registra um contexto HTTP para o caminho /
        server.createContext("/", new MeuHandler());

        // inicializacao do servidor
        server.start();
        System.out.println("Servidor http nativo rodando porta 8080");
    }

    // HttpHandler -Interface que define o contrato: decide o que fazer quando uma
    // requisição HTTP chegar
    static class MeuHandler implements HttpHandler {

        @Override
        /**
         * HttpExchange - Objeto que representa uma transação HTTP única:request e
         * response
         * Método é chamado automaticamente pelo servidor a cada requisição HTTP
         * recebida.
         * 
         * Paramentro exchange contem:
         * método HTTP (GET, POST, etc.)
         * headers da requisição
         * body da requisição
         * objeto de resposta
         * 
         */
        public void handle(HttpExchange exchange) {
            try {
                // envio de msg ao cliente
                String resposta = "Tudo certo!";
                // eviio de status e quando o body termina
                exchange.sendResponseHeaders(200, 0);

                // corpo da resposta
                OutputStream os = exchange.getResponseBody();
                os.write(resposta.getBytes()); // converte string em bytes e escreve-os o sockt
                os.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}