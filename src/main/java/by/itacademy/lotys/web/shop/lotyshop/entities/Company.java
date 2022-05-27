package by.itacademy.lotys.web.shop.lotyshop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class Company {
    private int id;
    private String name;
    private String urlLogo;
    private List<String> countries;
}
