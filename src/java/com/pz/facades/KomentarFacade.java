/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.facades;

import com.pz.entiteti.Komentar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 38160
 */
@Stateless
public class KomentarFacade extends AbstractFacade<Komentar> {

    @PersistenceContext(unitName = "CS230-PZV6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public KomentarFacade() {
        super(Komentar.class);
    }
    
}
