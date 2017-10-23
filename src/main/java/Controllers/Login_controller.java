/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.mycompany.mavenproject1.User;
import com.mycompany.mavenproject1.beans.UserFacade;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author zekart
 */
@Named(value = "loginController")
@SessionScoped
public class Login_controller implements Serializable{
    @EJB
    private UserFacade userFacade;
    private User current = new User();
    private User newUser = new User();
    private List<User> users=new ArrayList<>();
    private boolean entered=false;
    
    FacesContext context = FacesContext.getCurrentInstance();
       
    
    public String login(){
        users=userFacade.findAll();
        for (User user : users) {
            if(user.getLogin().equals(current.getLogin())){
                if (user.getPassword().equals(current.getPassword())) {
                    current = user;
                    entered = true;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", current.getLogin());
                    return"test.xhtml?faces-redirect=true";                    
                }else{                   
                    return "";
                }
            }
            
        }
        return "";
    }
    
    public String registration(){
        users=userFacade.findAll();
        
        if (users.equals(this.current.getLogin())) {
        }else{
            User new_user = new User();
            new_user.setLogin(newUser.getLogin());
            new_user.setPassword(newUser.getPassword());
            new_user.setRole(newUser.getRole());

            userFacade.create(new_user);
            User newUser = new User();   
            return"index.xhtml?faces-redirect=true"; 
        }
        
        return "";

            //users.add(new_user);
            

    }    
    
    

    public User getCurrent() {
        return current;
    }

    public void setCurrent(User current) {
        this.current = current;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    
    
}
