package by.itacademy.lotys.web.shop.lotyshop.entities;

import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Objects;
import java.util.UUID;


@Getter
@Setter
@ToString
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    @Column(unique = true)
    private String email;

    @Column(name = "nick_name")
    private String login;

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