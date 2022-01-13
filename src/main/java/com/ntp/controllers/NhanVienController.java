/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.service.ChucVuService;
import com.ntp.service.LichTrucService;
import com.ntp.service.NhanVienService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phat Nguyen
 */
@Controller
@ControllerAdvice
public class NhanVienController {
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private LichTrucService lichTrucService;
    @Autowired
    private NhanVienService nhanVienService;


    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("chucvu", this.chucVuService.getChucVu());
        model.addAttribute("lichtruc", this.lichTrucService.getLichTruc());
    }
    
    @GetMapping("/admin/nhanvien")
    public String nhanvien(Model model,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw, 
            @RequestParam(value = "page", required = false, defaultValue = "1") String page){
        model.addAttribute("nhanvien", this.nhanVienService.getNhanVien(kw, Integer.parseInt(page))); 
        model.addAttribute("nhanVienCounter", this.nhanVienService.countNhanVien());
        return "nhanvien";
    }
}
