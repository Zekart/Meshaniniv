/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.mycompany.mavenproject1.AllResult;
import com.mycompany.mavenproject1.SelfResult;
import com.mycompany.mavenproject1.User;
import com.mycompany.mavenproject1.beans.AllResultFacade;
import com.mycompany.mavenproject1.beans.SelfResultFacade;
import com.mycompany.mavenproject1.beans.UserFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author zekart
 */
@ManagedBean
@SessionScoped
public class Chart_controller implements Serializable{
    @EJB
    private SelfResultFacade resultFacade;
    @EJB
    private AllResultFacade allResultFacade;
    @EJB
    private UserFacade userFacade;
    
    private SelfResult selfResult = new SelfResult();
    private AllResult allResult = new AllResult();
    
    private User user;
    
    private List<SelfResult> result_list = new ArrayList<>();
    private List<AllResult> all_result_list = new ArrayList<>();
    private List<User> user_list = new ArrayList<>();
    
    FacesContext context = FacesContext.getCurrentInstance();
    double[] coeficient = {0.2,0.4,0.6,0.8,1};
    int[] people = new int[5];
           

    private int someValue;
    
    private int A1_n = 50;
    private int A2_n = 50;
    private int A3_n = 50;
    private int A4_n = 50;
    private int A5_n = 50;
    
    private int B1_n = 50;
    private int B2_n = 50;
    private int B3_n = 50;
    private int B4_n = 50;
    private int B5_n = 50;
    
    private int C1_n = 50;
    private int C2_n = 50;
    private int C3_n = 50;
    private int C4_n = 50;
    private int C5_n = 50;
    
    private int D1_n = 50;
    private int D2_n = 50;
    private int D3_n = 50;
    private int D4_n = 50;
    private int D5_n = 50;

    
    private int A1 = 50;
    private int A2 = 50;
    private int A3 = 50;
    private int A4 = 50;
    private int A5 = 50;
    
    private int B1 = 50;
    private int B2 = 50;
    private int B3 = 50;
    private int B4 = 50;
    private int B5 = 50;
    
    private int C1 = 50;
    private int C2 = 50;
    private int C3 = 50;
    private int C4 = 50;
    private int C5 = 50;
    
    private int D1 = 50;
    private int D2 = 50;
    private int D3 = 50;
    private int D4 = 50;
    private int D5 = 50;
    


    public Chart_controller() {

    }
    
    
    public void delta(){
        
        result_list = resultFacade.findAll();

        if (result_list.size() > 0) {
            int id = 0;
            for (SelfResult selfResult1 : result_list) {
                id = selfResult1.getId();
            }

            selfResult = resultFacade.find(id);
            resultFacade.remove(selfResult);            
        }

        double a = (A1_n + A2_n + A3_n + A4_n + A5_n)/5;
        double b = (B1_n + B2_n + B3_n + B4_n + B5_n)/5;
        double c = (C1_n + C2_n + C3_n + C4_n + C5_n)/5;
        double d = (D1_n + D2_n + D3_n + D4_n + D5_n)/5;
        
        double a_f = (A1 + A2 + A3 + A4 + A5)/5;
        double b_f = (B1 + B2 + B3 + B4 + B5)/5;
        double c_f = (C1 + C2 + C3 + C4 + C5)/5;
        double d_f = (D1 + D2 + D3 + D4 + D5)/5;
        
        SelfResult new_result = new SelfResult();
        new_result.setAN(Double.toString(a));
        new_result.setBN(Double.toString(b));
        new_result.setCN(Double.toString(c));
        new_result.setDN(Double.toString(d));
        
        new_result.setAF(Double.toString(a_f));
        new_result.setBF(Double.toString(b_f));
        new_result.setCF(Double.toString(c_f));
        new_result.setDF(Double.toString(d_f));
        
        resultFacade.create(new_result);   
        
        AllResult new_allResult = new AllResult();
        new_allResult.setAN(Double.toString(a));
        new_allResult.setBN(Double.toString(b));
        new_allResult.setCN(Double.toString(c));
        new_allResult.setDN(Double.toString(d));
        
        new_allResult.setAF(Double.toString(a_f));
        new_allResult.setBF(Double.toString(b_f));
        new_allResult.setCF(Double.toString(c_f));
        new_allResult.setDF(Double.toString(d_f));
        
        result_list = resultFacade.findAll();
        
        new_allResult.setUser(getSessionUser());
            
        user_list = userFacade.findAll();
        
        for (User u : user_list) {
            if (u.getLogin().equals(getSessionUser())) {
                new_allResult.setRole(u.getRole());
            }
        }
        
        allResultFacade.create(new_allResult);
        
        
    }
    
