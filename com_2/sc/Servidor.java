package com_2.sc;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        try {
            System.out.println("[SERVER] - Iniciando Servidor na porta 8000....");
            servidor = new ServerSocket(8000);
            System.out.println("[SERVER] - Servidor iniciado");
            for(int i = 0; i < 8; i++) {
                System.out.println("Server - Aguardando conexão.");
                Socket cliente = servidor.accept();
                System.out.println("[SERVER] - Conexão recebida de " + cliente.getInetAddress().getHostAddress());
                ProcessamentoThread processThread = new ProcessamentoThread();
                processThread.setSocket(cliente);
                Thread thread = new Thread(processThread);
                thread.start();
            }
            servidor.close();
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}   
