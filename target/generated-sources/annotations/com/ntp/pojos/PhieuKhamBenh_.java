package com.ntp.pojos;

import com.ntp.pojos.HoaDonKhamBenh;
import com.ntp.pojos.NhanVien;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(PhieuKhamBenh.class)
public class PhieuKhamBenh_ { 

    public static volatile CollectionAttribute<PhieuKhamBenh, HoaDonKhamBenh> hoadonkhambenhCollection;
    public static volatile SingularAttribute<PhieuKhamBenh, String> trieuchung;
    public static volatile SingularAttribute<PhieuKhamBenh, String> hinhanh;
    public static volatile SingularAttribute<PhieuKhamBenh, String> ghichu;
    public static volatile SingularAttribute<PhieuKhamBenh, String> chandoan;
    public static volatile SingularAttribute<PhieuKhamBenh, NhanVien> nhanvien;
    public static volatile SingularAttribute<PhieuKhamBenh, Integer> idPKB;
    public static volatile SingularAttribute<PhieuKhamBenh, String> tenbenhnhan;
    public static volatile SingularAttribute<PhieuKhamBenh, String> tenPKB;
    public static volatile SingularAttribute<PhieuKhamBenh, Date> ngaykham;
    public static volatile SingularAttribute<PhieuKhamBenh, Date> lichhen;

}