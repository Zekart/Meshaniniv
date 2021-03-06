/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1.beans;

import com.mycompany.mavenproject1.AllResult;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zekart
 */
@Stateless
@Named
public class AllResultFacade extends AbstractFacade<AllResult> {

    @PersistenceContext(unitName = "com.mycompany_mavenproject1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AllResultFacade() {
        super(AllResult.class);
    }

    public List<AllResult> getSelfResult() {
        return em.createNamedQuery("AllResult.findAll").getResultList();
    }
    
    
}