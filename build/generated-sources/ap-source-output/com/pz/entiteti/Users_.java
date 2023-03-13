package com.pz.entiteti;

import com.pz.entiteti.Komentar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-06-08T03:19:01")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Integer> highscore;
    public static volatile CollectionAttribute<Users, Komentar> komentarCollection;
    public static volatile SingularAttribute<Users, Boolean> admin;
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, Integer> lastscore;
    public static volatile SingularAttribute<Users, String> username;

}