package com.ntp.pojos;

import com.ntp.pojos.ChucVu;
import com.ntp.pojos.LichTruc;
import com.ntp.pojos.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(NhanVien.class)
public class NhanVien_ { 

    public static volatile SingularAttribute<NhanVien, String> diachi;
    public static volatile SingularAttribute<NhanVien, String> sdt;
    public static volatile SingularAttribute<NhanVien, Integer> idNV;
    public static volatile SingularAttribute<NhanVien, ChucVu> chucvu;
    public static volatile SingularAttribute<NhanVien, LichTruc> lichtruc;
    public static volatile SingularAttribute<NhanVien, String> hinhanh;
    public static volatile SingularAttribute<NhanVien, String> gioitinh;
    public static volatile CollectionAttribute<NhanVien, User> userCollection;
    public static volatile SingularAttribute<NhanVien, String> tenNV;
    public static volatile SingularAttribute<NhanVien, Date> ngaysinh;
    public static volatile SingularAttribute<NhanVien, String> emailNV;

}