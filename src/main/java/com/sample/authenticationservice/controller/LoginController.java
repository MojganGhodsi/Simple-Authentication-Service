package com.sample.authenticationservice.controller;

import com.sample.authenticationservice.model.UserModel;
import com.sample.authenticationservice.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("authenticate")
public class LoginController {

    @Autowired
    IAuthService loginService;

    @GetMapping(path = "/")
    void process(Model model, HttpSession session){
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) session.getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
        }
        model.addAttribute("sessionMessages", messages);
    }

    @PostMapping(path = "/register")
    String register(@RequestBody UserModel userModel,HttpServletRequest request){
        return loginService.register(userModel);
    }

    @PostMapping(path = "/login")
    String login(@RequestBody UserModel userModel, HttpServletRequest request){
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            messages = new ArrayList<>();
            request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
        }
        messages.add(userModel.getUserName()+userModel.getPassword());
        request.getSession().setAttribute("MY_SESSION_MESSAGES", messages);
        return loginService.login(userModel);
    }

    @PostMapping(path = "/test")
    String test(HttpServletRequest request){
        @SuppressWarnings("unchecked")
        List<String> messages = (List<String>) request.getSession().getAttribute("MY_SESSION_MESSAGES");
        if (messages == null) {
            return "user must be logged in to call this api! try again after logging in.";
        }
        else
            return "test api is working.";
    }

    @PostMapping(path = "/logout")
    String logout(@RequestBody UserModel userModel, HttpServletRequest request){
        request.getSession().invalidate();
        return loginService.logout(userModel);
    }

}
