/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.service.ThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class MedicineDetailController {
    @Autowired
    private ThuocService thuocService;
    
    @GetMapping("/thuoc/{idthuoc}")
    public String detail(Model model,@PathVariable(value = "idthuoc") int idthuoc){
        model.addAttribute("thuoc", this.thuocService.getThuocById(idthuoc));
        return "medicine-detail";
    }
    
    @DeleteMapping("/admin/api/thuoc/{idthuoc}")
    @ResponseStatus(HttpStatus.OK)
    public void deleleThuoc(@PathVariable(name = "idthuoc") int idthuoc) {
        this.thuocService.deleteThuoc(idthuoc);

    }
}
