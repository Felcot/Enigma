/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.ArrayList;

/**
 *
 * @author Marco-Javier Gomez Martinez
 */
public class Bishop extends Piece {

    public Bishop(int color) {
        super();
        m_color = color;

        if (color == 1) {
            m_type = Utils.wBishop;
        } else {
            m_type = Utils.bBishop;
        }
    }

    @Override
    public ArrayList<Action> getPossibleActions(State state) {
        ArrayList<Action> list = null;

        list = this.getOblicuoDownLeft(state);
        list.addAll(this.getOblicuoDownRigth(state));
        list.addAll(this.getOblicuoUpLeft(state));
        list.addAll(this.getOblicuoUpRigth(state));

        return list;
    }

    public ArrayList<Action> getOblicuoDownLeft(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int c = c0-1, r = r0+1; (c >= 0) && (r < state.m_boardSize) && !busyCell; c--, r++) {
            if (state.m_board[r][c] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r, c));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r][c])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r, c));
                    list.add(action);
                }
            }
        }
        return list;
    }

    public ArrayList<Action> getOblicuoUpLeft(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int c = c0 - 1, r = r0 - 1; (c >= 0) && (r >= 0) && !busyCell; c--, r--) {
            if (state.m_board[r][c] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r, c));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r][c])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r, c));
                    list.add(action);
                }
            }
        }
        return list;
    }

    public ArrayList<Action> getOblicuoDownRigth(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int c = c0 + 1, r = r0 + 1; (c < state.m_boardSize) && (r < state.m_boardSize) && !busyCell; c++, r++) {
            if (state.m_board[r][c] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r, c));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r][c])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r, c));
                    list.add(action);
                }
            }
        }
        return list;
    }

    public ArrayList<Action> getOblicuoUpRigth(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        Boolean busyCell = false;
        for (int c = c0 + 1, r = r0 - 1; (c < state.m_boardSize) && (r >= 0) && !busyCell; c++, r--) {
            if (state.m_board[r][c] == Utils.empty) {//add action
                action = new Action(state.m_agentPos, new Position(r, c));
                list.add(action);
            } else {
                busyCell = true;
                if (agentColor != Utils.getColorPiece(state.m_board[r][c])) { // capture piece
                    action = new Action(state.m_agentPos, new Position(r, c));
                    list.add(action);
                }
            }
        }
        return list;
    }
}
