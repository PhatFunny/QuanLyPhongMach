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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "chucvu")
public class ChucVu implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idchucvu")
    private int idchucvu;
    @Size(max = 45)
    @Column(name = "tenchucvu")
    private String tenchucvu;
    
    @OneToMany(mappedBy = "chucvu")
    private Collection<NhanVien> nhanvienCollection;


    public ChucVu() {
    }

    public ChucVu(int idchucvu) {
        this.idchucvu = idchucvu;
    }

    public int getIdchucvu() {
        return idchucvu;
    }

    public void setIdchucvu(int idchucvu) {
        this.idchucvu = idchucvu;
    }

    public String getTenchucvu() {
        return tenchucvu;
    }

    public void setTenchucvu(String tenchucvu) {
        this.tenchucvu = tenchucvu;
    }

    @XmlTransient
    public Collection<NhanVien> getNhanvienCollection() {
        return nhanvienCollection;
    }

    public void setNhanvienCollection(Collection<NhanVien> nhanvienCollection) {
        this.nhanvienCollection = nhanvienCollection;
    }

}
