/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class Reflector {

    Alfabeto reflector;
    Alfabeto abc;
    
    public Reflector(String ref,Alfabeto abc) {
        Map<String, String> dic = new HashMap<String, String>();
        dic.put("A", "EJMZALYXVBWFCRQUONTSPIKHGD");
        dic.put("B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
        dic.put("BThin", "ENKQAUYWJICOPBLMDXZVFTHRGS");
        dic.put("C", "FVPJIAOYEDRZXWGCTKUQSBNMHL");
        dic.put("CThin", "RDOBJNTKVEHMLFCWZAXGYIPSUQ");
        //El reflector por defecto se ha establecido el B en caso de no
        //No encontrar el refector buscado.
        String result = dic.get(ref);
        result = result != null ? result : dic.get("B");
        this.abc=abc;
        this.reflector = new Alfabeto(result);
    }
    public String reflectar(String letra){
        return this.abc.getLetra(this.reflector.posicion(letra));
    }
    
    public String encrypt (String ida){
        return this.reflector.getLetra(this.abc.posicion(ida));
    }
}
