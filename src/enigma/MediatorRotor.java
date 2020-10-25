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

    int clavija;
    int sizeAlfabeto;
    Rotor nextRotor;

    public MediatorRotor(Rotor r, int clavija, int sizeAlfabeto) {
        nextRotor = r;
        this.clavija = clavija;
        this.sizeAlfabeto = sizeAlfabeto;
    }

    //Gira el rotor actual
    public boolean giro() {
        this.clavija++;
        return this.advaseGiro();
    }

    // Permite avisar al siguiente rotor cuando debe girar
    private boolean advaseGiro() {
        boolean result = false;
        if (this.clavija % this.sizeAlfabeto == 0) {
            this.clavija = 0;
            result = true;
            if (null != nextRotor) {
                nextRotor.girar();
            }
        }
        return result;
    }
}
