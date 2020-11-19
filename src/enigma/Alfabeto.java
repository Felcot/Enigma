/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class Alfabeto {

    Queue<String> letras;

    public Alfabeto(String cadena) {
        letras = new LinkedList<>();
        for (char c : cadena.toCharArray()) {
            letras.add(c + "");
        }
    }

    public int posicion(String character) {
        return ((LinkedList<String>) letras).indexOf(character);
    }

    public String getLetra(int posicion) {
       
        if(posicion < 0) {
            posicion = this.size() + posicion;
        }
        
            return ((LinkedList<String>) letras).get(posicion);
    }

    public int size() {
        return ((LinkedList<String>) letras).size();
    }

    @Override
    public String toString() {
        return toString(this.size() - 1);
    }
    

    private String toString(int n) {
        if (n < 0) {
            return "";
        }
        return this.toString(n - 1) + ((LinkedList<String>) this.letras).get(n);
    }
}
