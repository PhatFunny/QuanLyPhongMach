/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.BenhNhan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ntp.repository.BenhNhanRepository;
import com.ntp.service.BenhNhanService;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class BenhNhanServiceImpl implements BenhNhanService{
    @Autowired
    private BenhNhanRepository benhNhanRepository;


    @Override
    public boolean addOrUpdateBenhNhan(BenhNhan benhnhan) {
        return this.benhNhanRepository.addOrUpdateBenhNhan(benhnhan);
    }


    @Override
    public BenhNhan getBenhNhanById(int id) {
        return this.benhNhanRepository.getBenhNhanById(id);
    }

}
