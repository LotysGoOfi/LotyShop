package by.itacademy.lotys.web.shop.lotyshop.filters;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import lombok.extern.java.Log;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@Log
@WebFilter(urlPatterns = "/administration/*")
public class AdministrationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("userInfo");
        if(user == null){
            log.info(": no authorization");
            res.sendRedirect(req.getContextPath()+"/");
            return;
        }


//        if (user.getUserRole() == UserRole.ADMIN) {
//            log.info(": admin");
//            chain.doFilter(req, res);
//        } else {
//            log.info(": user");
//            res.sendRedirect(req.getContextPath() + "/");
//        }
    }
}
