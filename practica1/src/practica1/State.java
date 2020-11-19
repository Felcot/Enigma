package practica1;

// This class contains the information needed to represent a state 

import java.util.Comparator;

// and some useful methods
public class State {

    int[][] m_board = null;
    Position m_agentPos = null;
    int m_agent = -1; // the type of piece
    int m_color = 0; // 0 for white, 1 for black
    int m_boardSize = -1;
    private State father = null;
    private Action arrival;
    String name;
    
    // constructor
    State(int[][] board, Position pos, int a){
        m_board = board;
        m_agentPos = pos;
        m_agent = a;
        
        if (m_agent > 11) {
            System.out.println("\n*** Invalid piece ***\n");
            System.exit(0);
        } else if (m_agent > 5) {
            m_color = 1; // black
        }
        m_boardSize = board[0].length;
        this.name =  m_agentPos.toString();
    }

    // compares if the current state is final, i.e. the agent is in the last row
    public boolean isFinal() {
        if (this.m_agentPos.row == this.m_boardSize - 1) {
            return true;
        } else {
            return false;
        }
    }

    // hard copy of an State
    public State copy() {
        int[][] cBoard = new int[this.m_boardSize][this.m_boardSize];

        for (int r = 0; r < this.m_boardSize; r++) {
            for (int c = 0; c < this.m_boardSize; c++) {
                cBoard[r][c] = this.m_board[r][c];
            }
        }

        return new State(cBoard, this.m_agentPos.copy(), m_agent);
    }

    // apply a given action over the current state -which remains unmodified. Return a new state
    public State applyAction(Action action) {
        State newState = this.copy();
        newState.m_board[action.m_initPos.row][action.m_initPos.col] = Utils.empty;
        newState.m_board[action.m_finalPos.row][action.m_finalPos.col] = newState.m_agent;
        newState.m_agentPos = action.m_finalPos;
        newState.setFather(this);
        newState.setArrival(action);
        newState.setName();
        return newState;
    }
    public void setFather(State father){
        this.father =father;
    }
    public State getFather(){
        return this.father;
    }
    public void setArrival(Action action){
        this.arrival = action;
    }
    public Action getArrival(){
        return this.arrival;
    }
    
    public double getCost(){
        State father = this.getFather();
        if(father != null)
            return father.getCost() + this.getArrival().getCost();
        return 0;
    }
    
    public String getWay(){
        State father = this.getFather();
        if(father != null)
            return father.getWay() + this.getArrival().toString();
        return "";
    }
    public int getLongitud(){
        State father = this.getFather();
        if(father != null)
            return father.getLongitud() + 1;
        return 0;
    }
    public String getName(){
        return this.name;
    }
    public void setName(){
        this.name =  this.m_agentPos.toString();
    }
    public int getHeuristic(){ 
        /* Se considera que la mejor heuristica es la que viene definida por las
           filas que faltan hasta llegar a una posible solución en linea recta*/
        return this.m_boardSize - this.m_agentPos.row - 1;
    }
    public double getHeuristicSumCost(){
        return this.getCost() + this.getHeuristic();
    }
    
    /*
     * Permite la comparación de coste para ordenar una priorityQueue en relacion al coste
     */
    public static class ComparatorCost implements Comparator<State>{

        @Override
        public int compare(State a, State b) {
            if(a.getCost()<b.getCost()) return -11;
            if(a.getCost()>b.getCost()) return 1;
            return 0;
        }  
    }
    /*
     * Permite la comparación de coste para ordenar una priorityQueue en relacion a la Heuristica
     */
    public static class ComparatorHeuristic implements Comparator<State>{

        @Override
        public int compare(State a, State b) {
            if(a.getHeuristic()<b.getHeuristic()) return -1;
            if(a.getHeuristic()>b.getHeuristic()) return 1;
            return 0;
        }  
    }
    
    /*
     * Permite la comparación de coste para ordenar una priorityQueue en relacion a la heuristica + coste
     */
    public static class ComparatorAStar implements Comparator<State>{

        @Override
        public int compare(State a, State b) { // f(n) = h(n) + c(n);
            if(a.getHeuristicSumCost()<b.getHeuristicSumCost()) return -1;
            if(a.getHeuristicSumCost()>b.getHeuristicSumCost()) return 1;
            return 0;
        }  
    }
}
