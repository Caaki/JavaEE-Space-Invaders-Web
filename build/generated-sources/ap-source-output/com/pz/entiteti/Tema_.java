package com.pz.entiteti;

import com.pz.entiteti.Komentar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2022-06-08T03:19:01")
@StaticMetamodel(Tema.class)
public class Tema_ { 

    public static volatile SingularAttribute<Tema, Integer> temaId;
    public static volatile CollectionAttribute<Tema, Komentar> komentarCollection;
    public static volatile SingularAttribute<Tema, String> naziv;
    public static volatile SingularAttribute<Tema, Integer> userId;

}