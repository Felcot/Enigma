/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class Replacement {
    private Map<String,String> changer;
    public Replacement (){
        this.changer = new HashMap();
    }
    public Replacement(char [] changer){
        this();
        this.changer.put(changer[0]+"",""+changer[1]);
        this.changer.put(changer[1]+"",""+changer[0]);
        
    }
    public void addChanger(String a,String b){
        this.changer.put(a, b);
        this.changer.put(b, a);
    }
    public Map<String,String> getChanger(){
        return this.changer;
    }
    
    public String getChagerValue(String key){
        return this.changer.get(key);
    }
    public boolean isEmpty(){
        return changer.isEmpty();
    }
    public boolean containsKey(String key){
        return this.changer.containsKey(key);
    }
}
