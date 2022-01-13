/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.formatter;

import com.ntp.pojos.NhanVien;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author Phat Nguyen
 */
public class NhanVienFormatter implements org.springframework.format.Formatter<NhanVien>{

    @Override
    public String print(NhanVien t, Locale locale) {
        return String.valueOf(t.getIdNV());
    }

    @Override
    public NhanVien parse(String text, Locale locale) throws ParseException {
        NhanVien c = new NhanVien();

        c.setIdNV(Integer.parseInt(text));
        
        return c;
    }
    
}
