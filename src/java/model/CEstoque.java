/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author gui_v
 */
public class CEstoque {
    int id;
    int id_item;
    String operacao;
    float qtd;
    String motivo;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public float getQtd() {
        return qtd;
    }

    public void setQtd(float qtd) {
        this.qtd = qtd;
    }
    
}
