package by.itacademy.lotys.web.shop.lotyshop.controllers;

import by.itacademy.lotys.web.shop.lotyshop.services.users.ImplementUserService;
import by.itacademy.lotys.web.shop.lotyshop.services.users.UserService;
import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@WebServlet(urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = new ImplementUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String email = req.getParameter("email");
        final String nickName = req.getParameter("nickName");
        final String password = req.getParameter("password");
        final String repeatPassword = req.getParameter("repeatPassword");

        if(!password.equals(repeatPassword)){
            req.setAttribute("isPasswordMatches",true);
            log.info(": password not equal repeatPassword");
            req.getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
            return;
        }
        else {
            req.setAttribute("isPasswordMatches",false);
        }

        if(userService.getUser(email).isPresent()){
            req.setAttribute("isEmailExist",true);
            log.info(": email already taken! "+userService.getUser(email));
            req.getRequestDispatcher("/pages/registration.jsp").forward(req,resp);
            return;
        }
        else {
            req.setAttribute("isEmailExist",false);
        }

        userService.createUser(email,nickName,password);
        log.info(": new User = nickName = "+ nickName+ "; email= "+ email +"; password= "+password+";");
        resp.sendRedirect(req.getContextPath()+"/");
    }
}