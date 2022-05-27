package by.itacademy.lotys.web.shop.lotyshop.controllers.administration.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.properties.Config;
import by.itacademy.lotys.web.shop.lotyshop.services.users.ImplementUserService;
import by.itacademy.lotys.web.shop.lotyshop.services.users.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/administration/users")
public class UsersAdministrationServlet extends HttpServlet {

    private final UserService userService = new ImplementUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> AllUsers = userService.getAllUsers();
        req.setAttribute("users",AllUsers);

        req.getRequestDispatcher(Config.URL_ADMINISTRATION_USERS).forward(req,resp);
    }
}
