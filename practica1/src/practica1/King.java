/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Marco-Javier Gomez Martinez
 */
public class King extends Piece implements Moves {

    public ArrayList<Action> getHorizontalLeftMoves(State state) {
        int c, r;
        Position position = state.m_agentPos;
        c = position.col;
        r = position.row;

        int[][] board = state.m_board;

        int size = state.m_boardSize;
        if (r >= 0) {
            if (board[r + 1][c] == Utils.empty) {//standard pawn move
                return new ArrayList<Action>((Collection<? extends Action>) new Action(position, new Position(r + 1, c)));
            }
        }
        return null;
    }

    @Override
    public ArrayList<Action> getOblicuoDownLeft(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Action> getOblicuoUpLeft(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Action> getOblicuoDownRigth(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Action> getOblicuoUpRigth(State state) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
