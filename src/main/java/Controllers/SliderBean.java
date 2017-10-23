/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.faces.bean.ManagedBean;


import org.primefaces.event.SlideEndEvent;

@ManagedBean
public class SliderBean {

    private int number = 50;

    private String category = "Start";
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    

    public void onSlideEnd(SlideEndEvent event) {
        int value = event.getValue();
        x= 100 - value; 
    }
}