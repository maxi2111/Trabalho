/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Timestamp;

/**
 *
 * @author aluno
 */
public class Venda {
    private int codigo;
    private double total;
    private Timestamp datav;
    private int codcli;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setCodigo(String codigo) {
        this.setCodigo(Integer.parseInt(codigo));
    }

    
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setTotal(String total) {
        this.setTotal(Double.parseDouble(total));
    }

    
    public Timestamp getDatav() {
        return datav;
    }
    public void setDatav(Timestamp datav) {
        this.datav = datav;
    }
    public void setDatav(String datav) {
        this.setDatav(Timestamp.valueOf(datav));
    }
    public int getCodcli() {
        return codcli;
    }
    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }
    public void setCodcli(String codcli) {
        this.setCodcli(Integer.parseInt(codcli));
    }
    
    
    
    
}
