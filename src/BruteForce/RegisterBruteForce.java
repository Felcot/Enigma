/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class RegisterBruteForce {
    private String parameter;
    private String keys;
    private String changer;
    private String solution;
    
    public RegisterBruteForce(String parameter,String keys,String changer){
        this.parameter = parameter;
        this.keys = keys;
        this.changer = changer;
    }
    
    public void setSolution(String solution){
        this.solution = solution;
    }
    public String getSolution(){
        return this.solution;
    }
    public void markSolution(String encourer){
        this.setSolution(this.solution.replaceAll(encourer, "\u001B[31m"+encourer+"\u001B[0m"));
        
    }
    public String toString(){
        return this.keys+this.changer;
    }
}
