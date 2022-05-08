package by.itacademy.lotys.web.shop.lotyshop.filters;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebFilter("/*")
public class MainFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();

        if(null != session.getAttribute("userInfo")){
            req.setAttribute("isAuthorized",true);
        }
        else {
            req.setAttribute("isAuthorized",false);
        }
        chain.doFilter(req,res);
    }
}
