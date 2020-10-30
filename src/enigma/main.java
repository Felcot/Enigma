/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class main {

    public static void main(String[] args) {
        Alfabeto abc = new Alfabeto("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Alfabeto r3 = new Alfabeto("BDFHJLCPRTXVZNYEIWGAKMUSQO");
        Alfabeto r2 = new Alfabeto("AJDKSIRUXBLHWTMCQGZNPYFVOE");
        Alfabeto r1 = new Alfabeto("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        char[] clavija = new char[3];
        clavija[0] = 'W'; // Rotor 3
        clavija[1] = 'F'; // Rotor 2
        clavija[2] = 'R'; // Rotor 1
        
        char[] clave = new char[3];
        clave[0] = 'Z'; // Rotor 3
        clave[1] = 'A'; // Rotor 2
        clave[2] = 'A'; // Rotor 1
        
        Enigma maquina = new Enigma(abc, r3, r2, r1, clave,clavija, "B");
        maquina.encrypt("Hola mundo Enigma ha sido resuelto");
    }
}
