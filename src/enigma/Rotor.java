/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

import java.util.Queue;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class Rotor{
    Alfabeto interna;
    Alfabeto externa;
    MediatorRotor mediador;
    
    public Rotor(Alfabeto interna,Alfabeto externa){
        this.interna=interna;
        this.externa=externa;
    }
    
    public Rotor(Alfabeto interna,Alfabeto externa,char clave,Rotor r){
        this(interna,externa);
        this.mediador= new MediatorRotor(r,this.externa.posicion(clave+""),this.externa.size());
        
    }
    public void girar(){
        boolean interGiro = this.interna.girar();
        boolean exterGiro = this.externa.girar();
        if(interGiro && exterGiro)
            mediador.giro();
        else
            if(interGiro)
                this.interna.desHacerGiro();
            else
                this.externa.desHacerGiro();
    }
    
    public String enlaceIntExt(String character){
        return this.externa.getLetra(this.interna.posicion(character));
    }
    public String enlaceExtInt(String character){
        return this.interna.getLetra(this.externa.posicion(character));
    }
    
    public String toString(){
        return "int: "+this.interna.toString() + "\next: "+this.externa.toString();
    }
}
