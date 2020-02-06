package br.com.ifpb.ajudaijsf.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.ifpb.ajudaijsf.model.persistence.ConnectionFactory;

@ManagedBean(name = "conteudobean")
public class ConteudoBean {
	
    private int codigo;
    private String nome;
    private String local;
    private String msg;
    
    public ConteudoBean() {
		
	}
    
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<ConteudoBean> listarConteudos(){
		ConnectionFactory con = new ConnectionFactory();
		String sql = "SELECT * FROM Conteudo";
		try (Connection connection = con.getConnection();){
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			List<ConteudoBean> cb = new ArrayList<>();
			while (result.next()) {
				ConteudoBean cont = new ConteudoBean();
				cont.setCodigo(result.getInt("codigo"));
				cont.setLocal(result.getString("local"));
				cont.setNome(result.getString("nome"));
				cb.add(cont);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("erro ao se conectar no banco");
			e.printStackTrace();
		}
		return null;
		
	}
	public void excluirConteudo(int cod) {
		ConnectionFactory con = new ConnectionFactory();
		try(Connection connection = con.getConnection();) {
			String sql = "DELETE FROM conteudo WHERE codigo = ?;";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, cod);
			statement.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			this.setMsg("erro");
			e.printStackTrace();
		}
	}

}
