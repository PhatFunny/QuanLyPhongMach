/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.pojos.ToaThuoc;
import com.ntp.service.HoaDonService;
import com.ntp.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Phat Nguyen
 */
@RestController
public class ApiToaThuocController {
    @Autowired
    private HoaDonService hoaDonService;
    
    @PostMapping("/api/toathuoc")
    public int addToToaThuoc(@RequestBody ToaThuoc params, HttpSession session){
        Map<Integer, ToaThuoc> toathuoc = (Map<Integer, ToaThuoc>) session.getAttribute("toathuoc");
        if(toathuoc == null)
            toathuoc = new HashMap<>();
        
        int thuocId = params.getIdthuoc();
        if(toathuoc.containsKey(params.getIdthuoc()) == true){
            ToaThuoc t = toathuoc.get(thuocId);
            t.setQuantity(t.getQuantity() + 1);
        } else { //thuốc chưa có trong toa
            toathuoc.put(thuocId, params);
        }
        
        session.setAttribute("toathuoc", toathuoc);
        
        return Utils.countToaThuoc(toathuoc);
    }
    
    @PutMapping("/api/toathuoc")
    public ResponseEntity<Map<String, String>> updateToaThuocItem(@RequestBody ToaThuoc params, HttpSession session){
        Map<Integer, ToaThuoc> toathuoc = (Map<Integer, ToaThuoc>) session.getAttribute("toathuoc");
        if(toathuoc == null)
            toathuoc = new HashMap<>();
        
        int thuocId = params.getIdthuoc();
        if(toathuoc.containsKey(params.getIdthuoc()) == true){
            ToaThuoc t = toathuoc.get(thuocId);
            t.setQuantity(params.getQuantity());
            //Demo thử
            t.setCachdung(params.getCachdung());
        }
        
        session.setAttribute("toathuoc", toathuoc);
        
        return new ResponseEntity<>(Utils.toathuocStarts(toathuoc), HttpStatus.OK);
    }
    
    @DeleteMapping("/api/toathuoc/{idthuoc}")
    public ResponseEntity<Map<String, String>> deleteToaThuocItem(@PathVariable(value = "idthuoc") int idthuoc,
            HttpSession session){
        Map<Integer, ToaThuoc> toathuoc = (Map<Integer, ToaThuoc>) session.getAttribute("toathuoc");
        if(toathuoc != null && toathuoc.containsKey(idthuoc)){
            toathuoc.remove(idthuoc);
            
            session.setAttribute("toathuoc", toathuoc);
        }
        
        return new ResponseEntity<>(Utils.toathuocStarts(toathuoc), HttpStatus.OK);
    }
    
    @PostMapping("/api/thanhtoan")
    public HttpStatus thanhtoan(HttpSession session){
        if(this.hoaDonService.addHoaDon((Map<Integer, ToaThuoc>) session.getAttribute("toathuoc")) == true){
            session.removeAttribute("toathuoc");
            return HttpStatus.OK;
        }

        return HttpStatus.BAD_REQUEST;
    }
}
