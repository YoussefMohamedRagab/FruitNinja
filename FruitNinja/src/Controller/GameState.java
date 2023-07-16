/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GameObject;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class GameState {
    
    private ArrayList<GameObject> onScreen = new ArrayList<>();
    private int score;
    private int best;
    private int lives;
    private float time;

  
   public void createState(ArrayList<GameObject> screen,int score, int best, int lives, float time){
       
       GameObject c;
       for(GameObject temp : screen){           
           c=temp.makeCopy();
           onScreen.add(c);
       }
        this.score = score;
        this.best = best;
        this.lives = lives;
        this.time = time;
   }

    public ArrayList<GameObject> getOnScreen() {
        return onScreen;
    }

    public int getScore() {
        return score;
    }

    public int getBest() {
        return best;
    }

    public int getLives() {
        return lives;
    }

    public float getTime() {
        return time;
    }

    public void setOnScreen(ArrayList<GameObject> onScreen) {
        this.onScreen = onScreen;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setBest(int best) {
        this.best = best;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
    
    
    
    
}
