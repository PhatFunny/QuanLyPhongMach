package com.ntp.pojos;

import com.ntp.pojos.BenhNhan;
import com.ntp.pojos.LichKham;
import com.ntp.pojos.NhanVien;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-12-19T10:59:16", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, LichKham> lichkhamCollection;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, NhanVien> nhanvien;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, BenhNhan> benhnhan;
    public static volatile SingularAttribute<User, String> username;

}