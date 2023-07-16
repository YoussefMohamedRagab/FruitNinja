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
public class NormalMode implements GameMode{
    
    private GamePanel panel ;
    
     public void setPanel(GamePanel panel) {
        this.panel = panel;
    }
    
    
    @Override
    public void UpdateTime() {
        panel.setTime(panel.getTime() + ((float)panel.getTimespeed()/10000));
    }

    @Override
    public boolean GameOver() {
        if(panel.getLives() <= 0)
            return true;
        
        return false;
    }

    @Override
    public boolean HaveLives() {
        return true;
    }
    
}
