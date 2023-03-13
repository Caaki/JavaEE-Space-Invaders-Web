package com.pz.entiteti;

import com.pz.entiteti.Tema;
import com.pz.entiteti.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-06-08T03:19:01")
@StaticMetamodel(Komentar.class)
public class Komentar_ { 

    public static volatile SingularAttribute<Komentar, Tema> temaId;
    public static volatile SingularAttribute<Komentar, String> komentar;
    public static volatile SingularAttribute<Komentar, Integer> id;
    public static volatile SingularAttribute<Komentar, Users> userId;

}