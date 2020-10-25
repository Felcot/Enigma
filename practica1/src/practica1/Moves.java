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
public interface Moves {

    public ArrayList<Action> getOblicuoDownLeft(State state);

    public ArrayList<Action> getOblicuoUpLeft(State state);

    public ArrayList<Action> getOblicuoDownRigth(State state);

    public ArrayList<Action> getOblicuoUpRigth(State state);

}
