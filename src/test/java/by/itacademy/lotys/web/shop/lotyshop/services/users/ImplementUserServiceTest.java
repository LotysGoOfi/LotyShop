package by.itacademy.lotys.web.shop.lotyshop.services.users;

import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.UserRepository;
import liquibase.pro.packaged.U;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ImplementUserServiceTest {

    @InjectMocks
    private UserServiceImplement userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void getByID() {
        UUID id = UUID.randomUUID();
        User user = User.builder().name("test").build();
        given(userRepository.findById(id)).willReturn(Optional.of(user));
        User userByID = userService.getByID(id);
        assertEquals(user,userByID);
    }

    @Test
    void getUserByEmail() {
        String email =  "email.test";
        User user = User.builder().email(email).build();
        given(userRepository.findUserByEmail(email)).willReturn(user);
        User userByEmail = userService.getUserByEmail(email);
        assertEquals(user,userByEmail);
    }

    @Test
    void update() {
        UUID uuid = UUID.randomUUID();
        User newUser = User.builder().id(uuid).name("newUser").build();
        given(userRepository.existsById(uuid)).willReturn(true);
        given(userRepository.save(newUser)).willReturn(newUser);
        User updateUser = userService.update(newUser);
        assertEquals(newUser,updateUser);
    }

    @Test
    void delete() {
    }

    @Test
    void create() {
    }

    @Test
    void getAll() {
    }

    @Test
    void testGetAll() {
    }

    @Test
    void getUsersBuRole() {
    }
}