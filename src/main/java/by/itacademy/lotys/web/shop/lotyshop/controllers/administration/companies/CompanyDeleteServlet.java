package by.itacademy.lotys.web.shop.lotyshop.controllers.administration.companies;

import by.itacademy.lotys.web.shop.lotyshop.services.companies.CompanyServices;
import by.itacademy.lotys.web.shop.lotyshop.services.companies.ImplementCompanyServices;
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

    private final CompanyServices companyServices = new ImplementCompanyServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        companyServices.deleteCompany(id);
        log.info(":delete company by id ="+id);
        resp.sendRedirect(req.getContextPath()+"/administration/companies");
    }
}
