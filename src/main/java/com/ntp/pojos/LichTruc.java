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
@Table(name = "lichtruc")
public class LichTruc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlichtruc")
    private int idlichtruc;
    @Size(max = 45)
    @Column(name = "ngaytruc")
    private String ngaytruc;
    
    @OneToMany(mappedBy = "lichtruc")
    private Collection<NhanVien> nhanvienCollection;

    public LichTruc() {
    }

    public LichTruc(int idlichtruc) {
        this.idlichtruc = idlichtruc;
    }

    public int getIdlichtruc() {
        return idlichtruc;
    }

    public void setIdlichtruc(int idlichtruc) {
        this.idlichtruc = idlichtruc;
    }

    public String getNgaytruc() {
        return ngaytruc;
    }

    public void setNgaytruc(String ngaytruc) {
        this.ngaytruc = ngaytruc;
    }

    public Collection<NhanVien> getNhanvienCollection() {
        return nhanvienCollection;
    }

    public void setNhanvienCollection(Collection<NhanVien> nhanvienCollection) {
        this.nhanvienCollection = nhanvienCollection;
    }

}
