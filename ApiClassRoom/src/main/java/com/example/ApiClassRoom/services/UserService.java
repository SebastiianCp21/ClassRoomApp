package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepository repository;

    //GUARDAR
    public User saveUser(User userData) throws Exception {
        try {
            return this.repository.save(userData);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public User modifyUser(Integer id, User userData) throws Exception {
        try {
            Optional<User> searchedUser = this.repository.findById(id);
            if (searchedUser.isPresent()) {
                searchedUser.get().setUserType(userData.getUserType());
                searchedUser.get().setName(userData.getName());
                searchedUser.get().setEmail(userData.getEmail());
                searchedUser.get().setPassword(userData.getPassword());
                searchedUser.get().setPhone(userData.getPhone());

                return this.repository.save(searchedUser.get());
            } else {
                throw new Exception("The user you are trying to modify does not exist in the database.");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }
}
