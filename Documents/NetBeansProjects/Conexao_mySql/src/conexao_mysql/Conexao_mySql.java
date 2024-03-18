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
            
         
            if (conexao != null) {
                System.out.println("Conectado");
                
               
                Statement stmt = conexao.createStatement();
                
             
                ResultSet resultado = stmt.executeQuery("SELECT * FROM exemplo");
                
        
                StringBuilder resultadoString = new StringBuilder();
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String email = resultado.getString("email");

                  
                    resultadoString.append("ID: ").append(id).append(", Nome: ").append(nome)
                                    .append(", Idade: ").append(idade).append(", Email: ").append(email)
                                    .append("\n");
                }

           
                System.out.println(resultadoString.toString());

              
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
