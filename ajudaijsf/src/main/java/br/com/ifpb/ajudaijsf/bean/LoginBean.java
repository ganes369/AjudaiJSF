package br.com.ifpb.ajudaijsf.bean;

import br.com.ifpb.ajudaijsf.model.entities.Administrador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginBean {
    private Administrador administrador;

}
