/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.GioKham;
import com.ntp.repository.GioKhamRepository;
import com.ntp.service.GioKhamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class GioKhamServiceImpl implements GioKhamService{
    @Autowired
    private GioKhamRepository gioKhamRepository;

    @Override
    public List<GioKham> getGioKham() {
        return this.gioKhamRepository.getGioKham();
    }
    
}
