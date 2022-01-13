/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.formatter;

import com.ntp.pojos.LoaiThuoc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Phat Nguyen
 */
public class LoaiThuocFormatter implements Formatter<LoaiThuoc>{

    @Override
    public String print(LoaiThuoc t, Locale locale) {
        return String.valueOf(t.getIdloaithuoc());
    }

    @Override
    public LoaiThuoc parse(String text, Locale locale) throws ParseException {
        LoaiThuoc c = new LoaiThuoc();
        c.setIdloaithuoc(Integer.parseInt(text));
        
        return c;
    }
    
}
