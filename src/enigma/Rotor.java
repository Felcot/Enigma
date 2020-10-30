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
public class Rotor {
    String name;
    Alfabeto interna;
    Alfabeto externa;
    MediatorRotor mediador;
    boolean rotorMedio;
    public Rotor(String name,Alfabeto interna, Alfabeto externa) {
        this.interna = interna;
        this.externa = externa;
        this.rotorMedio=false;
        this.name=name;
    }

    public Rotor(String name,Alfabeto interna, Alfabeto externa, char clave,char clavija, Rotor r,Rotor a) {
        this(name,interna, externa);
        
        this.mediador = new MediatorRotor(r,this.externa.posicion((clave + "").toUpperCase()),this.externa.posicion((clavija+"").toUpperCase()), this.externa.size(),a);
    }
    
    public Rotor(String name,Alfabeto interna, Alfabeto externa, char clave,char clavija, Rotor r,Rotor a,boolean rotorMedio) {
        this(name,interna, externa,clave,clavija,r,a);
        this.rotorMedio=rotorMedio;
    }
    public Rotor(String name,Alfabeto interna, Alfabeto externa, char clave,char clavija, Reflector r,Rotor a) {
        this(name,interna, externa);
        this.mediador = new MediatorRotor(a,r,this.externa.posicion(clave + ""),this.externa.posicion(clavija+""), this.externa.size());
    }
    
    public void girar(){
        this.mediador.giro();
    }

   public String initEncrypt(String msg){
       String result = "";
       msg=msg.toUpperCase();
       System.out.println(msg);
        for(char c : msg.toCharArray()){
            if(c != ' ')
                result += this.encrypt(c+"");
            else
                result += this.encrypt("X");
        }
           
       return result;
   }
   public String encrypt(String result){
       this.girar();
       result = encryptIda(result);
       return result;
   }
   public String encryptIda(String letra){
       if(this.mediador.nextRotor != null)
            return this.mediador.nextRotor.encryptIda(this.encryptExtInt(letra));
       else
           return this.encryptVuelta(this.mediador.ref.encrypt(this.encryptExtInt(letra)));
   }
   public String encryptExtInt(String letra){
       int offset = this.mediador.getOffset();
       int size = this.externa.size();
       String result = this.externa.getLetra((this.externa.posicion(this.interna.getLetra((this.externa.posicion(letra) + offset) % size))-offset)%size);
       return result;
   }
   
   
   
   public String encryptVuelta(String letra){
       if(this.mediador.anterior != null)
            return this.mediador.anterior.encryptVuelta(this.encryptIntExt(letra));
       else{
           return this.encryptIntExt(letra);
       }
   }
   public String encryptIntExt(String letra){
       int offset = this.mediador.getOffset();
       int size = this.externa.size();
       return this.externa.getLetra((this.externa.posicion(this.externa.getLetra(this.interna.posicion(this.externa.getLetra((this.externa.posicion(letra) + offset)% size)))) -offset)%size);
   }
    public String toString() {
        return "int: " + this.interna.toString() + "\next: " + this.externa.toString();
    }


}
