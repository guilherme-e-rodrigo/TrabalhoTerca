package model;

import java.util.ArrayList;

public class CCategoria {
	
	private int id;
	private String nome;
	private String descricao;
	private ArrayList<CItem> itens;
	
	public CCategoria(int id, String nome, String descricao, ArrayList<CItem> itens) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.itens = itens;
	}
        
        public CCategoria() {
            
        }
        
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ArrayList<CItem> getItens() {
		return itens;
	}
	public void setItens(ArrayList<CItem> itens) {
		this.itens = itens;
	}
	
	
	
	
}
