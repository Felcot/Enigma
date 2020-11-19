/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BruteForce;

import enigma.Alfabeto;

/**
 * @author Felman
 * @author Felipe Costa Tebar & Miguel Angel Picazo Fernandez
 */
public class main {
    public static void main(String[] args) {
        Alfabeto abc = new Alfabeto("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        ObserverBruteForce observer = new ObserverBruteForce();
        int size = abc.size();
        String parameter =  "MSZXNXFPYDMHOVZWJZIRWULDGSDHUIPAERZLGOFFPBOVILGTIQJHUTNTSZCCBNCLLATPNLGIAJWJ";
        for (int a  = 0; a < size; a++) {
            System.out.println("("+a+"/"+(size-1)+")");
            for (int b = 0; b < size; b++) {
                for (int c = 0; c < size; c++) {
                    for (int d = 0; d < size; d++) {
                        for (int e = d+1; e < size; e++) {
                            String claves =  abc.getLetra(c)+abc.getLetra(b)+abc.getLetra(a);
                            String replacementDE = abc.getLetra(d)+abc.getLetra(e);
                            HubBruteForce hbde = new HubBruteForce(parameter,claves,replacementDE);
                            observer.registerList.add(hbde.getRegiter());
                            
                            RegisterBruteForce perhapsSolution= observer.listener();
                            if(perhapsSolution != null){
                                System.out.println("Perhaps solution:");
                                System.out.println(perhapsSolution.toString());
                                System.out.println(perhapsSolution.getSolution());
                            }
                        }
                    }
                }
            }
        
        }
        
        
    }
}
