/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pz.register;

import com.pz.entiteti.Users;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
public class RegisterController {

    @PersistenceContext(unitName = "CS230-PZV6PU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

  
    
    @Inject
    private Users user;

  
    
    public String register() throws SQLException{
        
        List<Users> lista = em.createQuery("SELECT u FROM Users u WHERE u.username = :username and u.password = :password")
                .setParameter("username", user.getUsername()).setParameter("password", MD5(user.getPassword())).getResultList();
      
       
        
        if(lista.isEmpty()){
           
           Connection povezi=  DriverManager.getConnection("jdbc:mysql://localhost/projekat", "root", "");
        PreparedStatement ps = povezi.prepareStatement("INSERT INTO users (username,password,lastscore,highscore,admin)"
                + " VALUES (?,?,?,?,?)");
        
        ps.setString(1,user.getUsername());
        ps.setString(2, MD5(user.getPassword()));
        ps.setInt(3, 0);
        ps.setInt(4, 0);
        ps.setBoolean(5, false);
        
        ps.executeUpdate();
        ps.close();
              

//        Users novi = new Users();
//        novi.setAdmin(false);
//        novi.setHighscore(0);
//        novi.setLastscore(0);
//        novi.setUsername(user.getUsername());
//        novi.setPassword(user.getPassword());
//        
//        em.persist((Users) novi);
        

            return"login";
        }else{
            

              
            return"login"; 
        }
        
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
