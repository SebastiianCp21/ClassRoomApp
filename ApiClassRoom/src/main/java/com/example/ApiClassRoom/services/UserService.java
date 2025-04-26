package com.example.ApiClassRoom.services;

import com.example.ApiClassRoom.models.User;
import com.example.ApiClassRoom.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IUserRepository repository;

    //GUARDAR
    public User saveUser(User Userdata)throws Exception{
        try{
            return this.repository.save(Userdata);
    }catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
