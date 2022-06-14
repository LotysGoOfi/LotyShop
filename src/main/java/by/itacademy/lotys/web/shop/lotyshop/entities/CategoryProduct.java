package by.itacademy.lotys.web.shop.lotyshop.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "product_categories")
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "categoryProducts")
    private Set<Product> products = new HashSet<>();
    public CategoryProduct(){}

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
        return Objects.equals(this.id,((CategoryProduct) obj).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
