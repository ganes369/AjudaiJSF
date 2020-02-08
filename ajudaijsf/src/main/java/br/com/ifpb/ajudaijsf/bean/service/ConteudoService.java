package br.com.ifpb.ajudaijsf.bean.service;

import java.util.List;

import br.com.ifpb.ajudaijsf.model.entities.Conteudo;
import br.com.ifpb.ajudaijsf.model.persistence.dao.CrudConteudo;

public class ConteudoService {

	public void excluirConteudo(int codigo) {
		CrudConteudo dao = new CrudConteudo();
		boolean resultado = dao.excluir(codigo);
		if(resultado == true) {
			System.out.println("conteudo excluido");
		}else {
			System.out.println("falha ao excluiro conteudo");
		}
	}
	public Conteudo buscarEspecifico(int codigo) {
		CrudConteudo dao = new CrudConteudo();
		Conteudo conteudo = dao.pesquisar(codigo);
		if(conteudo != null) {
			return conteudo;
		}
		return null;
	}
	public List<Conteudo> listarTodos(){
		CrudConteudo dao = new CrudConteudo();
		List<Conteudo> cb = dao.listarConteudos();
		if(cb!=null) {
			return cb;
		}
		return null;
	}
	
}
