/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.PhieuKhamBenh;
import com.ntp.repository.PhieuKhamBenhRepository;
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
public class PhieuKhamBenhRepositoryImpl implements PhieuKhamBenhRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<PhieuKhamBenh> getPhieuKhamBenh(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<PhieuKhamBenh> query = builder.createQuery(PhieuKhamBenh.class);
        Root root = query.from(PhieuKhamBenh.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("tenPKB").as(String.class), 
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = s.createQuery(query);
        q.setFirstResult((page - 1) * 9);
        q.setMaxResults(9);
        
        return q.getResultList();
    }

    @Override
    public PhieuKhamBenh getPhieuKhamBenhById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(PhieuKhamBenh.class, id);
    }

    @Override
    public int countPhieuKhamBenh() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) from PhieuKhamBenh");
        
        Object o = q.getSingleResult();
        
        return Integer.parseInt(o.toString());
    }

    @Override
    public boolean addOrUpdatePhieuKhamBenh(PhieuKhamBenh phieukhambenh) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(phieukhambenh.getIdPKB() > 0)
                session.update(phieukhambenh);
            else
                session.flush();
            session.save(phieukhambenh);
            
            return true;
        } catch(Exception ex){
            System.err.println("=== ADD PHIEU KHAM BENH ERR ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deletePhieuKhamBenh(int phieukhambenhId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            PhieuKhamBenh p = session.get(PhieuKhamBenh.class, phieukhambenhId);
            session.delete(p);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
