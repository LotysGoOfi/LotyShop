package by.itacademy.lotys.web.shop.lotyshop.entities;

import lombok.*;


import javax.persistence.*;
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
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "url_Logo")
    private String urlLogo;


    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private Set<Product> products = new HashSet<>();


    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "cities_companies",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<City> cities = new HashSet<>();



    @Override
    public int hashCode() {
        return Objects.hashCode(this.id);
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
        return Objects.equals(this.id,((Company) obj).id);
    }
}
