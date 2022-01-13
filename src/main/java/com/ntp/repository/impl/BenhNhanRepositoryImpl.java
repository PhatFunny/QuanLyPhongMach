/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.BenhNhan;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ntp.repository.BenhNhanRepository;

/**
 *
 * @author Phat Nguyen
 */
@Repository
@Transactional
public class BenhNhanRepositoryImpl implements BenhNhanRepository{
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addOrUpdateBenhNhan(BenhNhan benhnhan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try{
            if(benhnhan.getIdBN() > 0)
                session.update(benhnhan);
            else
                session.flush();
                session.save(benhnhan);
            
            return true;
        } catch(Exception ex){
            System.err.println("=== ADD BENH NHAN ERR ===" + ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }


    @Override
    public BenhNhan getBenhNhanById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(BenhNhan.class, id);
    }

}
