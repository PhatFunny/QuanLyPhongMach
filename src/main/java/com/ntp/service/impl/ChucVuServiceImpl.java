/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.ChucVu;
import com.ntp.repository.ChucVuRepository;
import com.ntp.service.ChucVuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class ChucVuServiceImpl implements ChucVuService{
    
    @Autowired
    private ChucVuRepository chucVuRepository;

    @Override
    public List<ChucVu> getChucVu() {
        return this.chucVuRepository.getChucVu();
    }
    
}
