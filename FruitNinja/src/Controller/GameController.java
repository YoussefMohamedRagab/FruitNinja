/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameObject;
import View.GameFrame;
import View.GamePanel;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public interface GameController {
    
    /*
*@return created game object
*/
public void createGameObjects(int n);
public ArrayList<GameObject> getobjects ();
public void updateObjects();
public void click(int posx,int posy);
public void setpanel (GamePanel panel);
public int getScore();
public int getLives();
public void setframe (GameFrame frame);
public void resetgame ();
public void savescore();
public void readbest();
public void newgame(int timespeed , int difficulty);
public void savegame();
public int getbestscore();
public void loadgame();
    
}
