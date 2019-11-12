package model;

public class CItem {
	
    private int id;
    private String nome;
    private String descricao;
    private String medidas;
    private String forma_armazenamento;
    private int id_categoria;
	
    public CItem(int id, String nome, String descricao, String medidas, String forma_armazenamento) {
	super();
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
	this.medidas = medidas;
	this.forma_armazenamento = forma_armazenamento;
    }
    
    public CItem() {
        
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
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
    public String getMedidas() {
	return medidas;
    }
    public void setMedidas(String medidas) {
	this.medidas = medidas;
    }
    public String getForma_armazenamento() {
	return forma_armazenamento;
    }
    public void setForma_armazenamento(String forma_armazenamento) {
	this.forma_armazenamento = forma_armazenamento;
    }	
	
}
