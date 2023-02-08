package edu.miu.lab12.services;

import edu.miu.lab12.models.User;

import java.util.List;

public interface IUserService {

    List<User> getUsers();
    User saveUser(User user);
    User getUserById(Integer userId);

}
