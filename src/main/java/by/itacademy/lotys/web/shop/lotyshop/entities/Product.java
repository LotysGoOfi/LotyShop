package by.itacademy.lotys.web.shop.lotyshop.entities;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ToString.Exclude
    @ManyToOne(targetEntity = Company.class)
    private Company company;

    private BigDecimal price;

    private String name;

    private int amount;

    private String description;

    private String urlImage;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "product_and_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "product_category_id"))
    private Set<CategoryProduct> categoryProducts = new HashSet<>();

    @PreRemove
    private void preRemove(){
        categoryProducts.forEach(categoryProduct->categoryProduct.getProducts().remove(this));
        categoryProducts.clear();
    }

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
