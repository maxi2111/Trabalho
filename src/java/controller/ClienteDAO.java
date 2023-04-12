/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.ResultSet;
import model.Banco;
import model.Cliente;

/**
 *
 * @author aluno
 */
public class ClienteDAO {
    public int gravar(Cliente obj) throws Exception{
        Banco bb;
        int qtde=0;
        try{
            bb= new Banco();
            bb.comando = Banco.conexao.prepareStatement(
                    "Insert into cliente(nome,login, senha) values (?,?,?)");
            bb.comando.setString(1, obj.getNome());
            bb.comando.setString(2, obj.getLogin());
            bb.comando.setString(3, obj.getSenha());
            qtde = bb.comando.executeUpdate();
            Banco.conexao.close();
            return(qtde);
        }
        catch(Exception ex){
            throw new Exception("Erro ao gravar cliente :" + ex.getMessage());
        }
    }
    public void consulta(Cliente obj) throws Exception{
        Banco bb;
        try{
            bb = new Banco();
            bb.comando=Banco.conexao.prepareStatement(
            "Select login, senha from cliente where login='?' and senha='?';");
            bb.comando.setString(1, obj.getLogin());
            bb.comando.setString(2, obj.getSenha());
            bb.tabela= bb.comando.executeQuery();
            if(bb.tabela.next()){
                obj = new Cliente();
                obj.setLogin(bb.tabela.getString(1));
                obj.setSenha(bb.tabela.getString(2));
            }
            Banco.conexao.close();
        }
        catch(Exception ex){
            throw new Exception("Login não encontrado! Erro: " + ex.getMessage());
        }
    }
}
