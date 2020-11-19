/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Marco-Javier Gomez Martinez
 */
public class Search {

    public static void main(String[] args) {
        if (args.length != 5) {
            System.out.println("\n**Sorry, correct usage require 5 params:");
            System.out.println("Board size: int.");
            System.out.println("Density: (0.1,1]. Probability for each piece to be included.");
            System.out.println("Seed1: int. To initialize the problem instance random number generator (for reproducibility)");
            System.out.println("Agent: {0,1,2,3,4,5} standing for white pawn, rook, bishop, knight, queen or king.");
            System.out.println("Seed2: int. To initialize the Random Search instance random number generator (for reproducibility)");

            System.exit(0);
        }

        int size = Integer.parseInt(args[0]);
        double density = Double.parseDouble(args[1]);
        int seed1 = Integer.parseInt(args[2]);
        int agent = Integer.parseInt(args[3]);

        if (size < 4) {
            System.out.println("\nSorry: board to small, modified to 4");
            size = 4;
        }

        if ((density < 0.1) || (density > 1)) {
            System.out.println("\nSorry: bad density value, modified to 0.25");
            density = 0.25;
        }

        if ((density * 32) > (size * size)) {
            System.out.println("\nSorry: too much pieces for the board size, modifying density to 0.25");
            density = 0.25;
        }

        if ((agent < 0) || (agent > 11)) {
            System.out.println("\nSorry: bad selected agent, modified to 1 (white rook)");
            agent = Utils.wRook;
        }

        // getting the initial state
        State state = Utils.getProblemInstance(size, density, seed1, agent);
        Utils.printBoard(state);

        //Switch basado en el de SimpleRandomSearch con la diferencia de que ya no hay semilla 2 
        //y se introduce el nombre de la función que se quiera ejecutar, siendo estudio la ejecución completa de una bateria de 100 estudios para cada función
        Search srs = new Search();
        switch (args[4]) {
            case "Anchura":
                srs.anchura(state, true);
                break;
            case "Profundidad":
                srs.profundidad(state, true);
                break;
            case "CosteUniforme":
                srs.costeUniforme(state, true);
                break;
            case "PrimeroMejor":
                srs.primeroMejor(state, true);
                break;
            case "AEstrella":
                srs.AEstrella(state, true);
                break;
            case "Estudio":
                srs.Estudio(size, density, seed1, agent);
                break;
            default:
                System.out.println("Se ha producido algún error compruebe que ha introducido correctamente el nombre del algoritmo");
                System.out.println("[Anchura,Profundidad,CosteUniforme,PrimeroMejor,AEstrella]");
        }

    }

    public State anchura(State nodo, boolean check) {
        if (check) {
            System.out.println("Algoritmo de Busqueda en Anchura");
        }
        Piece agente = Piece.newPiece(nodo.m_agent);
        Queue<State> descendientes = new LinkedList();
        Map<String, State> visitados = new HashMap<String, State>();
        try{
        while (!nodo.isFinal()) {
            String name = nodo.getName();
            if (!visitados.containsKey(name)) {
                descendientes.addAll(this.obtenerStates(agente.getPossibleActions(nodo), nodo));
                visitados.put(name, nodo);
                if (descendientes.isEmpty()) {
                    if(check)
                        System.out.println("No se ha encontrado solución");
                    return null;
                }
                
            }
            nodo = descendientes.poll();
            
        }}catch(NullPointerException ex){
            if(check)System.out.println("No se ha encontrado solución");
            return null;
        }
            if (check) {
                this.toPrintSolution(nodo, visitados, descendientes);
            }
       
        return nodo;
    }

    //
    public State profundidad(State nodo, boolean check) {
        if (check) {
            System.out.println("Algoritmo de Busqueda en Profundidad");
        }
        
        Piece agente = Piece.newPiece(nodo.m_agent);
        Stack<State> descendientes = new Stack();
        Map<String, State> visitados = new HashMap<String, State>();
        try{while (!nodo.isFinal()) {
            
            String name = nodo.getName();
            if (!visitados.containsKey(name)) {
                descendientes.addAll(this.obtenerStates(agente.getPossibleActions(nodo), nodo));
                
                visitados.put(name, nodo);
            }
            if (descendientes.isEmpty()) {
                    if(check)System.out.println("No se ha encontrado solución");
                    return null;
                }
            nodo = descendientes.pop();
            
        }}catch(NullPointerException ex){
            if(check)System.out.println("No se ha encontrado solución");
                    return null;
        }
        if (check) {
            this.toPrintSolution(nodo, visitados, descendientes);

        }

        return nodo;
    }

    public State costeUniforme(State nodo, boolean check) {
        if (check) {
            System.out.println("Algoritmo de Busqueda en Coste Uniforme");
        }
        
        Piece agente = Piece.newPiece(nodo.m_agent);
        PriorityQueue<State> descendientes = new PriorityQueue(new State.ComparatorCost());
        Map<String, State> visitados = new HashMap<String, State>();
        try{while (!nodo.isFinal()) {
            String name = nodo.getName();
            if (!visitados.containsKey(name)) {
                descendientes.addAll(this.obtenerStates(agente.getPossibleActions(nodo), nodo));
                visitados.put(name, nodo);
            }
            if (descendientes.isEmpty()) {
                    if(check)System.out.println("No se ha encontrado solución");
                    return null;
                }
            nodo = descendientes.poll();
            
        }}catch(NullPointerException ex){
            if(check)System.out.println("No se ha encontrado solución");
                    return null;
        }
        if (check) {
            this.toPrintSolution(nodo, visitados, descendientes);

        }

        return nodo;
    }

