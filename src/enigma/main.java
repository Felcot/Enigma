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
        Alfabeto abc = new Alfabeto("ABCDEFGHIJKLMNOPQSRTUVWXYZ");
        Alfabeto r3 = new Alfabeto("BDFHJLCPRTXVZNYEIWGAKMUSQO");
        Alfabeto r2 = new Alfabeto("AJDKSIRUXBLHWTMCQGZNPYFVOE");
        Alfabeto r1 = new Alfabeto("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
        char[] clave = new char[3];
        clave[0] = 'A'; // Rotor 3
        clave[1] = 'A'; // Rotor 2
        clave[2] = 'A'; // Rotor 1

        Enigma maquina = new Enigma(abc, r3, r2, r1, clave, "B");
        maquina.encrypt("A");
    }
}
