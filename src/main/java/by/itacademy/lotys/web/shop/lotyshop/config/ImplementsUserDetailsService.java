package by.itacademy.lotys.web.shop.lotyshop.config;


import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ImplementsUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        by.itacademy.lotys.web.shop.lotyshop.entities.User user = userRepository.getUserByEmail(email);


        if(user == null){
            throw new UsernameNotFoundException("");
        }

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .authorities(UserRole.USER.name())
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }

}
