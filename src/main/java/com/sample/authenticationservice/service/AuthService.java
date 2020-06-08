package com.sample.authenticationservice.service;

import com.sample.authenticationservice.mapper.IUserMapper;
import com.sample.authenticationservice.model.UserModel;
import com.sample.authenticationservice.repository.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {
    @Autowired
    IDAO idao;
    @Autowired
    IUserMapper mapper;

    @Override
    public String login(UserModel model) {
        Optional optional = idao.checkIfExists(mapper.userModelToUserEntity(model));
        if (optional.isPresent())
            return "User Logged in successfully ";
        else return "There is not a user with these User name and password";
    }

    @Override
    public String register(UserModel model) {
        try {
            UserModel userModel = mapper.userEntityToUserModel(idao.save(mapper.userModelToUserEntity(model)));
            return "User : "+userModel.getUserName()+" registered Successfully";
        }
        catch (Exception e){
            return "User is not Registered :" +e.getMessage();
        }
    }

    @Override
    public String logout(UserModel model) {
        return null;
    }
}
