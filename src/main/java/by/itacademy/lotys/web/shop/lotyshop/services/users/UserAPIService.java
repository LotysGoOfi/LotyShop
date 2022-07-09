package by.itacademy.lotys.web.shop.lotyshop.services.users;


import by.itacademy.lotys.web.shop.lotyshop.dtos.user.UserRequest;
import by.itacademy.lotys.web.shop.lotyshop.dtos.user.UserResponse;
import by.itacademy.lotys.web.shop.lotyshop.entities.User;
import by.itacademy.lotys.web.shop.lotyshop.entities.enums.UserRole;
import by.itacademy.lotys.web.shop.lotyshop.repositories.user.UserRepository;
import by.itacademy.lotys.web.shop.lotyshop.transformers.user.UserTransformers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAPIService implements UserService {

    private final UserRepository userRepository;
    private final UserTransformers userTransformers;

    @Override
    public UserResponse getByID(UUID id) {
        return userTransformers.getResponse(getUser(id));
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userTransformers.getResponse(
                userRepository.getUsersByEmail(email));
    }

    @Override
    @Transactional
    public UserResponse update(UserRequest userRequest, UUID id) {
        User user = getUser(id);
        user.setEmail(userRequest.getEmail());
        user.setLogin(userRequest.getLogin());
        user.setPassword(userRequest.getPassword());
        return userTransformers.getResponse(
                userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResponse delete(UUID id) {
        User user = getUser(id);
        userRepository.delete(user);
        return userTransformers.getResponse(user);
    }


    @Override
    @Transactional
    public UserResponse create(UserRequest requestUser) {
        return userTransformers.getResponse(
                userRepository.save(
                        userTransformers.getEntity(requestUser)));
    }

    @Override
    public List<UserResponse> getAll() {
        return userTransformers.getResponses(
                userRepository.findAll());
    }

    @Override
    public List<UserResponse> getUsersBuRole(UserRole userRole) {
        return userTransformers.
                getResponses(userRepository.getUsersBy(userRole));
    }

    private User getUser(UUID id) {
        return userRepository.findById(id).
                orElseThrow(() -> new NoSuchElementException("no user by " + id));
    }
}
