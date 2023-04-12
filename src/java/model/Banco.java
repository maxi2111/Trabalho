/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.*;

/**
 *
 * @author prampero
 */
public class Banco {
    //conexão com o banco
    public static Connection conexao;  //static para não repetir conexao
    public PreparedStatement comando; //  envia sql para o banco
    public ResultSet tabela; // armazena os dados que vem do banco
    
    public Banco() throws Exception{
        
        try{
            //regitra o driver, informa que vai utilizá-lo
            Class.forName("org.postgresql.Driver"); // para Postgres
         
            // teste se a conexão não foi instanciada (sempre em primeiro)
            if ((conexao == null) || (conexao.isClosed())) {
                conexao = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/LPB","postgres", "ifsp");
              
            }
        }
        catch(Exception ex){
            throw new Exception("Erro na conexão com o banco: "+ex.getMessage());
        }
    }
    
    
    
}
