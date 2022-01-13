/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.LoaiThuoc;
import com.ntp.repository.LoaiThuocRepository;
import com.ntp.service.LoaiThuocService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class LoaiThuocServiceImpl implements LoaiThuocService{
    
    @Autowired
    private LoaiThuocRepository loaiThuocRepository;

    @Override
    public List<LoaiThuoc> getLoaiThuoc() {
        return this.loaiThuocRepository.getLoaiThuoc();
    }

    @Override
    public LoaiThuoc getLoaiThuocById(int id) {
        return this.loaiThuocRepository.getLoaiThuocById(id);
    }
    
}
