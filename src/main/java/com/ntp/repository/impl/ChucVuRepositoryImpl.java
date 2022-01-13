/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.repository.impl;

import com.ntp.pojos.ChucVu;
import com.ntp.repository.ChucVuRepository;
import java.util.List;
import javax.persistence.Query;
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
public class ChucVuRepositoryImpl implements ChucVuRepository{
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public List<ChucVu> getChucVu() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM ChucVu");
        
        return q.getResultList();
    }
    
}
