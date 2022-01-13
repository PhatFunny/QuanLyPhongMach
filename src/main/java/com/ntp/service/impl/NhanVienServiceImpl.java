/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.cloudinary.Cloudinary;
import com.ntp.pojos.NhanVien;
import com.ntp.repository.NhanVienRepository;
import com.ntp.service.NhanVienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class NhanVienServiceImpl implements NhanVienService{
    
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<NhanVien> getNhanVien(String kw, int page) {
        return this.nhanVienRepository.getNhanVien(kw, page);
    }

    @Override
    public int countNhanVien() {
        return this.nhanVienRepository.countNhanVien();
    }

    @Override
    public boolean addOrUpdateNhanVien(NhanVien nhanvien) {
    
        return this.nhanVienRepository.addOrUpdateNhanVien(nhanvien); 
    }

    @Override
    public boolean deleteNhanVien(int nhanvienId) {
        return this.nhanVienRepository.deleteNhanVien(nhanvienId);
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        return this.nhanVienRepository.getNhanVienById(id);
    }

    @Override
    public List<Object[]> getExperNhanVien(int num) {
        return this.nhanVienRepository.getExperNhanVien(num);
    }

    @Override
    public List<NhanVien> getNhanVienList() {
        return this.nhanVienRepository.getNhanVienList();
    }
    
}
