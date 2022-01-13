/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.NhanVien;
import com.ntp.service.NhanVienService;
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
public class QuanLyNhanVienController {
    @Autowired
    private NhanVienService nhanVienService;

    
    @GetMapping("/admin/quanlynhanvien")
    public String addOrUpdateView(Model model,
            @RequestParam(name = "idNV", defaultValue = "0") int idNV) {
        if (idNV > 0) // cập nhật
            model.addAttribute("nhanvien", this.nhanVienService.getNhanVienById(idNV));
        else // thêm
            model.addAttribute("nhanvien", new NhanVien());
        
        
        return "quanlynhanvien";
    }
    
    @PostMapping("/admin/quanlynhanvien")
    public String addOrUpdateNhanVien(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date ,@ModelAttribute(value = "nhanvien") @Valid NhanVien nhanvien, 
            BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            return "quanlynhanvien";
        }
        
        if (!this.nhanVienService.addOrUpdateNhanVien(nhanvien)) {
            model.addAttribute("errMsg", "Hệ thóng đang có lỗi! Vui lòng quay lại sau!");
            return "quanlynhanvien";
        }
        
        return "redirect:nhanvien";

    }
}
