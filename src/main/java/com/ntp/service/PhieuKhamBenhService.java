/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service;

import com.ntp.pojos.PhieuKhamBenh;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface PhieuKhamBenhService {
    List<PhieuKhamBenh> getPhieuKhamBenh(String kw, int page);
    PhieuKhamBenh getPhieuKhamBenhById(int id);
    int countPhieuKhamBenh();
    boolean addOrUpdatePhieuKhamBenh(PhieuKhamBenh phieukhambenh);
    boolean deletePhieuKhamBenh(int phieukhambenhId);
}
