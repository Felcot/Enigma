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

        // white pawn
        if (m_color == 0) {// white pawn  // No puede subir

            if (r < (size - 1)) {
                if (board[r + 1][c] == Utils.empty) {//standard pawn move
                    list.add(new Action(position, new Position(r + 1, c)));
                }

                if ((c > 0) && (board[r + 1][c - 1] != Utils.empty)
                        && (Utils.getColorPiece(board[r + 1][c - 1]) == 1)) {//capture
                    list.add(new Action(position, new Position(r + 1, c - 1)));
                }

                if ((c < (size - 1)) && (board[r + 1][c + 1] != Utils.empty)
                        && (Utils.getColorPiece(board[r + 1][c + 1]) == 1)) {//capture
                    list.add(new Action(position, new Position(r + 1, c + 1)));
                }
            }

            if ((r == 1) && (board[r + 1][c] == Utils.empty) && (board[r + 2][c] == Utils.empty)) {//starting pawn move
                list.add(new Action(position, new Position(r + 2, c)));
            }

        }

        // black pawn
        if (m_color == 0) {// white pawn

            if (r > 0) {
                if (board[r - 1][c] == Utils.empty) {//standard pawn move
                    list.add(new Action(position, new Position(r - 1, c)));
                }

                if ((c > 0) && (board[r - 1][c - 1] != Utils.empty)
                        && (Utils.getColorPiece(board[r - 1][c - 1]) == 1)) {//capture
                    list.add(new Action(position, new Position(r - 1, c - 1)));
                }

                if ((c < (size - 1)) && (board[r - 1][c + 1] != Utils.empty)
                        && (Utils.getColorPiece(board[r - 1][c + 1]) == 1)) {//capture
                    list.add(new Action(position, new Position(r - 1, c + 1)));
                }
            }

            if ((r == (size - 2)) && (board[r - 1][c] == Utils.empty) && (board[r - 2][c] == Utils.empty)) {//starting pawn move
                list.add(new Action(position, new Position(r - 2, c)));

            }

        }

        return list;
    }

}
