package br.com.ifpb.ajudaijsf.model.persistence.dao;


import br.com.ifpb.ajudaijsf.model.entities.Administrador;
import br.com.ifpb.ajudaijsf.model.persistence.ConnectionFactory;
import br.com.ifpb.ajudaijsf.model.persistence.interfaces.EntitiesDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDao implements EntitiesDao {
    private ConnectionFactory conFactory;

    public AdministradorDao(){
        conFactory = new ConnectionFactory();
    }

    @Override
    public boolean addEntitie(Object object) {
        return false;
    }

    @Override
    public boolean removeEntitie(Object object) {
        return false;
    }

    @Override
    public boolean updateEntitie(Object object) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("");

        }
        return false;
    }

    @Override
    public Object searchEntitie(String id) throws SQLException, ClassNotFoundException {
        try(Connection connection = conFactory.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ADMINISTRADOR WHERE email = ?");
            statement.setString(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String senha = resultSet.getString("senha");
                return new Administrador(resultSet.getInt("codigo"),resultSet.getString("nomecompleto"),
                        resultSet.getString("email"), resultSet.getString("senha"),
                        resultSet.getDate("datainicio").toLocalDate());
            }else{
                return null;
            }
        }
    }
}
