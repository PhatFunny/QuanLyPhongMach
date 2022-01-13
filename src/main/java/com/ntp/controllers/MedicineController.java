/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.ToaThuoc;
import com.ntp.service.BenhNhanService;
import com.ntp.service.GioKhamService;
import com.ntp.service.LoaiThuocService;
import com.ntp.service.NhanVienService;
import com.ntp.service.ThuocService;
import com.ntp.utils.Utils;
import java.util.Map;
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
public class MedicineController {
    
    @Autowired
    private LoaiThuocService loaiThuocService;
    
    @Autowired
    private GioKhamService gioKhamService;
    
    @Autowired
    private NhanVienService nhanVienService;
    
    @Autowired
    private ThuocService thuocService;


    
    @ModelAttribute
    public void commonAttr(Model model, HttpSession session){
        model.addAttribute("loaithuoc", this.loaiThuocService.getLoaiThuoc());
        model.addAttribute("toaThuocCounter", Utils.countToaThuoc((Map<Integer, ToaThuoc>) session.getAttribute("toathuoc")));
        model.addAttribute("currentUser", session.getAttribute("currentUser"));
        model.addAttribute("giokham", this.gioKhamService.getGioKham());
        model.addAttribute("nhanvien", this.nhanVienService.getNhanVienList());
    }
    
    @GetMapping("/admin/medicine")
    public String medicine(Model model,
            @RequestParam(name = "loaiThuocId", required = false) String loaiThuocId,
            @RequestParam(value = "kw", required = false, defaultValue = "") String kw, 
            @RequestParam(value = "page", required = false, defaultValue = "1") String page){
        
        if(loaiThuocId == null){
            model.addAttribute("thuoc", this.thuocService.getThuoc(kw, Integer.parseInt(page))); 
        } else {
            model.addAttribute("thuoc", 
                    this.loaiThuocService.getLoaiThuocById(Integer.parseInt(loaiThuocId)).getThuocCollection());
        }
        
        
        model.addAttribute("thuocCounter", this.thuocService.countThuoc());
        return "medicine";
    }
    
    

}