    public State primeroMejor(State nodo, boolean check) {
        if (check) {
            System.out.println("Algoritmo de Busqueda en Primero Mejor");
        }
        
        Piece agente = Piece.newPiece(nodo.m_agent);
        PriorityQueue<State> descendientes = new PriorityQueue(new State.ComparatorHeuristic());
        Map<String, State> visitados = new HashMap<String, State>();
        try {while (!nodo.isFinal()) {
            String name = nodo.getName();
            if (!visitados.containsKey(name)) {
                descendientes.addAll(this.obtenerStates(agente.getPossibleActions(nodo), nodo));
                if (descendientes.isEmpty()) {
                    if(check)System.out.println("No se ha encontrado solución");
                    return null;
                }
                visitados.put(name, nodo);
            }
            nodo = descendientes.poll();
            
        }}catch(NullPointerException ex){
            if(check)System.out.println("No se ha encontrado solución");
                    return null;
        }
        if (check) {
            this.toPrintSolution(nodo, visitados, descendientes);
        }

        return nodo;
    }

    //AEstrella 
    public State AEstrella(State nodo, boolean check) {
        if (check) {
            System.out.println("Algoritmo de Busqueda en A Estrella");
        }
        
        Piece agente = Piece.newPiece(nodo.m_agent);
        PriorityQueue<State> descendientes = new PriorityQueue(new State.ComparatorAStar());
        Map<String, State> visitados = new HashMap<String, State>();
        try{while (!nodo.isFinal()) {
            String name = nodo.getName();
            if (!visitados.containsKey(name)) {
                descendientes.addAll(this.obtenerStates(agente.getPossibleActions(nodo), nodo));
                if (descendientes.isEmpty()) {
                    if(check)System.out.println("No se ha encontrado solución");
                    return null;
                }
                visitados.put(name, nodo);
            }
            nodo = descendientes.poll();
            
        }}catch(NullPointerException ex){
            if(check)System.out.println("No se ha encontrado solución");
                    return null;
        }

        if (check) {
            this.toPrintSolution(nodo, visitados, descendientes);
        }

        return nodo;
    }

    public Collection obtenerStates(ArrayList<Action> moves, State nodo) {
        Collection<State> result = new LinkedList();
        for (int position = 0; position < moves.size(); position++) {
            result.add(nodo.applyAction(moves.get(position)));
        }
        return result;
    }

    public void toPrintSolution(State nodo, Map<String, State> visitados, Collection<State> descendientes) {
        System.out.println("Solución: ");
        Utils.printBoard(nodo);
        System.out.println("Camino: " + nodo.getWay());
        System.out.println("Longitud: " + nodo.getLongitud());
        System.out.println("Coste: " + nodo.getCost());
        System.out.println("Nodos Generados: " + (visitados.size() + descendientes.size() + 1));
        System.out.println("Nodos Expandidos: " + (visitados.size() + descendientes.size()));
        System.out.println("Nodos Explorados: " + visitados.size());
    }

    public void Estudio(int size, double density, int seed1, int agent) {
        double almc[][] = new double[10][2];
        double average[] = new double[10];
        boolean check = false;
        State m_finalState = null;
        String supp[] = new String[5];
        supp[0] = "Anchura";
        supp[1] = "Profundidad";
        supp[2] = "CosteUniforme";
        supp[3] = "PrimeroMejor";
        supp[4] = "AEstrella";

        // getting the initial state
        for (int metodo = 0; metodo < supp.length; metodo++) {
            for (int s1 = 0; s1 < 10; s1++) {
                check = false;
                for (int s2 = 0; s2 < 10;) {
                    State state = Utils.getProblemInstance(size, density, seed1 + s1, agent);

                    Search srs = new Search();
                    switch (supp[metodo]) {
                        case "Anchura":
                            m_finalState = srs.anchura(state, false);
                            break;
                        case "Profundidad":
                            m_finalState = srs.profundidad(state, false);
                            break;
                        case "CosteUniforme":
                            m_finalState = srs.costeUniforme(state, false);
                            break;
                        case "PrimeroMejor":
                            m_finalState = srs.primeroMejor(state, false);
                            break;
                        case "AEstrella":
                            m_finalState = srs.AEstrella(state, false);
                            break;
                        
                    }

                    if (m_finalState != null) {
                        if (!check) {
                            check = !check;
                            almc[s1][0] = m_finalState.getCost();
                            almc[s1][1] = m_finalState.getCost();
                        }

                        if (m_finalState.getCost() < almc[s1][0]) {
                            almc[s1][0] = m_finalState.getCost();
                        }

                        if (m_finalState.getCost() > almc[s1][1]) {
                            almc[s1][1] = m_finalState.getCost();
                        }

                        average[s1] += m_finalState.getCost();
                        s2++;
                    }else{
                        break;
                    }
                }
                average[s1] /= 10;
            }
            System.out.println("MÉTODO: " + supp[metodo]);
            System.out.println("Semilla\t Media\t Desviación Estándar");
            for (int s1 = 0; s1 < 10; s1++) {
                System.out.println((seed1 + s1) + "\t " + average[s1] + "\t " + " +-" + ((almc[s1][1] - almc[s1][0]) / 2));
            }
        }

    }
}
