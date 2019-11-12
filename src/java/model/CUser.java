package model;

import java.util.ArrayList;

public class CUser {
	private String myLogin;
	private String myPassword;
	private int id;
	private String nome;
	private String cpf;
	private ArrayList<CArmazem> meusArmazens;
	
	public CUser ( String newLogin, String newPassword )
	{
		this.myLogin 	= new String ( newLogin );
		this.myPassword = new String ( newPassword );
	}
	public CUser ( )
	{
		this.myLogin 	= null;
		this.myPassword = null;
	}
	
	public CUser(String myLogin, String myPassword, int id, String nome, String cpf, ArrayList<CArmazem> meusArmazens) {
		super();
		this.myLogin = myLogin;
		this.myPassword = myPassword;
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.meusArmazens = meusArmazens;
	}
	public String getMyLogin() {
		return myLogin;
	}
	public void setMyLogin(String myLogin) {
		this.myLogin = myLogin;
	}
	public String getMyPassword() {
		return myPassword;
	}
	public void setMyPassword(String myPassword) {
		this.myPassword = myPassword;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ArrayList<CArmazem> getMeusArmazens() {
		return meusArmazens;
	}
	public void setMeusArmazens(ArrayList<CArmazem> meusArmazens) {
		this.meusArmazens = meusArmazens;
	}
	public void setLogin (String newLogin)
	{
		if (null == myLogin)
			this.myLogin 	= new String ( newLogin );
		else
			this.myLogin 	= newLogin;
	}
	public void setPassword (String newPassword)
	{
		this.myPassword = newPassword;
	}
	public String getLogin ()
	{
		return this.myLogin;
	}
	public String getPassword ()
	{
		return this.myPassword;
	}
}
