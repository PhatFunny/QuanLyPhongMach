/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.NhanVien;
import com.ntp.pojos.PhieuKhamBenh;
import com.ntp.service.PhieuKhamBenhService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class QuanLyPhieuKhamBenh {
    @Autowired
    private PhieuKhamBenhService phieuKhamBenhService;


    
    @GetMapping("/quanlyphieukhambenh")
    public String addOrUpdateView(Model model,
            @RequestParam(name = "idPKB", defaultValue = "0") int idPKB) {
        if (idPKB > 0) // cập nhật
            model.addAttribute("phieukhambenh", this.phieuKhamBenhService.getPhieuKhamBenhById(idPKB));
        else // thêm
            model.addAttribute("phieukhambenh", new PhieuKhamBenh());
        
        
        return "quanlyphieukhambenh";
    }
    
    @PostMapping("/quanlyphieukhambenh")
    public String addOrUpdatePhieuKhamBenh(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date ,@ModelAttribute(value = "phieukhambenh") @Valid PhieuKhamBenh phieukhambenh, 
            BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            return "quanlyphieukhambenh";
        }
        
        if (!this.phieuKhamBenhService.addOrUpdatePhieuKhamBenh(phieukhambenh)) {
            model.addAttribute("errMsg", "Hệ thóng đang có lỗi! Vui lòng quay lại sau!");
            return "quanlyphieukhambenh";
        }
        
        return "redirect:phieukhambenh";
    }
}
