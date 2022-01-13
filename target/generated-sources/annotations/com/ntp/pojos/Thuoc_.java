package com.ntp.pojos;

import com.ntp.pojos.ChiTietToaThuoc;
import com.ntp.pojos.LoaiThuoc;
import com.ntp.pojos.NhanVien;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Thuoc.class)
public class Thuoc_ { 

    public static volatile SingularAttribute<Thuoc, String> cachdung;
    public static volatile SingularAttribute<Thuoc, LoaiThuoc> loaithuoc;
    public static volatile SingularAttribute<Thuoc, NhanVien> nhanVien;
    public static volatile SingularAttribute<Thuoc, Integer> soluongcon;
    public static volatile SingularAttribute<Thuoc, Date> hansudung;
    public static volatile SingularAttribute<Thuoc, Double> dongia;
    public static volatile SingularAttribute<Thuoc, Date> ngaysx;
    public static volatile SingularAttribute<Thuoc, String> congdung;
    public static volatile SingularAttribute<Thuoc, String> hinhthuoc;
    public static volatile SingularAttribute<Thuoc, Integer> idthuoc;
    public static volatile CollectionAttribute<Thuoc, ChiTietToaThuoc> chitiettoathuocCollection;
    public static volatile SingularAttribute<Thuoc, String> tenthuoc;

}