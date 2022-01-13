/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.LichKham;
import com.ntp.repository.BenhNhanRepository;
import com.ntp.repository.LichKhamRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class LichKhamRepositoryImpl implements LichKhamRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private BenhNhanRepository benhNhanRepository;

    @Override
    public LichKham getLichKhamById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(LichKham.class, id);
    }

    @Override
    public List<LichKham> getLichKham() {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<LichKham> query = builder.createQuery(LichKham.class);
        Root root = query.from(LichKham.class);
        query = query.select(root);
        
        Query q = s.createQuery(query);
        
        return q.getResultList();
    }

    @Override
    public boolean addLichKham(LichKham lichkham) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{

            session.save(lichkham);
            
            return true;
        } catch(Exception ex){
            System.err.println("=== DANG KY LICH KHAM ERR ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean deleteLichKham(int lichkhamId) {
        try {
            Session session = this.sessionFactory.getObject().getCurrentSession();
            LichKham k = session.get(LichKham.class, lichkhamId);
            session.delete(k);
            
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

}
