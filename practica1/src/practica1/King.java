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
    
    public King(int color) {
        super();
        m_color = color;

        if (color == 1) {
            m_type = Utils.wKing;
        } else {
            m_type = Utils.bKing;
        }
    }
    public ArrayList<Action> getPossibleActions(State state) {
        ArrayList<Action> list = null;
        
        list = this.actualizarListaAcciones(list,this.getVerticalDownMoves(state));
        list = this.actualizarListaAcciones(list,this.getOblicuoDownLeft(state));
        list = this.actualizarListaAcciones(list,this.getOblicuoDownRigth(state));
        list = this.actualizarListaAcciones(list,this.getHorizontalLeftMoves(state));
        list = this.actualizarListaAcciones(list,this.getHorizontalRightMoves(state));
        list = this.actualizarListaAcciones(list,this.getOblicuoUpLeft(state));
        list = this.actualizarListaAcciones(list,this.getOblicuoUpRigth(state));
        list = this.actualizarListaAcciones(list,this.getVerticalUpMoves(state));
        return list;
    }
    
    
    
    @Override
    public ArrayList<Action> getVerticalDownMoves(State state) {
        ArrayList <Action> result = new ArrayList();
        int c, r;
        int agentColor = this.m_color;
        Position position = state.m_agentPos;
        c = position.col;
        r = position.row;

        int[][] board = state.m_board;

        int size = state.m_boardSize;
            if ((r < state.m_boardSize) &&(board[r + 1][c] == Utils.empty ||(agentColor != Utils.getColorPiece(state.m_board[r+1][c])))) {//standard pawn move
                
                result.add( new Action(position, new Position(r + 1, c)));
            }
        return result;
    }
    
    @Override
    public ArrayList<Action> getVerticalUpMoves(State state) {
        ArrayList <Action> result = new ArrayList();
        int c, r;
        int agentColor = this.m_color;
        Position position = state.m_agentPos;
        c = position.col;
        r = position.row;

        int[][] board = state.m_board;

        int size = state.m_boardSize;
            if((r>0)&&(state.m_board[r - 1][c] == Utils.empty || (agentColor != Utils.getColorPiece(state.m_board[r-1][c])))){//standard pawn move
                result.add( new Action(position, new Position(r - 1, c)));
                
            }
        return result;
    }
    
    @Override
    public ArrayList<Action> getHorizontalRightMoves(State state) {
        int c, r;
        ArrayList <Action> result = new ArrayList();
        int agentColor = this.m_color;
        Position position = state.m_agentPos;
        c = position.col;
        r = position.row;

        int[][] board = state.m_board;

        int size = state.m_boardSize;
            if ((c+1 < state.m_boardSize) &&(board[r][c+1] == Utils.empty ||(agentColor != Utils.getColorPiece(state.m_board[r][c+1])))) {//standard pawn move
                result.add( new Action(position, new Position(r, c+1)));    
            }
            return result;
    }
    
    @Override
    public ArrayList<Action> getHorizontalLeftMoves(State state) {
        int c, r;
        ArrayList <Action> result = new ArrayList();
        int agentColor = this.m_color;
        Position position = state.m_agentPos;
        c = position.col;
        r = position.row;

        int[][] board = state.m_board;

        int size = state.m_boardSize;
            if((c-1>=0)&&(board[r][c-1] == Utils.empty || (agentColor != Utils.getColorPiece(state.m_board[r][c-1])))){//standard pawn move
                
                result.add( new Action(position, new Position(r, c-1)));
                
            }
        return result;
    }
    
    
    @Override
    public ArrayList<Action> getOblicuoDownLeft(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        if (((c0 - 1) >=0 && (r0+1)<state.m_boardSize) && ((state.m_board[r0 + 1][c0 - 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 + 1][c0 - 1])))) {
                action = new Action(state.m_agentPos, new Position(r0+1, c0-1));
            }
        list.add(action);
        return list;
    }

    @Override
    public ArrayList<Action> getOblicuoUpLeft(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        if (((c0 - 1) >=0 && (r0-1)>= 0) && ((state.m_board[r0 - 1][c0 - 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 - 1][c0 - 1])))) {
                action = new Action(state.m_agentPos, new Position(r0-1, c0-1));
            }
        list.add(action);
        return list;
    }

    @Override
    public ArrayList<Action> getOblicuoDownRigth(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        if (((c0 + 1) <state.m_boardSize && (r0+1)<state.m_boardSize) && ((state.m_board[r0 + 1][c0 + 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 + 1][c0 + 1])))) {
                action = new Action(state.m_agentPos, new Position(r0+1, c0+1));
            }
        list.add(action);
        return list;
    }

    @Override
    public ArrayList<Action> getOblicuoUpRigth(State state) {
        ArrayList<Action> list = new ArrayList<Action>(10);
        int agentColor = this.m_color;

        int c0, r0;
        c0 = state.m_agentPos.col;
        r0 = state.m_agentPos.row;
        Action action = null;

        if (((r0 - 1) >=0 && (c0+1)<state.m_boardSize) && ((state.m_board[r0 - 1][c0 + 1] == Utils.empty) || (agentColor != Utils.getColorPiece(state.m_board[r0 - 1][c0 + 1])))) {
                action = new Action(state.m_agentPos, new Position(r0-1, c0+1));
            }
        list.add(action);
        return list;
    }

}
