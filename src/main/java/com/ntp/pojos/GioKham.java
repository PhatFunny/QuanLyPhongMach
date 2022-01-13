/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.pojos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "giokham")

public class GioKham implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgiokham")
    private int idgiokham;
    @Size(max = 60)
    @Column(name = "giokham")
    private String giokham;
    
    @OneToMany(mappedBy = "giokham")
    private Collection<LichKham> lichKhamCollection;

    public GioKham() {
    }

    public GioKham(int idgiokham) {
        this.idgiokham = idgiokham;
    }

    public int getIdgiokham() {
        return idgiokham;
    }

    public void setIdgiokham(int idgiokham) {
        this.idgiokham = idgiokham;
    }

    public String getGiokham() {
        return giokham;
    }

    public void setGiokham(String giokham) {
        this.giokham = giokham;
    }

    public Collection<LichKham> getLichKhamCollection() {
        return lichKhamCollection;
    }

    public void setLichKhamCollection(Collection<LichKham> lichKhamCollection) {
        this.lichKhamCollection = lichKhamCollection;
    }
    
    
}
