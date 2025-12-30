package com.api.httpserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Implementar um servidor HTTP
 * 
 * Um servidor HTTP é um programa que:
 * Abre uma porta (TCP)
 * Aceita conexões de rede
 * Lê bytes
 * Interpreta esses bytes conforme as regras do HTTP
 * Gera uma resposta HTTP válida
 * Envia essa resposta como bytes
 */

public class HttpServer {

    public static void main(String[] args) throws Exception {

        // ServerSocket abre um porta TCP
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Servidor rodando na porta 8080");

        // aguarda conexao
        while (true) {
            // socket.accept() aceita um cliente (browser, curl, Postman)
            Socket socket = serverSocket.accept();
            // O navegador cria uma conexão TCP com a porta 8080

            // BufferedReader - leitor de texto em cima de um fluxo de bytes
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())); // getInputStream - o que o cliente envia

            String line;

            // reader.readLine() lê a mensagem HTTP crua (request line + headers)
            while (((line = reader.readLine()) != null && !line.isEmpty())) {
                System.out.println(line);
                /**
                 * interpretando manualmente o protocolo HTTP, porque:
                 * HTTP define que headers vêm linha por linha
                 * Uma linha vazia indica fim da requisição
                 */
            }

            // escreve resposta http - OutputStream é o canal por onde o servidor envia a
            // resposta HTTP.
            OutputStream out = socket.getOutputStream();// getOutputStream - o que o servidor responde

            // escreve manual e literalmente a resposta HTTP
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Content-Type: text/plain\r\n" +
                    "Content-Length: 11\r\n" +
                    "\r\n" +
                    "Tudo certo";

            // envio resposta - HTTP válido
            out.write(response.getBytes());
            out.flush();

            socket.close();

        }
    }
}
