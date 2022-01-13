/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.service.PhieuKhamBenhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class PhieuKhamBenhController {
    @Autowired
    private PhieuKhamBenhService phieuKhamBenhService;
    
    @GetMapping("/phieukhambenh")
    public String nhanvien(Model model,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw, 
            @RequestParam(value = "page", required = false, defaultValue = "1") String page){
        model.addAttribute("phieukhambenh", this.phieuKhamBenhService.getPhieuKhamBenh(kw, Integer.parseInt(page))); 
        model.addAttribute("phieuKhamBenhCounter", this.phieuKhamBenhService.countPhieuKhamBenh());
        return "phieukhambenh";
    }
    
}
