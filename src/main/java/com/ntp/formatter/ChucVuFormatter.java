/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.formatter;

import com.ntp.pojos.ChucVu;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Phat Nguyen
 */
public class ChucVuFormatter implements org.springframework.format.Formatter<ChucVu>{

    @Override
    public String print(ChucVu t, Locale locale) {
        return String.valueOf(t.getIdchucvu());
    }

    @Override
    public ChucVu parse(String text, Locale locale) throws ParseException {
        ChucVu c = new ChucVu();
        c.setIdchucvu(Integer.parseInt(text));
        
        return c;
    }
    
}
