package br.com.ifpb.ajudaijsf.bean.filter;

import br.com.ifpb.ajudaijsf.model.entities.Administrador;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/pages/*")
public class LoginFilter implements Filter {
    private Administrador administrador;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        if(req.getSession().getAttribute("admin")!=null){
            filterChain.doFilter(req,resp);
        }else{
            resp.sendRedirect("/ajudaijsf/index.xhtml");
        }
    }

    @Override
    public void destroy() {

    }
}
