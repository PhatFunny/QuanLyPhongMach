/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.utils;

import com.ntp.pojos.ToaThuoc;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Phat Nguyen
 */
public class Utils {
    public static int countToaThuoc(Map<Integer, ToaThuoc> toathuoc){
        int quantity = 0;
        
        if(toathuoc != null)
            for(ToaThuoc t: toathuoc.values())
                quantity += t.getQuantity();
        
        return quantity;
    }
    
    public static Map<String, String> toathuocStarts(Map<Integer, ToaThuoc> toathuoc){
        double s = 0;
        int quantity = 0;
        
        if(toathuoc != null)
            for(ToaThuoc t: toathuoc.values()){
                quantity += t.getQuantity();
                s += t.getQuantity() * t.getDongia();
            }
        
        Map<String, String> kq = new HashMap<>();
        kq.put("counter", String.valueOf(quantity));
        kq.put("amount", String.valueOf(s));
        
        return kq;
    }
}
