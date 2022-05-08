package by.itacademy.lotys.web.shop.lotyshop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private Company company;
    private int price;
    private int appraisal;
    private String name;
    private int value;
    private String description;
    private String image;
}
