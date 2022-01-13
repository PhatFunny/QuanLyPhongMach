/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository;

import com.ntp.pojos.NhanVien;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface NhanVienRepository {
    List<NhanVien> getNhanVien(String kw, int page);
    List<NhanVien> getNhanVienList();
    NhanVien getNhanVienById(int id);
    boolean addOrUpdateNhanVien(NhanVien nhanvien);
    boolean deleteNhanVien(int nhanvienId);
    int countNhanVien();
    List<Object[]> getExperNhanVien(int num);
}
