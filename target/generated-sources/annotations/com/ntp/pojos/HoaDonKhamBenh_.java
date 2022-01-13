package com.ntp.pojos;

import com.ntp.pojos.BenhNhan;
import com.ntp.pojos.ChiTietToaThuoc;
import com.ntp.pojos.NhanVien;
import com.ntp.pojos.PhieuKhamBenh;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(HoaDonKhamBenh.class)
public class HoaDonKhamBenh_ { 

    public static volatile SingularAttribute<HoaDonKhamBenh, Integer> idHDKB;
    public static volatile SingularAttribute<HoaDonKhamBenh, NhanVien> idNV;
    public static volatile SingularAttribute<HoaDonKhamBenh, BenhNhan> idBN;
    public static volatile SingularAttribute<HoaDonKhamBenh, PhieuKhamBenh> phieuKhamBenh;
    public static volatile SingularAttribute<HoaDonKhamBenh, Double> thanhtien;
    public static volatile SingularAttribute<HoaDonKhamBenh, String> tenHDKB;
    public static volatile SingularAttribute<HoaDonKhamBenh, Date> ngaylapHDKB;
    public static volatile CollectionAttribute<HoaDonKhamBenh, ChiTietToaThuoc> chitiettoathuocCollection;

}