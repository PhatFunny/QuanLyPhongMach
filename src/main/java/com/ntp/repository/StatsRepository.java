/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Phat Nguyen
 */
public interface StatsRepository {
    List<Object[]> doanhThuStats(String kw, Date fromDate, Date toDate);
    List<Object[]> doanhThuMonthStats(Date fromDate, Date toDate);
    List<Object[]> soLuongBenhNhanMonthStats();
    List<Object[]> soLuongBenhNhanYearStats();
    List<Object[]> doanhThuYearStats(Date fromDate, Date toDate);
}
