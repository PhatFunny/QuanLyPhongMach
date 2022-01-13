/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class NhanVienDetailController {
    
    @Autowired
    private NhanVienService nhanVienService;
    
    @GetMapping("/admin/nhanvien/{idNV}")
    public String detail(Model model,@PathVariable(value = "idNV") int idNV){
        model.addAttribute("nhanvien", this.nhanVienService.getNhanVienById(idNV));
        return "nhanvien-detail";
    }
    
    @DeleteMapping("/admin/api/nhanvien/{idNV}")
    @ResponseStatus(HttpStatus.OK)
    public void deleleNhanVien(@PathVariable(name = "idNV") int idNV) {
        this.nhanVienService.deleteNhanVien(idNV);

    } 
}
