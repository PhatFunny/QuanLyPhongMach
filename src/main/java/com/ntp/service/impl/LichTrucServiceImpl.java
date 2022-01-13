/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.pojos.LichTruc;
import com.ntp.repository.LichTrucRepository;
import com.ntp.service.LichTrucService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class LichTrucServiceImpl implements LichTrucService{
    
    @Autowired
    private LichTrucRepository lichTrucRepository;

    @Override
    public List<LichTruc> getLichTruc() {
        return this.lichTrucRepository.getLichTruc();
    }
    
}
