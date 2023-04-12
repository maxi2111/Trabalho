/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author prampero
 */
public class Produto {

    private int codigo;
    private String descricao;
    private double preco;
    private int qtde;
    private String imagem;
    private int coddep;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigo(String codigo) {
        this.setCodigo(Integer.parseInt(codigo));
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPreco(String preco) {
        this.setPreco(Double.parseDouble(preco));
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public void setQtde(String qtde) {
        this.setQtde(Integer.parseInt(qtde));
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getCoddep() {
        return coddep;
    }

    public void setCoddep(int coddep) {
        this.coddep = coddep;
    }

    public void setCoddep(String coddep) {
        this.setCoddep(Integer.parseInt(coddep));
    }
}
