/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.formatter;

import com.ntp.pojos.GioKham;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Phat Nguyen
 */
public class GioKhamFormatter implements Formatter<GioKham>{

    @Override
    public String print(GioKham t, Locale locale) {
        return String.valueOf(t.getIdgiokham());
    }

    @Override
    public GioKham parse(String text, Locale locale) throws ParseException {
        GioKham g = new GioKham();
        g.setIdgiokham(Integer.parseInt(text));
        
        return g;
    }
    
}
