package model;

import java.util.ArrayList;

public class CArmazem {
	
	private int id;
	private String nome;
	private String localizacao;
	private int capacidade;
	private ArrayList<CUser> usuarios;
	
	public CArmazem(int id, String nome, String localizacao, int capacidade, ArrayList<CUser> usuarios) {
		super();
		this.id = id;
		this.nome = nome;
		this.localizacao = localizacao;
		this.capacidade = capacidade;
		this.usuarios = usuarios;
	}
        
        public CArmazem() {
            
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
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public ArrayList<CUser> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<CUser> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
