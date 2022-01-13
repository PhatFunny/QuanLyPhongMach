/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.formatter;

import com.ntp.pojos.LichTruc;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Phat Nguyen
 */
public class LichTrucFormatter implements Formatter<LichTruc>{

    @Override
    public String print(LichTruc t, Locale locale) {
        return String.valueOf(t.getIdlichtruc());
    }

    @Override
    public LichTruc parse(String text, Locale locale) throws ParseException {
        LichTruc l = new LichTruc();
        l.setIdlichtruc(Integer.parseInt(text));
        
        return l;
    }
    
}
