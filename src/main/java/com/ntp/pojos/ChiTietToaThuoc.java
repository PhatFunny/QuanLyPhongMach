/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "chitiettoathuoc")
public class ChiTietToaThuoc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCTTT")
    private int idCTTT;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dongia")
    private Double dongia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluong")
    private int soluong;
    @Basic(optional = false)
    @Column(name = "cachdung")
    private String cachdung;
    @JoinColumn(name = "idHDKB", referencedColumnName = "idHDKB")
    @ManyToOne
    private HoaDonKhamBenh idHDKB;
    
    @JoinColumns({
        @JoinColumn(name = "idthuoc", referencedColumnName = "idthuoc")})
    @ManyToOne(optional = false)
    private Thuoc thuoc;


    public ChiTietToaThuoc() {
    }

    public ChiTietToaThuoc(int idCTTT) {
        this.idCTTT = idCTTT;
    }

    public ChiTietToaThuoc(int idCTTT, int soluong, String cachdung) {
        this.idCTTT = idCTTT;
        this.soluong = soluong;
        this.cachdung = cachdung;
    }

    public Integer getIdCTTT() {
        return idCTTT;
    }

    public void setIdCTTT(Integer idCTTT) {
        this.idCTTT = idCTTT;
    }

    public Double getDongia() {
        return dongia;
    }

    public void setDongia(Double dongia) {
        this.dongia = dongia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getCachdung() {
        return cachdung;
    }

    public void setCachdung(String cachdung) {
        this.cachdung = cachdung;
    }

    public HoaDonKhamBenh getIdHDKB() {
        return idHDKB;
    }

    public void setIdHDKB(HoaDonKhamBenh idHDKB) {
        this.idHDKB = idHDKB;
    }

    public Thuoc getThuoc() {
        return thuoc;
    }

    public void setThuoc(Thuoc thuoc) {
        this.thuoc = thuoc;
    }

}
