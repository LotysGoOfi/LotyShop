package by.itacademy.lotys.web.shop.lotyshop.entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne(targetEntity = Company.class)
    @JoinColumn(name = "company_id")
    private Company company;

    private BigDecimal price;
    private String name;
    private int value;
    private String description;

    @Column(name = "url_image")
    private String urlImage;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "products_category_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<CategoryProduct> categoryProducts = new HashSet<>();


    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }
        if(obj.getClass()!=this.getClass()){
            return false;
        }
        if(obj == this){
            return true;
        }
        return Objects.equals(this.id,((Product) obj).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
