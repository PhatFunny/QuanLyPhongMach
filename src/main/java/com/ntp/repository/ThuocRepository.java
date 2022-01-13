/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository;

import com.ntp.pojos.Thuoc;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface ThuocRepository {
    List<Thuoc> getThuoc(String kw, int page);
    Thuoc getThuocById(int id);
    boolean addOrUpdateThuoc(Thuoc thuoc);
    boolean deleteThuoc(int thuoctId);
    int countThuoc();
}
