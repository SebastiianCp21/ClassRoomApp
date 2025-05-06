package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.helpers.MessagesAPI;
import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
                throw new Exception(MessagesAPI.USER_NOT_FOUND.getText());
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }

    public User searchUserById(Integer id)throws Exception{
        try {
            Optional<User> userWantToFind = this.repository.findById(id);
            if (userWantToFind.isPresent()){
                return userWantToFind.get();
            }else {
                throw new Exception(MessagesAPI.USER_NOT_FOUND.getText());
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List<User> searchAllUsers()throws Exception{
        try {
            return this.repository.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean deleteUser(Integer id)throws Exception{
        try {
            Optional<User> userWantToFind = this.repository.findById(id);
            if (userWantToFind.isPresent()){
                this.repository.deleteById(id);
                return true;
            }else{
                throw new Exception(MessagesAPI.USER_NOT_FOUND.getText());
            }
        }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
