package br.com.ifpb.ajudaijsf.model.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ifpb.ajudaijsf.model.entities.Conteudo;
import br.com.ifpb.ajudaijsf.model.persistence.ConnectionFactory;

public class CrudConteudo {

	 private ConnectionFactory con;
	 
	 public CrudConteudo() {
		 this.con = new ConnectionFactory();
	}
	 
	public boolean excluir(int codigo) {
		try (Connection connection = con.getConnection();){
			String sql = "DELETE FROM conteudo WHERE codigo = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, codigo);
			statement.executeQuery();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Conteudo> listarConteudos(){
		ConnectionFactory con = new ConnectionFactory();
		String sql = "SELECT * FROM Conteudo";
		List<Conteudo> cb =  new ArrayList<>();
		try (Connection connection = con.getConnection();){
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Conteudo cont = new Conteudo();
				cont.setCodigo(result.getInt("codigo"));
				cont.setLocal(result.getString("local"));
				cont.setNome(result.getString("nome"));
				cb.add(cont);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println("erro ao se conectar no banco");
			e.printStackTrace();
		}
		return cb;
	}
	public Conteudo pesquisar(int codigo) {
		ConnectionFactory con = new ConnectionFactory();
		String sql = "SELECT * FROM Conteudo WHERE codigo = ?";
		Conteudo conteudo = new Conteudo();
		try (Connection connection = con.getConnection();) {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, codigo);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				conteudo.setCodigo(resultSet.getInt("codigo"));
				conteudo.setLocal(resultSet.getString("local"));
				conteudo.setNome(resultSet.getString("conteudo"));
			}
			return conteudo;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("erro ao buscar o conteudo "+codigo);
			e.printStackTrace();
		}
		return null;
	}
}
