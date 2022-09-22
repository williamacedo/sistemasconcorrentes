package com.sc;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        Socket servidor = null;
        try {
            String mensagem = (String) JOptionPane.showInputDialog(null, "Escreva uma mensagem:");
            servidor = new Socket("localhost", 8000);
            System.out.println("[CLIENT] - Conexão com sucesso !!!");
    
            PrintStream printStream = new PrintStream(servidor.getOutputStream());
            StringBuilder msgRerverse = new StringBuilder(mensagem);  
            msgRerverse.reverse();
            printStream.println(msgRerverse);
    
            System.out.println("[CLIENT] - Mensagem enviada: " + mensagem);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                servidor.close();
            } catch (IOException e) {}
        }       
    }
}
