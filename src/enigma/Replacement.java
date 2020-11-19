/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author felip
 */
public class Replacement {
    private Map<String,String> changer = new HashMap();
    
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
