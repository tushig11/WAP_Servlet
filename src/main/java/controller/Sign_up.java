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

@WebServlet(name = "Sign_up", value="/create")
public class Sign_up extends HttpServlet {

    private UserDAO userDao;
    private HashMap<String, User> users;
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        userDao = new UserDAO();
        productDAO = new ProductDAO();
        users = userDao.getAllUsers();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(users.containsKey(username)){
            //Creating new session
            request.setAttribute("message","Username already exists");
            RequestDispatcher dispatcher = request.getRequestDispatcher("sign_up.jsp");
            dispatcher.forward(request, response);
        }else{
            //Creating new session
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(24*60*60); //second
            userDao.addUser(new User(username,password));
            Cookie c = new Cookie("member", username);
            c.setMaxAge(1800);
            response.addCookie(c);
            response.sendRedirect(request.getContextPath());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message","Enter your Credential");
        RequestDispatcher dispatcher = request.getRequestDispatcher("sign_up.jsp");
        dispatcher.forward(request, response);
    }
}