    private String getSessionUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        Enumeration e = session.getAttributeNames();
        Object value = session.getValue("user");
        return value.toString();
    }
    

    public int rangeredValue(){
        if (A1 < 50) {
            return D1+A1;
        }else{
            return D1-A1;
        }
    }
    
    public void onSlideEnd(SlideEndEvent event) {        
       int value = event.getValue();
//       if(value < 50){
//           D1+=A1; 
//       }else{
//           D1-=A1;
//       }
        System.out.println(value);
    }

    public int getSomeValue() {
        return someValue;
    }

    public void setSomeValue(int someValue) {
        this.someValue = someValue;
    }


    
    
    public void ddd(){
        System.out.println(A1_n);
    }

    public SelfResult getSelfResult() {
        return selfResult;
    }
    
    
  
    public int getA1() {
        return A1;
    }

    public void setA1(int A1) {
        this.A1 = A1;
    }

    public int getA2() {
        return A2;
    }

    public void setA2(int A2) {
        this.A2 = A2;
    }

    public int getA3() {
        return A3;
    }

    public void setA3(int A3) {
        this.A3 = A3;
    }

    public int getA4() {
        return A4;
    }

    public void setA4(int A4) {
        this.A4 = A4;
    }

    public int getA5() {
        return A5;
    }

    public void setA5(int A5) {
        this.A5 = A5;
    }

    public int getB1() {
        return B1;
    }

    public void setB1(int B1) {
        this.B1 = B1;
    }

    public int getB2() {
        return B2;
    }

    public void setB2(int B2) {
        this.B2 = B2;
    }

    public int getB3() {
        return B3;
    }

    public void setB3(int B3) {
        this.B3 = B3;
    }

    public int getB4() {
        return B4;
    }

    public void setB4(int B4) {
        this.B4 = B4;
    }

    public int getB5() {
        return B5;
    }

    public void setB5(int B5) {
        this.B5 = B5;
    }

    public int getC1() {
        return C1;
    }

    public void setC1(int C1) {
        this.C1 = C1;
    }

    public int getC2() {
        return C2;
    }

    public void setC2(int C2) {
        this.C2 = C2;
    }

    public int getC3() {
        return C3;
    }

    public void setC3(int C3) {
        this.C3 = C3;
    }

    public int getC4() {
        return C4;
    }

    public void setC4(int C4) {
        this.C4 = C4;
    }

    public int getC5() {
        return C5;
    }

    public void setC5(int C5) {
        this.C5 = C5;
    }

    public int getD1() {
        return D1;
    }

    public void setD1(int D1) {
        this.D1 = D1;
    }

    public int getD2() {
        return D2;
    }

    public void setD2(int D2) {
        this.D2 = D2;
    }

    public int getD3() {
        return D3;
    }

    public void setD3(int D3) {
        this.D3 = D3;
    }

    public int getD4() {
        return D4;
    }

    public void setD4(int D4) {
        this.D4 = D4;
    }

    public int getD5() {
        return D5;
    }

    public void setD5(int D5) {
        this.D5 = D5;
    }

    public int getA1_n() {
        return A1_n;
    }

    public void setA1_n(int A1_n) {
        this.A1_n = A1_n;
    }

    public int getA2_n() {
        return A2_n;
    }

    public void setA2_n(int A2_n) {
        this.A2_n = A2_n;
    }

    public int getA3_n() {
        return A3_n;
    }

    public void setA3_n(int A3_n) {
        this.A3_n = A3_n;
    }

    public int getA4_n() {
        return A4_n;
    }

    public void setA4_n(int A4_n) {
        this.A4_n = A4_n;
    }

    public int getA5_n() {
        return A5_n;
    }

    public void setA5_n(int A5_n) {
        this.A5_n = A5_n;
    }

    public int getB1_n() {
        return B1_n;
    }

    public void setB1_n(int B1_n) {
        this.B1_n = B1_n;
    }

    public int getB2_n() {
        return B2_n;
    }

    public void setB2_n(int B2_n) {
        this.B2_n = B2_n;
    }

    public int getB3_n() {
        return B3_n;
    }

    public void setB3_n(int B3_n) {
        this.B3_n = B3_n;
    }

    public int getB4_n() {
        return B4_n;
    }

    public void setB4_n(int B4_n) {
        this.B4_n = B4_n;
    }

    public int getB5_n() {
        return B5_n;
    }

    public void setB5_n(int B5_n) {
        this.B5_n = B5_n;
    }

    public int getC1_n() {
        return C1_n;
    }

    public void setC1_n(int C1_n) {
        this.C1_n = C1_n;
    }

    public int getC2_n() {
        return C2_n;
    }

    public void setC2_n(int C2_n) {
        this.C2_n = C2_n;
    }

    public int getC3_n() {
        return C3_n;
    }

    public void setC3_n(int C3_n) {
        this.C3_n = C3_n;
    }

    public int getC4_n() {
        return C4_n;
    }

    public void setC4_n(int C4_n) {
        this.C4_n = C4_n;
    }

    public int getC5_n() {
        return C5_n;
    }

    public void setC5_n(int C5_n) {
        this.C5_n = C5_n;
    }

    public int getD1_n() {
        return D1_n;
    }

    public void setD1_n(int D1_n) {
        this.D1_n = D1_n;
    }

    public int getD2_n() {
        return D2_n;
    }

    public void setD2_n(int D2_n) {
        this.D2_n = D2_n;
    }

    public int getD3_n() {
        return D3_n;
    }

    public void setD3_n(int D3_n) {
        this.D3_n = D3_n;
    }

    public int getD4_n() {
        return D4_n;
    }

    public void setD4_n(int D4_n) {
        this.D4_n = D4_n;
    }

    public int getD5_n() {
        return D5_n;
    }

    public void setD5_n(int D5_n) {
        this.D5_n = D5_n;
    }

    public int[] getPeople() {
        return people;
    }

    public void setPeople(int[] people) {
        this.people = people;
    }



    
    
    
    
    
    
    
}
