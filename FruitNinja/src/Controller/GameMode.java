/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.GamePanel;

/**
 *
 * @author USER
 */
public interface GameMode {
    
    
    public void UpdateTime();
    public void setPanel(GamePanel panel);
    public boolean GameOver(); 
    public boolean HaveLives();
}
