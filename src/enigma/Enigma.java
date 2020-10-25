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
public class Enigma {
        Alfabeto abc;
        Rotor rot1;
        Rotor rot2;
        Rotor rot3;
        Reflector ref;
        public Enigma(Alfabeto abc,Alfabeto r3,Alfabeto r2,Alfabeto r1,char [] clave,String reflector){
            this.abc = abc;
            rot1 = new Rotor(r1, abc,clave[2],null);
            rot2 = new Rotor(r2, abc,clave[1],rot1);
            rot3 = new Rotor(r3, abc,clave[0],rot2);
            Reflector ref = new Reflector(reflector);
        }
        public String encrypt(String character){
            //Avanza 1 posicion
            // Enlaza con interno -> L
            // Enlaza interna L Externa-> Numero
            // Numero interno L Externo
            return "";
        }
        
}
