/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.service.impl;

import com.ntp.repository.StatsRepository;
import com.ntp.service.StatsService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Phat Nguyen
 */
@Service
public class StatsServiceImpl implements StatsService{
    
    @Autowired
    private StatsRepository statsRepository;


    @Override
    public List<Object[]> doanhThuStats(String kw, Date fromDate, Date toDate) {
        return this.statsRepository.doanhThuStats(kw, fromDate, toDate);
    }

    @Override
    public List<Object[]> doanhThuMonthStats(Date fromDate, Date toDate) {
        return this.statsRepository.doanhThuMonthStats(fromDate, toDate);
    }

    @Override
    public List<Object[]> soLuongBenhNhanMonthStats() {
        return this.statsRepository.soLuongBenhNhanMonthStats();
    }

    @Override
    public List<Object[]> soLuongBenhNhanYearStats() {
        return this.statsRepository.soLuongBenhNhanYearStats();
    }

    @Override
    public List<Object[]> doanhThuYearStats(Date fromDate, Date toDate) {
        return this.statsRepository.doanhThuYearStats(fromDate, toDate);
    }
    
}
