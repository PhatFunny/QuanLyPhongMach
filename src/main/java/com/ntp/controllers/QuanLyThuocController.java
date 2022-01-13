/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;


import com.ntp.pojos.Thuoc;
import com.ntp.service.ThuocService;
import java.text.SimpleDateFormat;
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
public class QuanLyThuocController {
    @Autowired
    private ThuocService thuocService;

    
    
    @GetMapping("/admin/quanlythuoc")
    public String addOrUpdateView(Model model,
            @RequestParam(name = "thuocId", defaultValue = "0") int thuocId) {
        if (thuocId > 0) // cập nhật
            model.addAttribute("thuoc", this.thuocService.getThuocById(thuocId));
        else // thêm
            model.addAttribute("thuoc", new Thuoc());
        
        
        return "quanlythuoc";
    }
    
    @PostMapping("/admin/quanlythuoc")
    public String addOrUpdateThuoc(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd") Date date ,@ModelAttribute(value = "thuoc") @Valid Thuoc thuoc, 
            BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "quanlythuoc";
        }
        
        if (!this.thuocService.addOrUpdateThuoc(thuoc)) {
            model.addAttribute("errMsg", "Hệ thóng đang có lỗi! Vui lòng quay lại sau!");
            return "quanlythuoc";
        }
        
        return "redirect:medicine";
    }
    


}


