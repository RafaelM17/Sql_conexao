/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexao_mysql;

import conncet.ConncetFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rafael
 */
public class Conexao_mySql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConncetFactory conexaoFactory = new ConncetFactory();
            Connection conexao = conexaoFactory.getConnection();
            
            // Verifica se a conexão foi estabelecida com sucesso
            if (conexao != null) {
                System.out.println("Conectado");
                
                // Criação de uma declaração SQL
                Statement stmt = conexao.createStatement();
                
                // Execução da consulta SQL
                ResultSet resultado = stmt.executeQuery("SELECT * FROM exemplo");
                
                // Processamento dos resultados
                StringBuilder resultadoString = new StringBuilder();
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String email = resultado.getString("email");

                    // Adiciona os dados à variável resultadoString
                    resultadoString.append("ID: ").append(id).append(", Nome: ").append(nome)
                                    .append(", Idade: ").append(idade).append(", Email: ").append(email)
                                    .append("\n");
                }

                // Imprime a variável resultadoString
                System.out.println(resultadoString.toString());

                // Fechamento dos recursos
                resultado.close();
                stmt.close();
                conexao.close();
            } else {
                System.out.println("Não foi possível estabelecer a conexão");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
