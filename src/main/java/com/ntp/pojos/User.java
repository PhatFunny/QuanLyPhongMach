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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Phat Nguyen
 */
@Entity
@Table(name = "user" )
public class User implements Serializable{

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String USER = "ROLE_USER";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @Size(max = 150)
    @Column(name = "avatar")
    private String avatar;

    @Column(name = "user_role")
    private String userRole;

    @Transient
    @NotNull
    private MultipartFile file;
    
    @Transient
    private String confirmPassword;
    
    @JoinColumn(name = "idNV", referencedColumnName = "idNV")
    @ManyToOne
    private NhanVien nhanvien;
    
    @JoinColumn(name = "idBN", referencedColumnName = "idBN")
    @ManyToOne
    private BenhNhan benhnhan;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<LichKham> lichkhamCollection;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public NhanVien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public BenhNhan getBenhnhan() {
        return benhnhan;
    }

    public void setBenhnhan(BenhNhan benhnhan) {
        this.benhnhan = benhnhan;
    }

    public List<LichKham> getLichkhamCollection() {
        return lichkhamCollection;
    }

    public void setLichkhamCollection(List<LichKham> lichkhamCollection) {
        this.lichkhamCollection = lichkhamCollection;
    }

    
}
