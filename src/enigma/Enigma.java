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

    private Alfabeto abc;
    private Rotor rot1;
    private Rotor rot2;
    private Rotor rot3;
    private Reflector ref;
    private Replacement changers;
     

    public Enigma(Alfabeto abc, Alfabeto r3, Alfabeto r2, Alfabeto r1, char[] clave,char [] clavija, String reflector,Replacement changers) {
        this.abc = abc;
        this.ref = new Reflector(reflector,abc);
        this.rot1 = new Rotor("rot1",r1, abc, clave[2],clavija[2], ref,rot2);
        this.rot2 = new Rotor("rot2",r2, abc, clave[1],clavija[1], rot1,rot3, true);
        this.rot3 = new Rotor("rot3",r3, abc, clave[0],clavija[0], rot2,null);
        this.rot1.mediador.anterior=rot2;
        this.rot2.mediador.anterior=rot3;
        this.changers =  changers;
    }

    public String encrypt(String character) {
        return this.execChanger(rot3.initEncrypt(this.execChanger(character.toUpperCase())));
    }
    
    
    private String execChanger(String character){
        return !this.changers.isEmpty() ? this.canToexecChanger(character): character;
    }
    
    private String canToexecChanger(String character){
        String result = "";
            for(char c:character.toCharArray())
                result += this.executeChanger(c);
        return result;
    }
    private String executeChanger(char c){
        return changers.containsKey(c+"")? changers.getChagerValue(c+""):c+"";
    }
    
}
