/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntp.pojos.PhieuKhamBenh;
import com.ntp.repository.PhieuKhamBenhRepository;
import com.ntp.service.PhieuKhamBenhService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class PhieuKhamBenhServiceImpl implements PhieuKhamBenhService{
    @Autowired
    private PhieuKhamBenhRepository phieuKhamBenhRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<PhieuKhamBenh> getPhieuKhamBenh(String kw, int page) {
        return this.phieuKhamBenhRepository.getPhieuKhamBenh(kw, page);
    }

    @Override
    public PhieuKhamBenh getPhieuKhamBenhById(int id) {
        return this.phieuKhamBenhRepository.getPhieuKhamBenhById(id);
    }

    @Override
    public int countPhieuKhamBenh() {
        return this.phieuKhamBenhRepository.countPhieuKhamBenh();
    }

    @Override
    public boolean addOrUpdatePhieuKhamBenh(PhieuKhamBenh phieukhambenh) {
        Map r;
        try {
            r = this.cloudinary.uploader().upload(phieukhambenh.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            phieukhambenh.setHinhanh(r.get("secure_url").toString());
            
                     
        } catch (IOException ex) {
            System.err.println("ADD PHIEU KHAM BENH ERROR" + ex.getMessage());
        }      
        return this.phieuKhamBenhRepository.addOrUpdatePhieuKhamBenh(phieukhambenh); 
    }

    @Override
    public boolean deletePhieuKhamBenh(int phieukhambenhId) {
        return this.phieuKhamBenhRepository.deletePhieuKhamBenh(phieukhambenhId);
    }
    
}
