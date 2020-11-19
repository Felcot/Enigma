package practica1;

import java.util.ArrayList;

//this class implements the getPossibleActions for each type of piece
public class Piece {

    // members
    int m_color = -1;
    int m_type = -1;
    
    
   //Esto es una factoria de piezas, el cual es un patrón de diseño, en el cual, indicando qué pieza se desea, esta función se encarga de instanciarla.
    public static Piece newPiece(int m_agent){  
        Piece result =  null;
                result = m_agent == Utils.wBishop ? new Bishop(0): 
                         m_agent == Utils.bBishop ? new Bishop(1):
                         m_agent == Utils.wKing ? new King(0): 
                         m_agent == Utils.bKing ? new King(1):
                         m_agent == Utils.wPawn ? new Pawn(0): 
                         m_agent == Utils.bPawn ? new Pawn(1):
                         m_agent == Utils.wQueen ? new Queen(0): 
                         m_agent == Utils.bQueen ? new Queen(1):
                         m_agent == Utils.wRook ? new Rook(0): 
                         m_agent == Utils.bRook ? new Rook(1):
                         m_agent == Utils.wKnight ? new Knight(0): 
                         m_agent == Utils.bKnight ? new Knight(1):
                        result; 
                return result;
    }
    // this method must be overwritten by all the possible pieces
    public ArrayList<Action> getPossibleActions(State state) {

        return null; //never arrive here
    }
    public ArrayList<Action> actualizarListaAcciones(ArrayList<Action> lista, ArrayList<Action> acciones ){
        if(lista == null) lista= new ArrayList<Action>();
        for(Action a : acciones)
            if(a != null) lista.add(a);
        return lista;
    }
    // horizontal left moves
    public ArrayList<Action> getHorizontalLeftMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int c = c0 - 1; (c >= 0) && !busyCell; c--) {
            if (state.m_board[r0][c] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r0, c));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r0][c])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r0, c));
                    list.add(action);
                }
            }
        }

        return list;
    }

    // horizontal right moves
    public ArrayList<Action> getHorizontalRightMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int c = c0 + 1; (c < state.m_boardSize) && !busyCell; c++) {
            if (state.m_board[r0][c] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r0, c));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r0][c])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r0, c));
                    list.add(action);
                }
            }
        }

        return list;
    }

    // vertical down moves
    public ArrayList<Action> getVerticalDownMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int r = r0 + 1; (r < state.m_boardSize) && !busyCell; r++) {
            if (state.m_board[r][c0] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r, c0));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r][c0])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r, c0));
                    list.add(action);
                }
            }
        }

        return list;
    }

    // vertical up moves
    public ArrayList<Action> getVerticalUpMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int r = r0 - 1; (r >= 0) && !busyCell; r--) {
            if (state.m_board[r][c0] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r, c0));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r][c0])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r, c0));
                    list.add(action);
                }
            }
        }

        return list;
    }

}
