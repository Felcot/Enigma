/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import enigma.*;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class HubBruteForce {
        private Enigma enigma;
        private RegisterBruteForce register;
        private HubBruteForce(String clave,Replacement changers){
            Alfabeto abc = new Alfabeto("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            Alfabeto r3 = new Alfabeto("BDFHJLCPRTXVZNYEIWGAKMUSQO");
            Alfabeto r2 = new Alfabeto("AJDKSIRUXBLHWTMCQGZNPYFVOE");
            Alfabeto r1 = new Alfabeto("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
            char[] clavija = new char[3];
            clavija[0] = 'W'; // Rotor 3
            clavija[1] = 'F'; // Rotor 2
            clavija[2] = 'R'; // Rotor 1
            enigma =  new Enigma(abc, r3, r2, r1, clave.toCharArray(),clavija, "B",changers);
        }
        private HubBruteForce(String clave, String changer){
            this(clave,new Replacement(changer.toCharArray()));
        }
        public HubBruteForce(String parameter,String clave, String changer){
            this(clave,changer);
            this.register =  new RegisterBruteForce(parameter,clave,changer );
            this.register.setSolution(enigma.encrypt(parameter));
        }
        public RegisterBruteForce getRegiter(){
            return this.register;
        }
}
