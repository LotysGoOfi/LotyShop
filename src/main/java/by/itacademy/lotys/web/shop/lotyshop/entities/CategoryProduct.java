package by.itacademy.lotys.web.shop.lotyshop.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @ToString.Exclude
    @ManyToMany(mappedBy = "categoryProducts")
    private Set<Product> products;

    @PreRemove
    private void preRemove(){
        products.forEach(product->product.getCategoryProducts().remove(this));
        products.clear();
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
        return Objects.equals(this.id,((CategoryProduct) obj).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
