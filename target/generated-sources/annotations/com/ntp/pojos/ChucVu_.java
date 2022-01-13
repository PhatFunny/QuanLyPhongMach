package com.ntp.pojos;

import com.ntp.pojos.NhanVien;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ChucVu.class)
public class ChucVu_ { 

    public static volatile SingularAttribute<ChucVu, Integer> idchucvu;
    public static volatile CollectionAttribute<ChucVu, NhanVien> nhanvienCollection;
    public static volatile SingularAttribute<ChucVu, String> tenchucvu;

}