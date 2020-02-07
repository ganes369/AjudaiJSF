package br.com.ifpb.ajudaijsf.model.entities;

public class Conteudo {

	private int codigo;
	private String local;
	private String nome;
	
	public Conteudo() {
		
	}

	public Conteudo(int codigo, String local, String nome) {
		super();
		this.codigo = codigo;
		this.local = local;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
    
}
