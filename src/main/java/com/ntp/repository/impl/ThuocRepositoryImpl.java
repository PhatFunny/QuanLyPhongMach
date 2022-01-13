/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.Thuoc;
import com.ntp.repository.ThuocRepository;
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
public class ThuocRepositoryImpl implements ThuocRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Thuoc> getThuoc(String kw, int page) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Thuoc> query = builder.createQuery(Thuoc.class);
        Root root = query.from(Thuoc.class);
        query = query.select(root);
        
        if(!kw.isEmpty() && kw != null){
            Predicate p = builder.like(root.get("tenthuoc").as(String.class), 
                    String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query q = s.createQuery(query);
        q.setFirstResult((page - 1) * 9);
        q.setMaxResults(9);
        
        return q.getResultList();
    }
    
    @Override
    public int countThuoc() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Query q = session.createQuery("Select Count(*) from Thuoc");
        
        Object o = q.getSingleResult();
        
        return Integer.parseInt(o.toString());
    }

    @Override
    public Thuoc getThuocById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Thuoc.class, id);
    }

    @Override
    public boolean addOrUpdateThuoc(Thuoc thuoc) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(thuoc.getIdthuoc() > 0)
                session.update(thuoc);
            else
                session.flush();
            session.save(thuoc);
            
            return true;
        } catch(Exception ex){
            System.err.println("=== ADD THUOC ERR ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteThuoc(int thuoctId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            Thuoc p = session.get(Thuoc.class, thuoctId);
            session.delete(p);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
    
}
