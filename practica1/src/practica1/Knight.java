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
public class Knight extends Piece{
    public Knight(int color) {
        super();
        m_color = color;

        if (color == 1) {
            m_type = Utils.wKnight;
        } else {
            m_type = Utils.bKnight;
        }
    }
    @Override
    public ArrayList<Action> getPossibleActions(State state) {
        ArrayList<Action> list = null;
        
        list = this.actualizarListaAcciones(list,this.getVerticalDownMoves(state));
        list = this.actualizarListaAcciones(list,this.getHorizontalLeftMoves(state));
        list = this.actualizarListaAcciones(list,this.getHorizontalRightMoves(state));
        list = this.actualizarListaAcciones(list,this.getVerticalUpMoves(state));
        
        return list;
    }

    //Si el caballo está en una fila (p.e. 2), y no está en la columna 0, se incluye el movimiento que se realiza con la linea 47.
    @Override
    public ArrayList<Action> getVerticalUpMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;
        if (((c0 - 1) >=0 && (r0-2)>=0) && ((state.m_board[r0 -2][c0 - 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 - 2][c0 - 1])))) { //if arriba izq
                action = new Action(state.m_agentPos, new Position(r0-2, c0-1));
                list.add(action);
        }
        if (((c0 + 1) < state.m_boardSize && (r0-2)>=0) && ((state.m_board[r0 -2][c0 + 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 - 2][c0 + 1])))) { //if arriba der
                action = new Action(state.m_agentPos, new Position(r0-2, c0+1));
                list.add(action);
        }
        
        return list;
    }

    @Override
    public ArrayList<Action> getVerticalDownMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;
        if (((c0 - 1) >=0 && (r0+2)<state.m_boardSize) && ((state.m_board[r0 +2][c0 - 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 + 2][c0 - 1])))) {
                action = new Action(state.m_agentPos, new Position(r0+2, c0-1));
                list.add(action);
            }
        if (((c0 + 1) <state.m_boardSize && (r0+2)<state.m_boardSize) && ((state.m_board[r0 +2][c0 + 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 + 2][c0 + 1])))) {
                action = new Action(state.m_agentPos, new Position(r0+2, c0+1));
                list.add(action);
            }
        return list;
    }

    @Override
    public ArrayList<Action> getHorizontalRightMoves(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;
        if (((r0 - 1) >=0 && (c0+2)<state.m_boardSize) && ((state.m_board[r0 -1][c0 + 2] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 -1][c0 + 2])))) {
                action = new Action(state.m_agentPos, new Position(r0-1, c0+2));
                list.add(action);
            }
        if (((r0 + 1) <state.m_boardSize && (c0+2)<state.m_boardSize) && ((state.m_board[r0 +1][c0 + 2] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 + 1][c0 + 2])))) {
                action = new Action(state.m_agentPos, new Position(r0 +1, c0 +2));
                list.add(action);
            }
        return list;
    }

    @Override
    public ArrayList<Action> getHorizontalLeftMoves(State state) {
         ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;
        if (((r0 - 1) >=0 && (c0-2)>=0) && ((state.m_board[r0 -1][c0 - 2] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 -1][c0 - 2])))) {
                action = new Action(state.m_agentPos, new Position(r0-1, c0-2));
                list.add(action);
            }
        if (((r0 + 1) <state.m_boardSize && (c0-2)>=0) && ((state.m_board[r0 +1][c0 - 2] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 + 1][c0 - 2])))) {
                action = new Action(state.m_agentPos, new Position(r0 + 1, c0 - 2));
                list.add(action);
            }
        return list;
    }

}
