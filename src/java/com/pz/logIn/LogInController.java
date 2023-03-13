/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.logIn;

import com.pz.entiteti.Users;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 38160
 */
@Named
@RequestScoped
public class LogInController {

    @PersistenceContext(unitName = "CS230-PZV6PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

   
    
    @Inject
    private Users user;
    
  

  
    
    public String logIn(){
        List<Users> lista = em.createQuery("SELECT u FROM Users u WHERE u.username = :username and u.password = :password")
                .setParameter("username", user.getUsername()).setParameter("password", MD5(user.getPassword())).getResultList();
        
        if(!lista.isEmpty()){
           
            return "pocetna";
        }else{
            user.setUsername("");
            user.setPassword("");
        }
        return "#";
    }
    
    public String MD5(String md5) {
   try {
        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        byte[] array = md.digest(md5.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
       }
        return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
}
    public String logOut(){
        
        user.setUsername("");
        user.setPassword("");
        return "template";
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
    
    
    
}
