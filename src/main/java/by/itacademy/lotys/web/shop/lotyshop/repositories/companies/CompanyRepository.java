package by.itacademy.lotys.web.shop.lotyshop.repositories.companies;

import by.itacademy.lotys.web.shop.lotyshop.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository< Company,UUID> {
}
