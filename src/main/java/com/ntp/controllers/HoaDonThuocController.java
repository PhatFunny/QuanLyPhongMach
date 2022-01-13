/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.ToaThuoc;
import com.ntp.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Phat Nguyen
 */
@Controller
@ControllerAdvice
public class HoaDonThuocController {   
    
    @GetMapping("/hoadonthuoc")
    public String hoadonView(Model model, HttpSession session){
        Map<Integer, ToaThuoc> toathuoc = (Map<Integer, ToaThuoc>) session.getAttribute("toathuoc");
        if(toathuoc != null)
            model.addAttribute("toathuocs", toathuoc.values());
        else 
            model.addAttribute("toathuocs", null);
        model.addAttribute("toathuocs", Utils.toathuocStarts((Map<Integer, ToaThuoc>) session.getAttribute("toathuoc")));
        
        return "hoadonthuoc";
    }
}
