package com.security.controllers;

import com.security.models.User;
import com.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private UserRepository repo;

//    List<User> getAllUsers() {
//        return repo.findAll();
//    }
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("home");

        return view;
    }

    @GetMapping("/home")
    public ModelAndView home() {
        //
        ModelAndView view = new ModelAndView("home");

        return view;
    }
}
