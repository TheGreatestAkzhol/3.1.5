package com.tomik.RestApi.RestLastTask.services;


import com.tomik.RestApi.RestLastTask.dto.UserDTO;
import com.tomik.RestApi.RestLastTask.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);

    List<User> findAllUsers();

    void update(int id, User updateUser);

    void delete(int id);

    Optional<User> findUser(int id);

    Optional<User> userByUsername(String username);

    User convertToUser(UserDTO userDTO);

    UserDTO convertToDTO(User user);

}
