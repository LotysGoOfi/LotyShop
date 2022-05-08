package by.itacademy.lotys.web.shop.lotyshop.controllers.servlets.administration.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
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
@WebServlet(urlPatterns = "/administration/companies/create")
public class CreateCompanyServlet extends HttpServlet {

    private final CompanyServices companyServices = new ImplementCompanyServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/administration/companies/createCompany.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newName = req.getParameter("newName");
        Company company = companyServices.createCompany(newName);
        resp.sendRedirect(req.getContextPath()+"/administration/companies");
        log.info(":create company id="+company.getId() +" name= "+newName);
    }
}
