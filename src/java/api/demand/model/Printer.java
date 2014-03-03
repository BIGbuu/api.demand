/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package api.demand.model;

import java.io.Serializable;

/**
 *
 * @author BIG_bu
 */
public class Printer implements Serializable {
    private String name;
    
    public Printer(){
        
    }
    public Printer(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
}
