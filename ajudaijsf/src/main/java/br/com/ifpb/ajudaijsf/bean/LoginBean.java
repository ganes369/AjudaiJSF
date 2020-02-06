package br.com.ifpb.ajudaijsf.bean;

import br.com.ifpb.ajudaijsf.bean.service.LoginService;
import br.com.ifpb.ajudaijsf.model.entities.Administrador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@RequestScoped
public class LoginBean {
    private Administrador administrador;

    @PostConstruct
    public void LoginBean(){
       this.administrador = new Administrador();
    }

    public void loginUsuario(){
        administrador = LoginService.verificaAdmin(this.administrador);
        if(administrador!=null){
            FacesContext faces = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) faces.getExternalContext().getSession(true);
            session.setAttribute("admin",this.administrador);
            System.out.println("sucesso");
        }else{
            System.out.println("Erro");
        }

    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
