package practica1;

import java.util.ArrayList;

//this class implements the getPossibleActions for each type of piece
public class Pawn extends Piece {

    // constructor
    public Pawn(int color) {
        m_color = color;

        if (color == 1) {
            m_type = Utils.wPawn;
        } else {
            m_type = Utils.bPawn;
        }

    }

    // this method must be completed with all the possible pieces
    public ArrayList<Action> getPossibleActions(State state) {

        int c, r;
        Position position = state.m_agentPos;
        c = position.col;
        r = position.row;

        int[][] board = state.m_board;

        int size = state.m_boardSize;

        ArrayList<Action> list = new ArrayList<Action>(3);

        if (m_color == 1) {//black pawn. Since pieces spawn on the top, it shouldn't be able to solve the problem
            return list;
        }
        
        if (m_color == 0 && (r+1<=(size -1))){
            if(r == 0 && (board[r+2][c] == Utils.empty)){
                list.add(new Action(position, new Position(r + 2, c)));
            }
            if(board[r+1][c] == Utils.empty){
                list.add(new Action(position, new Position(r + 1, c)));
            }
            if((c-1 >= 0) && (board[r + 1][c - 1] != Utils.empty) && (Utils.getColorPiece(board[r + 1][c - 1]) != m_color)){
                
                list.add(new Action(position, new Position(r + 1, c-1)));
            }
            if((c+1 < size) && (board[r + 1][c + 1] != Utils.empty) && (Utils.getColorPiece(board[r + 1][c + 1]) != m_color)){
                list.add(new Action(position, new Position(r + 1, c+1)));
            }
        }

        return list;
    }

}