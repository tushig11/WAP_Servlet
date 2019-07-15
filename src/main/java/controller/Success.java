package controller;

import dao.ProductDAO;
import dao.UserDAO;
import model.Cart;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Success", value = "/success")
public class Success extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        String LoggedUser = (String)session.getAttribute("username");

        request.setAttribute("user", LoggedUser);
        session.invalidate();
        User currentUser = (UserDAO.getAllUsers().get(LoggedUser));

        Cart cart = currentUser.getCard();
        request.setAttribute("myCart", cart);

        RequestDispatcher view = request.getRequestDispatcher("success.jsp");
        view.forward(request, response);
    }
}
