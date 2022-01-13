/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.BenhNhan;
import com.ntp.pojos.LichKham;
import com.ntp.service.BenhNhanService;
import com.ntp.service.LichKhamService;
import com.ntp.service.NhanVienService;
import com.ntp.service.UserService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phat Nguyen
 */
@Controller
@ControllerAdvice
public class DangKyKhamController {
    @Autowired
    private BenhNhanService benhNhanService;
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private LichKhamService lichKhamService;
    @Autowired
    private UserService userService;

    
    @GetMapping("/dangkykham") 
    public String dangkykhamView(Model model,
                @RequestParam(name = "idLK", defaultValue = "0") int idLK){

        
        if(idLK > 0)
            model.addAttribute("dangky", this.lichKhamService.getLichKhamById(idLK));
        else
            model.addAttribute("dangky", new LichKham());
        
        return "dangkykham";
    }
    
//    @PostMapping("/dangkykham")
//    public String addOrUpdateBenhNhan(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date ,@ModelAttribute(value = "benhnhan") @Valid BenhNhan benhnhan, 
//            BindingResult bindingResult){
//
//
//        if (bindingResult.hasErrors()) {
//            return "dangkykham";
//        }
//        
//        if (!this.benhNhanService.addOrUpdateBenhNhan(benhnhan)) {
//            model.addAttribute("errMsg", "Hệ thóng đang có lỗi! Vui lòng quay lại sau!");
//            return "dangkykham";
//        }
//        
//        return "redirect:dangkykham";
//    }
    
    @PostMapping("/dangkykham")
    public String addLichKham(Model model, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date ,@ModelAttribute(value = "dangky") @Valid LichKham lichkham, 
            BindingResult bindingResult){


        if (bindingResult.hasErrors()) {
            return "dangkykham";
        }
        
        if (!this.lichKhamService.addLichKham(lichkham)) {
            model.addAttribute("errMsg", "Hệ thóng đang có lỗi! Vui lòng quay lại sau!");
            return "dangkykham";
        }
        
        return "redirect:/";
    }

}
