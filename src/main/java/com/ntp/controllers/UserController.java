/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.BenhNhan;
import com.ntp.pojos.User;
import com.ntp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());

        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model 
            ,@ModelAttribute(value = "user") User user){
        String errMsg = "";

        
        if(user.getPassword().equals(user.getConfirmPassword())){
            if(this.userDetailsService.addUser(user) == true){
                return "redirect:/login";
            } else {
                errMsg = "Da co loi xay ra, vui long quay lai sau!";
            }
        } else {
            errMsg = "Mật khẩu không khớp!";
        }
        model.addAttribute("errMsg", errMsg);
        
        return "register";
    }
}
