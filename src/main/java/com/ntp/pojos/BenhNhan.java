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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "benhnhan")
public class BenhNhan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBN")
    private int idBN;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tenBN")
    private String tenBN;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngaysinh")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gioitinh")
    private String gioitinh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "diachi")
    private String diachi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SDT")
    private String sdt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emailBN")
    private String emailBN;
    
    @OneToMany(mappedBy = "benhnhan")
    private Collection<User> userCollection;
    
    @OneToMany(mappedBy = "benhnhan")
    private Collection<LichKham> lichKhamCollection;


    public BenhNhan() {
    }

    public BenhNhan(int idBN) {
        this.idBN = idBN;
    }

    public BenhNhan(int idBN, String tenBN, Date ngaysinh, String gioitinh, String diachi, String sdt, String emailBN) {
        this.idBN = idBN;
        this.tenBN = tenBN;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.emailBN = emailBN;
    }

    public int getIdBN() {
        return idBN;
    }

    public void setIdBN(int idBN) {
        this.idBN = idBN;
    }

    public String getTenBN() {
        return tenBN;
    }

    public void setTenBN(String tenBN) {
        this.tenBN = tenBN;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmailBN() {
        return emailBN;
    }

    public void setEmailBN(String emailBN) {
        this.emailBN = emailBN;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Collection<LichKham> getLichKhamCollection() {
        return lichKhamCollection;
    }

    public void setLichKhamCollection(Collection<LichKham> lichKhamCollection) {
        this.lichKhamCollection = lichKhamCollection;
    }
    

}
