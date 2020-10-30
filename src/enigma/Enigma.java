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

    public Enigma(Alfabeto abc, Alfabeto r3, Alfabeto r2, Alfabeto r1, char[] clave,char [] clavija, String reflector) {
        this.abc = abc;
        this.ref = new Reflector(reflector,abc);
        this.rot1 = new Rotor("rot1",r1, abc, clave[2],clavija[2], ref,rot2);
        this.rot2 = new Rotor("rot2",r2, abc, clave[1],clavija[1], rot1,rot3, true);
        this.rot3 = new Rotor("rot3",r3, abc, clave[0],clavija[0], rot2,null);
        this.rot1.mediador.anterior=rot2;
        this.rot2.mediador.anterior=rot3;
    }

    public String encrypt(String character) {
        System.out.println(rot3.initEncrypt(character));
        System.out.println("C:"+this.rot3.mediador.clavija+" O:"+this.rot3.mediador.offset);
        
        return "";
    }

}
