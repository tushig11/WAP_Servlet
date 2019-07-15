package controller;

import dao.ProductDAO;
import model.Cart;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@WebServlet(name = "Main", value = "")
public class Main extends HttpServlet {
    private ProductDAO productDAO;
    private List<Product> productList;
    private Cart cart;
    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO();
        productList = productDAO.getAllProducts();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("cart") == null){
            cart = new Cart();
        }else {
            cart = (Cart)session.getAttribute("cart");
        }

        int id = parseInt(request.getParameter("productId"));
        List<Product> selected = productList.stream().filter(p->p.getId()==id).collect(Collectors.toList());
        cart.addToCart(selected.get(0));

        session.setAttribute("cart", cart);

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("user","Guest");
        request.setAttribute("products", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
