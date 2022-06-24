package by.itacademy.lotys.web.shop.lotyshop.controllers.administration.companies;

import by.itacademy.lotys.web.shop.lotyshop.services.companies.CompanyService;
import by.itacademy.lotys.web.shop.lotyshop.services.companies.ImplementCompanyService;
import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log
@WebServlet(urlPatterns = "/administration/companies/delete")
public class CompanyDeleteServlet extends HttpServlet {

    private final CompanyService companyServices = new ImplementCompanyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        companyServices.delete(id);
        log.info(":delete company by id ="+id);
        resp.sendRedirect(req.getContextPath()+"/administration/companies");
    }
}
