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
public class Reflector{
    Alfabeto reflector;
    public Reflector(String ref){
        reflector = obtenerReflector(ref);
        

    }
    public String diccionario(String ref){
        Map<String,String> dic = new HashMap<String,String>();
                           dic.put("A", "EJMZALYXVBWFCRQUONTSPIKHGD");
                           dic.put("B", "YRUHQSLDPXNGOKMIEBFZCWVJAT");
                           dic.put("BThin", "ENKQAUYWJICOPBLMDXZVFTHRGS");
                           dic.put("C", "FVPJIAOYEDRZXWGCTKUQSBNMHL");
                           dic.put("CThin", "RDOBJNTKVEHMLFCWZAXGYIPSUQ");
        //El reflector por defecto se ha establecido el B en caso de no
        //No encontrar el refector buscado.
        String result = dic.get(ref);
        result = result != null ? result : dic.get("B");
        return result;
    }
    public Alfabeto obtenerReflector(String ref){
        return new Alfabeto(this.diccionario(ref));
    }
}
