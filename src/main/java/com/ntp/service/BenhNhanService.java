/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service;

import com.ntp.pojos.BenhNhan;

/**
 *
 * @author Phat Nguyen
 */
public interface BenhNhanService {
    boolean addOrUpdateBenhNhan(BenhNhan benhnhan);
    BenhNhan getBenhNhanById(int id);
}
