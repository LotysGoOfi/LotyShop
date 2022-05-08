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
@WebServlet(urlPatterns = "/administration/companies/change")
public class ChangeCompanyServlet extends HttpServlet {

    private final CompanyServices companyServices = new ImplementCompanyServices();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Company company = companyServices.getCompany(id);
        req.setAttribute("company",company);
        req.getRequestDispatcher("/pages/administration/companies/changeCompany.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String newName = req.getParameter("newName");

        companyServices.updateCompany(id,newName);
        resp.sendRedirect(req.getContextPath()+"/administration/companies");
        log.info(":update company id="+id +" name= "+newName);
    }
}
