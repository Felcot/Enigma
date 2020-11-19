package practica1;

import practica1.Pawn;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

// this class implements a simple search method which explores a single sequence of actions.
// The process is quite simple. At each state we look for the agent possible actions and choose one at random.
// The action is then applied and if the new state is final, the method stops returning the list of applied actions.
// On the other hand, we iterate.
public class SimpleRandomSearch {

    // member variables
    State m_initialState = null;
    int m_seedRS = -1;
    Random m_generator = null;
    ArrayList<Action> m_solution = null;
    Piece m_piece = null;
    State m_finalState = null;

    double m_cost = 0.0;

    // constructor
    SimpleRandomSearch(State s0, int seed, int m_agent) {
        m_initialState = s0;
        m_seedRS = seed;
        m_generator = new Random(m_seedRS);

        m_piece = Piece.newPiece(m_agent);

    }

    // search method --> Inicializamos el estado y mientras que no sea la solución final,se hace el interior del if y
    //en el caso del else, se generan las posibles acciones de la pieza actual y, si nos quedamos sin acciones, hacemos un break,
    //en otro caso se almacena la 1ª de las acciones, la acción tomada para llegar hasta ese punto y actualizamos valores.
    public void doSearch() {

        m_solution = new ArrayList<Action>(100);

        Boolean solutionFound = false;
        State current = null;
        Boolean noSolution = false;

        // main loop
        for (current = m_initialState; !solutionFound;) {

            if (current.isFinal()) { // first we check if the state is final
                solutionFound = true;
                m_finalState = current;
            } else {
                // generate successors
                ArrayList<Action> possibleActions = m_piece.getPossibleActions(current);
                if (possibleActions.size() == 0) {
                    break;
                }
                Action action = possibleActions.get(m_generator.nextInt(possibleActions.size()));
                m_solution.add(action);
                m_cost += action.getCost();
                current = current.applyAction(action);
            }

        } // end for

    } // end do search

    // main method
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
        int seed2 = Integer.parseInt(args[4]);

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
        
        double almc[][]= new double [10][2];
        double average[]=  new double[10];
        boolean check = false;

        // getting the initial state
        for (int s1 = 0; s1 < 10; s1++) {
            check = false;
            for (int s2 = 0; s2 < 10;) {
                
                State state = Utils.getProblemInstance(size, density, seed1+s1, agent);

                SimpleRandomSearch srs = new SimpleRandomSearch(state, seed2+s2, agent);
               
                srs.doSearch();
                
                
                if (srs.m_finalState != null) {
                    if (!check) {
                        check = !check;
                        almc[s1][0] = srs.m_cost;
                        almc[s1][1] = srs.m_cost;
                    }
                    
                    if (srs.m_cost < almc[s1][0]) {
                        almc[s1][0] = srs.m_cost;
                    }
                    
                    if (srs.m_cost > almc[s1][1]) {
                        almc[s1][1] = srs.m_cost; 
                    }
                    
                    average[s1] += srs.m_cost;
                    s2++;
                }
            }
            average[s1] /= 10;
        }
        
        System.out.println("Semilla\t Media\t Desviación Estándar");
        for (int s1 = 0; s1 < 10; s1++) {
            System.out.println( (seed1+s1) + "\t " + average[s1] + "\t " +" +-"+ ((almc[s1][1]-almc[s1][0])/2));
        }
        /*
        State state = Utils.getProblemInstance(size, density, seed1, agent);
        Utils.printBoard(state);

        SimpleRandomSearch srs = new SimpleRandomSearch(state, seed2);
        srs.doSearch();

        if (srs.m_finalState == null) {
            System.out.println("\nSorry, no solution found ....");
        } else {
            System.out.println("Solution length: " + srs.m_solution.size());
            System.out.println("Solution cost:   " + srs.m_cost);

            System.out.println("Solution:\n");
            for (int i = 0; i < srs.m_solution.size(); i++) {
                System.out.println((i + 1) + ": " + srs.m_solution.get(i));
            }

            Utils.printBoard(srs.m_finalState);
        }
        System.out.println();
        */
    }

}
