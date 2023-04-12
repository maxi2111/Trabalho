/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Banco;
import model.Item;

/**
 *
 * @author aluno
 */
public class ItemDAO {
    public int gravar(Item obj)throws Exception{
        Banco bb;
        int qtde=0;
        
        try{
            bb = new Banco();
            bb.comando=Banco.conexao.prepareStatement(
            "Insert into item(qtde, precounit, codproduto, codvenda) values(?,?,?,?);");
            bb.comando.setInt(1, obj.getQtde());
            bb.comando.setDouble(2, obj.getPrecounit());
            bb.comando.setInt(3, obj.getCodproduto());
            bb.comando.setInt(4, obj.getCodvenda());
            qtde = bb.comando.executeUpdate();
            Banco.conexao.close();
            return(qtde);
        }
        catch(Exception ex){
            throw new Exception("Erro ao gravar item : "+ ex.getMessage());
        }
        
    }
}
