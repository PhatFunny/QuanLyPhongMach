/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service;

import com.ntp.pojos.NhanVien;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface NhanVienService {
    List<NhanVien> getNhanVien(String kw, int page);
    List<NhanVien> getNhanVienList();
    int countNhanVien();
    boolean addOrUpdateNhanVien(NhanVien nhanvien);
    boolean deleteNhanVien(int nhanvienId);
    NhanVien getNhanVienById(int id);
    List<Object[]> getExperNhanVien(int num);
}
