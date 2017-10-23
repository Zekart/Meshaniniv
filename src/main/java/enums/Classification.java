/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author zekart
 */
public enum Classification{
    Student("Студент"),
    Aspirant("Аспирант"),
    Assistance("Асистент"),
    Docent("Доцент"),
    Professor("Професор");
    
    private String classification;

    private Classification(String classification) {
        this.classification = classification;
    }

    public String Classification() {
        return classification;
    }

}