/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.ChiTietToaThuoc;
import com.ntp.pojos.HoaDonKhamBenh;
import com.ntp.pojos.ToaThuoc;
import com.ntp.repository.BenhNhanRepository;
import com.ntp.repository.HoaDonRepository;
import com.ntp.repository.NhanVienRepository;
import com.ntp.repository.PhieuKhamBenhRepository;
import com.ntp.repository.ThuocRepository;
import com.ntp.utils.Utils;
import java.util.Date;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Phat Nguyen
 */
@Repository
public class HoaDonRepositoryImpl implements HoaDonRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    private ThuocRepository thuocRepository;
    
    @Autowired
    private BenhNhanRepository benhNhanRepository;
    
    @Autowired
    private NhanVienRepository nhanVienRepository;
    
    @Autowired
    private PhieuKhamBenhRepository phieuKhamBenhRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addHoaDon(Map<Integer, ToaThuoc> toathuoc) {
        try{
            Session session = this.sessionFactory.getObject().getCurrentSession();
        
            HoaDonKhamBenh hoadon = new HoaDonKhamBenh();

            hoadon.setIdBN(this.benhNhanRepository.getBenhNhanById(3));
            hoadon.setIdNV(this.nhanVienRepository.getNhanVienById(5));
            hoadon.setPhieuKhamBenh(this.phieuKhamBenhRepository.getPhieuKhamBenhById(3));
            hoadon.setNgaylapHDKB(new Date());

            Map<String, String> stats = Utils.toathuocStarts(toathuoc);
            hoadon.setThanhtien(Double.parseDouble(stats.get("amount")));

            session.save(hoadon);

            for(ToaThuoc t: toathuoc.values()){
                ChiTietToaThuoc ct = new ChiTietToaThuoc();
                ct.setIdHDKB(hoadon);
                ct.setThuoc(this.thuocRepository.getThuocById(t.getIdthuoc()));
                ct.setDongia(t.getDongia());
                ct.setSoluong(t.getQuantity());
                ct.setCachdung(t.getCachdung());

                session.save(ct);
            }
            
            return true;
            
        } catch (HibernateException ex){
            ex.printStackTrace();
        }

        return false;
    }
    
}
