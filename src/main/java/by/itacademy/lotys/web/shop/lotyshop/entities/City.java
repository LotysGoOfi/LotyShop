package by.itacademy.lotys.web.shop.lotyshop.entities;

import lombok.*;

import javax.persistence.*;

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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "cities")
    private Set<Company> companies = new HashSet<>();

    @PreRemove
    private void preRemove(){
        companies.forEach(company->company.getCities().remove(this));
        companies.clear();
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
        return Objects.equals(this.id,((City) obj).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
