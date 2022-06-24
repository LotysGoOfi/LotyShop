package by.itacademy.lotys.web.shop.lotyshop.controllers;


import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.services.users.ImplementUserService;
import by.itacademy.lotys.web.shop.lotyshop.services.users.UserService;
import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Log
@WebServlet(urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {


    private final UserService userService = new ImplementUserService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String email = req.getParameter("email");
        final String password = req.getParameter("password");

        User user = new User();

        if (null == user) {
            resp.sendRedirect(req.getContextPath() + "/authorization");
            return;
        }

        if (! Objects.equals(user.getPassword(),password)) {
            req.getRequestDispatcher("/pages/authorization.jsp").forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/authorization");
        }

        HttpSession session = req.getSession();
        session.setAttribute("userInfo", user);

        log.info(" :name = "+ user.getNickName()+ "role = "+ user.getUserRole());

    }
}
