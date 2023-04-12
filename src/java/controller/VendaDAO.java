/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Statement;
import model.Banco;
import model.Venda;

/**
 *
 * @author aluno
 */
public class VendaDAO {
    //grava e armazena o código gerado pelo banco no obj
    public int gravar(Venda obj) throws Exception{
        Banco bb;
        int codigo=-1;
        
        try{
            bb = new Banco();
            bb.comando = Banco.conexao.prepareStatement("Insert into venda(total, codcli) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            bb.comando.setDouble(1, obj.getTotal());
            bb.comando.setInt(2, obj.getCodcli());
            bb.comando.execute();
            bb.tabela =bb.comando.getGeneratedKeys();
            bb.tabela.next();
            codigo =(int)bb.tabela.getInt(1);
            Banco.conexao.close();
        }
        catch (Exception e){
            throw new Exception("Erro ao gravar venda");
        }
        return 0;
    }
}
