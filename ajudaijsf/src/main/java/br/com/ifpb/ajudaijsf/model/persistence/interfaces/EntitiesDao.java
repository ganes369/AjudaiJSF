package br.com.ifpb.ajudaijsf.model.persistence.interfaces;

import java.sql.SQLException;

public interface EntitiesDao {

    boolean addEntitie(Object object);

    boolean removeEntitie(Object object);

    boolean updateEntitie(Object object) throws SQLException, ClassNotFoundException;

    Object searchEntitie(String id) throws SQLException, ClassNotFoundException;
}
