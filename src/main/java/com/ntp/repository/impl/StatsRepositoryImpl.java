/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.ChiTietToaThuoc;
import com.ntp.pojos.HoaDonKhamBenh;
import com.ntp.pojos.PhieuKhamBenh;
import com.ntp.pojos.Thuoc;
import com.ntp.repository.StatsRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Phat Nguyen
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> doanhThuStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootT = q.from(Thuoc.class);
        Root rootHD = q.from(HoaDonKhamBenh.class);
        Root rootCT = q.from(ChiTietToaThuoc.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootCT.get("thuoc"), rootT.get("idthuoc")));
        predicates.add(b.equal(rootCT.get("idHDKB"), rootHD.get("idHDKB")));
        
        q.multiselect(rootT.get("idthuoc"), rootT.get("tenthuoc"),
                b.sum(b.prod(rootCT.get("dongia"), rootCT.get("soluong"))));
        
        if(kw != null && !kw.isEmpty())
            predicates.add(b.like(rootT.get("tenthuoc"), String.format("%%%s%%", kw)));
        
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootHD.get("ngaylapHDKB"), fromDate));
        
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootHD.get("ngaylapHDKB"), toDate));
            
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(rootT.get("idthuoc"));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> doanhThuMonthStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootT = q.from(Thuoc.class);
        Root rootHD = q.from(HoaDonKhamBenh.class);
        Root rootCT = q.from(ChiTietToaThuoc.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootCT.get("thuoc"), rootT.get("idthuoc")));
        predicates.add(b.equal(rootCT.get("idHDKB"), rootHD.get("idHDKB")));
        
        //Thống kê theo tháng của năm
        q.multiselect(b.function("MONTH", Integer.class, rootHD.get("ngaylapHDKB")),
                b.function("YEAR", Integer.class, rootHD.get("ngaylapHDKB")),
                b.sum(b.prod(rootCT.get("dongia"), rootCT.get("soluong"))));
        
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootHD.get("ngaylapHDKB"), fromDate));
        
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootHD.get("ngaylapHDKB"), toDate));
            
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(b.function("MONTH", Integer.class, rootHD.get("ngaylapHDKB")),
                b.function("YEAR", Integer.class, rootHD.get("ngaylapHDKB")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> soLuongBenhNhanMonthStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootPK = q.from(PhieuKhamBenh.class);
        

        
        //Thống kê theo tháng của năm
        q.multiselect(b.function("MONTH", Integer.class, rootPK.get("ngaykham")),
                b.function("YEAR", Integer.class, rootPK.get("ngaykham")),
                b.count(rootPK.get("idPKB")));

        q.groupBy(b.function("MONTH", Integer.class, rootPK.get("ngaykham")),
                b.function("YEAR", Integer.class, rootPK.get("ngaykham")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> soLuongBenhNhanYearStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootPK = q.from(PhieuKhamBenh.class);
        

        
        //Thống kê theo tháng của năm
        q.multiselect(
                b.function("YEAR", Integer.class, rootPK.get("ngaykham")),
                b.count(rootPK.get("idPKB")));

        q.groupBy(
                b.function("YEAR", Integer.class, rootPK.get("ngaykham")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }

    @Override
    public List<Object[]> doanhThuYearStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        
        Root rootT = q.from(Thuoc.class);
        Root rootHD = q.from(HoaDonKhamBenh.class);
        Root rootCT = q.from(ChiTietToaThuoc.class);
        
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootCT.get("thuoc"), rootT.get("idthuoc")));
        predicates.add(b.equal(rootCT.get("idHDKB"), rootHD.get("idHDKB")));
        
        //Thống kê theo tháng của năm
        q.multiselect(
                b.function("YEAR", Integer.class, rootHD.get("ngaylapHDKB")),
                b.sum(b.prod(rootCT.get("dongia"), rootCT.get("soluong"))));
        
        if(fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootHD.get("ngaylapHDKB"), fromDate));
        
        if(toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootHD.get("ngaylapHDKB"), toDate));
            
        q.where(predicates.toArray(new Predicate[] {}));
        q.groupBy(
                b.function("YEAR", Integer.class, rootHD.get("ngaylapHDKB")));
        
        Query query = session.createQuery(q);
        
        return query.getResultList();
    }
    
}
