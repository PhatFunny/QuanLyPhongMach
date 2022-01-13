/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.service.StatsService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Phat Nguyen
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private StatsService statsService;
    
    @GetMapping("/benhnhan-stats")
    public String benhnhanStats(Model model){
        
        model.addAttribute("benhNhanStats", this.statsService.soLuongBenhNhanMonthStats());
        
        return "benhnhan-stats";
    }
    
    @GetMapping("/benhnhan-year-stats")
    public String benhnhanyearStats(Model model){
        
        model.addAttribute("benhNhanYearStats", this.statsService.soLuongBenhNhanYearStats());
        
        return "benhnhan-year-stats";
    }
    
    @GetMapping("/doanhthu-stats")
    public String doanhThuStats(Model model, @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String kw = params.getOrDefault("kw", null);
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if(from != null)
                fromDate = f.parse(from);

            String to = params.getOrDefault("toDate", null);
            if(to != null)
                toDate = f.parse(to);
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        
        
        model.addAttribute("doanhThuStats", this.statsService.doanhThuStats(kw, fromDate, toDate));
        
        return "doanhthu-stats";
    }
    
    @GetMapping("/doanhthu-month-stats")
    public String doanhThuMonthStats(Model model, @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if(from != null)
                fromDate = f.parse(from);

            String to = params.getOrDefault("toDate", null);
            if(to != null)
                toDate = f.parse(to);
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        
        model.addAttribute("doanhThuMonthStats", this.statsService.doanhThuMonthStats(fromDate, toDate));
        return "doanhthu-month-stats";
    }
    
    @GetMapping("/doanhthu-year-stats")
    public String doanhThuYearStats(Model model, @RequestParam(required = false) Map<String, String> params){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
 
        
        Date fromDate = null, toDate = null;
        
        try {
            String from = params.getOrDefault("fromDate", null);
            if(from != null)
                fromDate = f.parse(from);

            String to = params.getOrDefault("toDate", null);
            if(to != null)
                toDate = f.parse(to);
        } catch (ParseException ex){
            ex.printStackTrace();
        }
        
        model.addAttribute("doanhThuYearStats", this.statsService.doanhThuYearStats(fromDate, toDate));
        return "doanhthu-year-stats";
    }
}
