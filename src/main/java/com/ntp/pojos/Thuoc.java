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
import javax.persistence.CascadeType;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "thuoc")

public class Thuoc implements Serializable {

    @Column(name = "ngaysx")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngaysx;
    
    @Column(name = "hansudung")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hansudung;
    @JoinColumns({
        @JoinColumn(name = "nhanvien_id", referencedColumnName = "idNV")})
    @ManyToOne
    private NhanVien nhanVien;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "thuoc")
    private Collection<ChiTietToaThuoc> chitiettoathuocCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idthuoc")
    private int idthuoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tenthuoc")
    private String tenthuoc;
    @Size(max = 255)
    @Column(name = "congdung")
    private String congdung;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soluongcon")
    private int soluongcon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dongia")
    private double dongia;
    @Size(max = 240)
    @Column(name = "hinhthuoc")
    private String hinhthuoc;
    
    private String cachdung;
    @JoinColumns({
        @JoinColumn(name = "idloaithuoc", referencedColumnName = "idloaithuoc")})
    @ManyToOne
    private LoaiThuoc loaithuoc;

    
    @Transient
    private MultipartFile file;

    public Thuoc() {
    }

    public Thuoc(int idthuoc) {
        this.idthuoc = idthuoc;
    }

    public Thuoc(int idthuoc, String tenthuoc, int soluongcon, Long dongia) {
        this.idthuoc = idthuoc;
        this.tenthuoc = tenthuoc;
        this.soluongcon = soluongcon;
        this.dongia = dongia;
    }

    public int getIdthuoc() {
        return idthuoc;
    }

    public void setIdthuoc(int idthuoc) {
        this.idthuoc = idthuoc;
    }

    public String getTenthuoc() {
        return tenthuoc;
    }

    public void setTenthuoc(String tenthuoc) {
        this.tenthuoc = tenthuoc;
    }

    public String getCongdung() {
        return congdung;
    }

    public void setCongdung(String congdung) {
        this.congdung = congdung;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
    

    public int getSoluongcon() {
        return soluongcon;
    }

    public void setSoluongcon(int soluongcon) {
        this.soluongcon = soluongcon;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }


    public String getHinhthuoc() {
        return hinhthuoc;
    }

    public void setHinhthuoc(String hinhthuoc) {
        this.hinhthuoc = hinhthuoc;
    }

    public LoaiThuoc getLoaithuoc() {
        return loaithuoc;
    }

    public void setLoaithuoc(LoaiThuoc loaithuoc) {
        this.loaithuoc = loaithuoc;
    }

    public Date getNgaysx() {
        return ngaysx;
    }

    public void setNgaysx(Date ngaysx) {
        this.ngaysx = ngaysx;
    }

    public Date getHansudung() {
        return hansudung;
    }

    public void setHansudung(Date hansudung) {
        this.hansudung = hansudung;
    }
    
    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getCachdung() {
        return cachdung;
    }

    public void setCachdung(String cachdung) {
        this.cachdung = cachdung;
    }
    
    

    @XmlTransient
    public Collection<ChiTietToaThuoc> getChitiettoathuocCollection() {
        return chitiettoathuocCollection;
    }

    public void setChitiettoathuocCollection(Collection<ChiTietToaThuoc> chitiettoathuocCollection) {
        this.chitiettoathuocCollection = chitiettoathuocCollection;
    }

}
