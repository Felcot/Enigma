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
public class MediatorRotor {

    int offset;
    int clavija;
    int sizeAlfabeto;
    Rotor anterior;
    Rotor nextRotor;
    Reflector ref;
    public MediatorRotor(Rotor r, int offset,int clavija, int sizeAlfabeto,Rotor anterior) {
        this.clavija = clavija;
        this.nextRotor = r;
        this.anterior = anterior;
        this.offset = offset;
        this.sizeAlfabeto = sizeAlfabeto;
    }
    public MediatorRotor(Rotor anterior,Reflector r, int offset,int clavija, int sizeAlfabeto) {
        this(null,offset,clavija,sizeAlfabeto,anterior);
        this.ref= r;
    }
    //Gira el rotor actual
    public void giro() {
        this.offset=(this.offset + 1) % this.sizeAlfabeto;
        if(this.offset == this.clavija){
            this.nextRotor.girar();
        }
            
    }
    public boolean enClavija(){
        return this.clavija == this.offset;
    }
    public int getOffset(){
        return this.offset;
    }
    
}
