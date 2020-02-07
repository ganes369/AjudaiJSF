package br.com.ifpb.ajudaijsf.bean;

import javax.faces.bean.ManagedBean;

import br.com.ifpb.ajudaijsf.model.entities.Conteudo;

@ManagedBean(name = "conteudobean")
public class ConteudoBean {
	
	private Conteudo conteudo;

	public ConteudoBean() {
		
	}
	
	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

}
