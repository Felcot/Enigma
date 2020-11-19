/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import java.util.ArrayList;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class ObserverBruteForce{
    public ArrayList<RegisterBruteForce> registerList;
    static ArrayList<String>diccionario;
    int counterListeners = 0;
    public ObserverBruteForce(){
        this.registerList = new ArrayList<RegisterBruteForce>();
        diccionario = new ArrayList<String>();
        diccionario.add("ambiguo".toUpperCase());
        diccionario.add("obvio".toUpperCase());
        diccionario.add("trivial".toUpperCase());
        diccionario.add("estupendo".toUpperCase());
        diccionario.add("esther".toUpperCase());
        diccionario.add("lechuga".toUpperCase());
        diccionario.add("lugar".toUpperCase());
        diccionario.add("pacifico".toUpperCase());
        diccionario.add("primera".toUpperCase());
        diccionario.add("hola".toUpperCase());
        diccionario.add("mundo".toUpperCase());
        diccionario.add("señora".toUpperCase());
        diccionario.add("calabaza".toUpperCase());
        diccionario.add("herpes".toUpperCase());
        diccionario.add("celula".toUpperCase());
        diccionario.add("porro".toUpperCase());
        diccionario.add("suaves".toUpperCase());
        diccionario.add("albacete".toUpperCase());
        diccionario.add("fiesta".toUpperCase());
        diccionario.add("patata".toUpperCase());
    }
    
    public boolean encourer(RegisterBruteForce register){
        String solution =  register.getSolution();
        boolean result = false;
        try{     
        for(CharSequence cs : diccionario)
            if(solution.contains(cs)){
                register.markSolution(cs.toString());
                result = !result;
                break;
            }
        }catch(NullPointerException npe){}
        return result;
        
    }
    public boolean addToRegister(RegisterBruteForce rbf){
        return this.registerList.add(rbf);
    }
    public RegisterBruteForce listener(){
            for(int pos = counterListeners;pos<this.registerList.size() ;pos++){
                this.counterListeners++;
                RegisterBruteForce r = this.registerList.get(pos);
                if(this.encourer(r)){
                    return r;
                }
            }
            return null;
    }
    public boolean isEmpty(){
        return this.registerList.isEmpty();
    }
}
