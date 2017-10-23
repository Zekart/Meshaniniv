/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author zekart
 */
@Entity
@Table(name = "all_result")

public class AllResult implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(max = 45)
    @Column(name = "a_n")
    private String aN;
    @Size(max = 45)
    @Column(name = "b_n")
    private String bN;
    @Size(max = 45)
    @Column(name = "c_n")
    private String cN;
    @Size(max = 45)
    @Column(name = "d_n")
    private String dN;
    @Size(max = 45)
    @Column(name = "a_f")
    private String aF;
    @Size(max = 45)
    @Column(name = "b_f")
    private String bF;
    @Size(max = 45)
    @Column(name = "c_f")
    private String cF;
    @Size(max = 45)
    @Column(name = "d_f")
    private String dF;
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    @Size(max = 45)
    @Column(name = "role")
    private String role;

    public AllResult() {
    }

    public AllResult(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAN() {
        return aN;
    }

    public void setAN(String aN) {
        this.aN = aN;
    }

    public String getBN() {
        return bN;
    }

    public void setBN(String bN) {
        this.bN = bN;
    }

    public String getCN() {
        return cN;
    }

    public void setCN(String cN) {
        this.cN = cN;
    }

    public String getDN() {
        return dN;
    }

    public void setDN(String dN) {
        this.dN = dN;
    }

    public String getAF() {
        return aF;
    }

    public void setAF(String aF) {
        this.aF = aF;
    }

    public String getBF() {
        return bF;
    }

    public void setBF(String bF) {
        this.bF = bF;
    }

    public String getCF() {
        return cF;
    }

    public void setCF(String cF) {
        this.cF = cF;
    }

    public String getDF() {
        return dF;
    }

    public void setDF(String dF) {
        this.dF = dF;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AllResult)) {
            return false;
        }
        AllResult other = (AllResult) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.AllResult[ id=" + id + " ]";
    }
    
}
