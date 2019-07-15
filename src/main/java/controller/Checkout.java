package controller;

import dao.ProductDAO;
import dao.UserDAO;
import model.Cart;
import model.Product;
import model.User;
import sun.rmi.runtime.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@WebServlet(name = "Checkout", value="/checkout")
public class Checkout extends HttpServlet {
    private ProductDAO productDAO;
    private List<Product> productList;
    private HashMap<String, User> users = UserDAO.getAllUsers();

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        productList = productDAO.getAllProducts();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        String LoggedUser = (String)session.getAttribute("username");
        User currentUser = (users.get(LoggedUser));

        if(session.getAttribute("cart") != null){
            currentUser.setCard((Cart)session.getAttribute("cart"));
        }

        int id = parseInt(request.getParameter("productId"));
        List<Product> selected = productList.stream().filter(p->p.getId()==id).collect(Collectors.toList());

        String btn = request.getParameter("removeBtn");

        if (request.getParameter("btn1") != null){
            currentUser.getCard().removeFromCart(selected.get(0));
        }else{
            currentUser.getCard().addToCart(selected.get(0));
        }

        session.setAttribute("cart", currentUser.getCard());
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String LoggedUser = (String)session.getAttribute("username");
        System.out.println(LoggedUser + ">>");

        User currentUser = (users.get(LoggedUser));

        if(session.getAttribute("cart") != null){
            currentUser.setCard((Cart)session.getAttribute("cart"));
        }

        request.setAttribute("user", LoggedUser);

        Cart cart = currentUser.getCard();
        request.setAttribute("products", productList);
        request.setAttribute("myProducts", cart.getProducts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout.jsp");
        dispatcher.forward(request, response);
    }
}
