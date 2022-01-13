package com.ntp.pojos;

import com.ntp.pojos.HoaDonKhamBenh;
import com.ntp.pojos.Thuoc;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ChiTietToaThuoc.class)
public class ChiTietToaThuoc_ { 

    public static volatile SingularAttribute<ChiTietToaThuoc, Integer> idCTTT;
    public static volatile SingularAttribute<ChiTietToaThuoc, HoaDonKhamBenh> idHDKB;
    public static volatile SingularAttribute<ChiTietToaThuoc, String> cachdung;
    public static volatile SingularAttribute<ChiTietToaThuoc, Thuoc> thuoc;
    public static volatile SingularAttribute<ChiTietToaThuoc, Double> dongia;
    public static volatile SingularAttribute<ChiTietToaThuoc, Integer> soluong;

}