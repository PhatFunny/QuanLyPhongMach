/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.service.NhanVienService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class HomeController {
    @Autowired
    private NhanVienService nhanVienService;

    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        model.addAttribute("ExperNhanVien", this.nhanVienService.getExperNhanVien(4));

        return "index";
    }
    
}
