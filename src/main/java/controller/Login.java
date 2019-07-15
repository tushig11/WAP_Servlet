package controller;

import dao.ProductDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "Login", value="/login")
public class Login extends HttpServlet {

    private HashMap<String,User> users = UserDAO.getAllUsers();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember");

        if(users.containsKey(username) && users.get(username).getPassword().equals(password)){
            //Creating new session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(24*60*60); //second

            if(rememberMe == null){
                //Deleting existing cookie
                Cookie c = new Cookie("member", "");
                c.setMaxAge(0);
                response.addCookie(c);
            }else{
                //Creating new cookie
                Cookie c = new Cookie("member", username);
                c.setMaxAge(1800);
                response.addCookie(c);
            }
            response.sendRedirect("checkout");
        }else{
            request.setAttribute("message","Invalid Credential");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Enter your Credential");
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
