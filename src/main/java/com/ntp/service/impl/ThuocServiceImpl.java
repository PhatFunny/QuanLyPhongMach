/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntp.pojos.Thuoc;
import com.ntp.repository.ThuocRepository;
import com.ntp.service.ThuocService;
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
public class ThuocServiceImpl implements ThuocService{
    @Autowired
    private ThuocRepository thuocRepository;
    @Autowired
    private Cloudinary cloudinary;


    @Override
    public List<Thuoc> getThuoc(String kw, int page) {
        return this.thuocRepository.getThuoc(kw, page);
    }
    
    @Override
    public int countThuoc() {
        return this.thuocRepository.countThuoc();
    }

    @Override
    public Thuoc getThuocById(int id) {
        return this.thuocRepository.getThuocById(id);
    }

    @Override
    public boolean addOrUpdateThuoc(Thuoc thuoc) {
        Map r;
        try {
            r = this.cloudinary.uploader().upload(thuoc.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            thuoc.setHinhthuoc(r.get("secure_url").toString());
            
                     
        } catch (IOException ex) {
            System.err.println("ADD THUOC ERROR" + ex.getMessage());
        }      
        return this.thuocRepository.addOrUpdateThuoc(thuoc); 
    }

    @Override
    public boolean deleteThuoc(int thuocId) {
        return this.thuocRepository.deleteThuoc(thuocId);
    }
}
