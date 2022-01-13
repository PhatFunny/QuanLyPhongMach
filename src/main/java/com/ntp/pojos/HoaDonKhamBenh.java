/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.pojos;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "hoadonkhambenh")
public class HoaDonKhamBenh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHDKB")
    private Integer idHDKB;
    @Basic(optional = false)

    @Size(min = 1, max = 50)
    @Column(name = "tenHDKB")
    private String tenHDKB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaylapHDKB")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaylapHDKB;
    @Basic(optional = false)
    @NotNull
    @Column(name = "thanhtien")
    private double thanhtien;
    @JoinColumn(name = "idBN", referencedColumnName = "idBN")
    @ManyToOne
    private BenhNhan idBN;
    @JoinColumns({
        @JoinColumn(name = "idNV", referencedColumnName = "idNV")})
    @ManyToOne
    private NhanVien idNV;
    @JoinColumns({
        @JoinColumn(name = "phieukhambenh_id", referencedColumnName = "idPKB")})
    @ManyToOne(optional = false)
    private PhieuKhamBenh phieuKhamBenh;
    
    @OneToMany(mappedBy = "idHDKB")
    private Collection<ChiTietToaThuoc> chitiettoathuocCollection;

    public HoaDonKhamBenh() {
        ngaylapHDKB = new Date();
    }

    public HoaDonKhamBenh(Integer idHDKB) {
        this.idHDKB = idHDKB;
    }

    public HoaDonKhamBenh(Integer idHDKB, String tenHDKB, Date ngaylapHDKB, double thanhtien) {
        this.idHDKB = idHDKB;
        this.tenHDKB = tenHDKB;
        this.ngaylapHDKB = ngaylapHDKB;
        this.thanhtien = thanhtien;
    }

    public Integer getIdHDKB() {
        return idHDKB;
    }

    public void setIdHDKB(Integer idHDKB) {
        this.idHDKB = idHDKB;
    }

    public String getTenHDKB() {
        return tenHDKB;
    }

    public void setTenHDKB(String tenHDKB) {
        this.tenHDKB = tenHDKB;
    }

    public Date getNgaylapHDKB() {
        return ngaylapHDKB;
    }

    public void setNgaylapHDKB(Date ngaylapHDKB) {
        this.ngaylapHDKB = ngaylapHDKB;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public BenhNhan getIdBN() {
        return idBN;
    }

    public void setIdBN(BenhNhan idBN) {
        this.idBN = idBN;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    

    public PhieuKhamBenh getPhieuKhamBenh() {
        return phieuKhamBenh;
    }

    public void setPhieuKhamBenh(PhieuKhamBenh phieuKhamBenh) {
        this.phieuKhamBenh = phieuKhamBenh;
    }

    @XmlTransient
    public Collection<ChiTietToaThuoc> getChitiettoathuocCollection() {
        return chitiettoathuocCollection;
    }

    public void setChitiettoathuocCollection(Collection<ChiTietToaThuoc> chitiettoathuocCollection) {
        this.chitiettoathuocCollection = chitiettoathuocCollection;
    }
    
}
