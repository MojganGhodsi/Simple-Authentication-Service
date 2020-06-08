package com.sample.authenticationservice.service;

import com.sample.authenticationservice.model.UserModel;

public interface IAuthService {
    String login(UserModel model);

    String register(UserModel model);

    String logout(UserModel model);
}
