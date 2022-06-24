package by.itacademy.lotys.web.shop.lotyshop.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_categories")
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "categoryProducts")
    private Set<Product> products = new HashSet<>();

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
