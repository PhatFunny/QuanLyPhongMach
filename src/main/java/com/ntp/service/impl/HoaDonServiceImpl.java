/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.ToaThuoc;
import com.ntp.repository.HoaDonRepository;
import com.ntp.service.HoaDonService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class HoaDonServiceImpl implements HoaDonService{
    @Autowired
    private HoaDonRepository hoaDonRepository;

    @Override
    public boolean addHoaDon(Map<Integer, ToaThuoc> toathuoc) {
        if(toathuoc != null)
            return this.hoaDonRepository.addHoaDon(toathuoc);
        return false;
    }
    
}
