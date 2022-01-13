/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service;

import com.ntp.pojos.Thuoc;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface ThuocService {
    List<Thuoc> getThuoc(String kw, int page);
    int countThuoc();
    boolean addOrUpdateThuoc(Thuoc thuoc);
    boolean deleteThuoc(int thuocId);
    Thuoc getThuocById(int id);
}
