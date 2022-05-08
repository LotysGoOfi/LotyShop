package by.itacademy.lotys.web.shop.lotyshop.controllers.servlets.administration.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.properties.Config;
import by.itacademy.lotys.web.shop.lotyshop.services.companies.CompanyServices;
import by.itacademy.lotys.web.shop.lotyshop.services.companies.ImplementCompanyServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/administration/companies")
public class AdministrationCompaniesServlet extends HttpServlet {

    private final CompanyServices companyServices = new ImplementCompanyServices();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Company> allCompanies = companyServices.getAllCompanies();
        req.setAttribute("companies",allCompanies);
        req.getRequestDispatcher(Config.URL_ADMINISTRATION_COMPANIES_JSP).forward(req,resp);
    }
}
