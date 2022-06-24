package by.itacademy.lotys.web.shop.lotyshop.controllers.administration.companies;


import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import by.itacademy.lotys.web.shop.lotyshop.services.companies.CompanyService;
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
public class CompanyChangeServlet extends HttpServlet {

    private final CompanyService companyServices = new ImplementCompanyServices();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Company company = companyServices.findById(id).orElse(Company.builder().name("null").build());
        req.setAttribute("company",company);
        req.getRequestDispatcher("/pages/administration/companies/changeCompany.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        String newName = req.getParameter("newName");

        Company company = Company.builder()
                .id(id)
                .name(newName)
                .build();

        companyServices.update(company);
        resp.sendRedirect(req.getContextPath()+"/administration/companies");
        log.info(":update company id="+id +" name= "+newName);
    }
}
