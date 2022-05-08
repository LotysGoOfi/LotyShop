package by.itacademy.lotys.web.shop.lotyshop.controllers.servlets.administration;


import by.itacademy.lotys.web.shop.lotyshop.properties.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/administration")
public class AdministrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher(Config.URL_ADMINISTRATION_JSP).forward(req,resp);
    }
}