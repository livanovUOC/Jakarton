package com.proyecto.Jakarton.controller;

import com.proyecto.Jakarton.DAO.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login-servlet")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public LoginController (){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String SUCCESS = "/WEB-INF/jsp/success.jsp";
        final String FAILURE = "/WEB-INF/jsp/failure.jsp";

        String strUrl = "";

        String username = request.getParameter("ldapUsername");
        String password = request.getParameter("ldapPassword");


        LDAPConexion conn = new LDAPConexion(username, password);

        if (conn.ifConexion()){
            conn.DesconectarBasedeDatos();

            System.out.println("Success");
            request.setAttribute("username", username);
            request.getRequestDispatcher(SUCCESS).forward(request, response);

        } else {
            conn.DesconectarBasedeDatos();
            System.out.println("Failure");
            request.getRequestDispatcher(FAILURE).forward(request, response);
        }
    }
}
