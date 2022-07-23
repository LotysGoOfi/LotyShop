package by.itacademy.lotys.web.shop.lotyshop.entities;

import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@ToString
@Builder
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String email;

    private String name;

    private String password;


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
        return Objects.equals(this.id,((User) obj).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}