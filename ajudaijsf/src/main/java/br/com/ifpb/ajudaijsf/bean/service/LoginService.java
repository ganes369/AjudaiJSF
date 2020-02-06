package br.com.ifpb.ajudaijsf.bean.service;

import br.com.ifpb.ajudaijsf.model.entities.Administrador;
import br.com.ifpb.ajudaijsf.model.persistence.dao.AdministradorDao;

import java.sql.SQLException;

public class LoginService {
    public static Administrador verificaAdmin(Administrador administrador){
        AdministradorDao administradorDao = new AdministradorDao();
        Administrador admin = null;
        try {
            admin = (Administrador) administradorDao.searchEntitie(administrador.getEmail());
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return admin;
    }
}
