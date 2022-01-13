/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "loaithuoc")

public class LoaiThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idloaithuoc")
    private Integer idloaithuoc;
    @Size(max = 50)
    @Column(name = "tenloaithuoc")
    private String tenloaithuoc;
    
    @OneToMany(mappedBy = "loaithuoc", fetch = FetchType.EAGER)
    private List<Thuoc> thuocCollection;

    public LoaiThuoc() {
    }

    public LoaiThuoc(Integer idloaithuoc) {
        this.idloaithuoc = idloaithuoc;
    }

    public Integer getIdloaithuoc() {
        return idloaithuoc;
    }

    public void setIdloaithuoc(Integer idloaithuoc) {
        this.idloaithuoc = idloaithuoc;
    }

    public String getTenloaithuoc() {
        return tenloaithuoc;
    }

    public void setTenloaithuoc(String tenloaithuoc) {
        this.tenloaithuoc = tenloaithuoc;
    }

    @XmlTransient
    public List<Thuoc> getThuocCollection() {
        return thuocCollection;
    }

    public void setThuocCollection(List<Thuoc> thuocCollection) {
        this.thuocCollection = thuocCollection;
    }

}
