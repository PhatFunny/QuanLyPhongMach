/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.LichKham;
import com.ntp.pojos.NhanVien;
import com.ntp.repository.NhanVienRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
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
public class NhanVienRepositoryImpl implements NhanVienRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<NhanVien> getNhanVien(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<NhanVien> query = builder.createQuery(NhanVien.class);
        Root root = query.from(NhanVien.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("tenNV").as(String.class), 
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = s.createQuery(query);
        q.setFirstResult((page - 1) * 8);
        q.setMaxResults(8);
        
        return q.getResultList();
    }

    @Override
    public NhanVien getNhanVienById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(NhanVien.class, id);
    }

    @Override
    @Transactional
    public boolean addOrUpdateNhanVien(NhanVien nhanvien) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(nhanvien.getIdNV()> 0)
                session.update(nhanvien);
            else
                session.save(nhanvien);
            return true;
        } catch(Exception ex){
            System.err.println("=== ADD NHANVIEN ERR ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteNhanVien(int nhanvienId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            NhanVien p = session.get(NhanVien.class, nhanvienId);
            session.delete(p);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public int countNhanVien() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) from NhanVien");
        
        Object o = q.getSingleResult();
        
        return Integer.parseInt(o.toString());
    }

    @Override
    public List<Object[]> getExperNhanVien(int num) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root rootN = query.from(NhanVien.class);
        Root rootL = query.from(LichKham.class);
        
        query = query.where(builder.equal(rootL.get("nhanvien"), rootN.get("idNV")));
        query.multiselect(rootN.get("idNV"), rootN.get("tenNV"), 
                rootN.get("hinhanh"), builder.count(rootN.get("idNV")));
        
        query = query.groupBy(rootN.get("idNV"));
        query = query.orderBy(builder.desc(builder.count(rootN.get("idNV"))));
        
        Query q = session.createQuery(query);
        
        q.setMaxResults(num);
        return q.getResultList();
    }

    @Override
    public List<NhanVien> getNhanVienList() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM NhanVien");
        
        return q.getResultList();
    }
    
}
