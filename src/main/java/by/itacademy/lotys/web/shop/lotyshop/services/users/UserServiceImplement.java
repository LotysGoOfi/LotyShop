package by.itacademy.lotys.web.shop.lotyshop.services.users;



import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getByID(UUID id) {
        return userRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("no user by " + id));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    @Transactional
    public User update(User userRequest) {
        if(userRepository.existsById(userRequest.getId())) {
           userRepository.save(userRequest);
        }
        return userRequest;
    }

    @Override
    @Transactional
    public User delete(UUID id) {
        User user = getByID(id);
        userRepository.delete(user);
        return user;
    }


    @Override
    @Transactional
    public User create(User requestUser) {
        requestUser.setPassword(passwordEncoder.encode(requestUser.getPassword()));
        return userRepository.save(requestUser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> getUsersBuRole(UserRole userRole, Pageable pageable) {
        Page<User> all = userRepository.findAll(pageable);
        return all.stream()
                .filter(user -> user.getRole() == userRole)
                .collect(Collectors.toList());
    }
}
