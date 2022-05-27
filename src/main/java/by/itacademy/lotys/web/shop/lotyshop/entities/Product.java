package by.itacademy.lotys.web.shop.lotyshop.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Product {
    private int id;
    private Company company;
    private BigDecimal price;
    private int appraisal;
    private String name;
    private int value;
    private String description;
    private String image;
    private String category;
}
