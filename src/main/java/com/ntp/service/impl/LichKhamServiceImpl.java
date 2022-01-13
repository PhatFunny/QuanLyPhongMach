/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.LichKham;
import com.ntp.repository.LichKhamRepository;
import com.ntp.service.LichKhamService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class LichKhamServiceImpl implements LichKhamService{
    @Autowired
    private LichKhamRepository lichKhamRepository;

    @Override
    public LichKham getLichKhamById(int id) {
        return this.lichKhamRepository.getLichKhamById(id);
    }

    @Override
    public List<LichKham> getLichKham() {
        return this.lichKhamRepository.getLichKham();
    }

    @Override
    public boolean addLichKham(LichKham lichkham) {
        return this.lichKhamRepository.addLichKham(lichkham);
    }

    @Override
    public boolean deleteLichKham(int lichkhamId) {
        return this.lichKhamRepository.deleteLichKham(lichkhamId);
    }
    
}
