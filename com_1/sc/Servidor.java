package com_1.sc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        Scanner scanner = null;
        try {
            System.out.println("[SERVER] - Iniciando Servidor na porta 8000....");
            servidor = new ServerSocket(8000);
            System.out.println("[SERVER] - Servidor iniciado");

            while(true) {
                System.out.println("Server - Aguardando conexão.");
                Socket cliente = servidor.accept();
                System.out.println("[SERVER] - Conexão recebida de " + cliente.getInetAddress().getHostAddress());
                scanner = new Scanner(cliente.getInputStream());
                while (scanner.hasNextLine()) {
                    System.out.println("[PROCESSO] - Mensagem Recebida: " + scanner.nextLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
}   
