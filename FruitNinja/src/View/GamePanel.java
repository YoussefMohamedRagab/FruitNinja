/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameController;
import Controller.GameMode;
import Model.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.animation.TranslateTransition;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author abdelrahman
 */
public class GamePanel extends JPanel implements ActionListener{
  private GameFrame frame;
  private GameController controller;
  private Random random = new Random();
  private GameMode mode;

    Timer t;
    
    private int score;
    private int lives;
    private float time;
    private int timespeed;
    private int difficulty;   
    private boolean lifeout1 = false;
    private boolean lifeout2 = false;
    private boolean lifeout3 = false;
    ArrayList<GameObject> onscreen = new ArrayList<>();
    Iterator<GameObject> iterator = onscreen.iterator();
    
    
    
    int posx;
    int posy;
    
    public GamePanel(){
        
        timespeed = 50;
        difficulty =5;
        t = new Timer(timespeed, this);
        score = 0;
        lives = 3;
        time = 0;
        t.start();
        
    }

    public void setMode(GameMode mode) {
        this.mode = mode;
    }
    
    
    
     @Override
    protected void paintComponent(Graphics g) {
        
      UpdateLives();
      
        if(isScreenEmpty())
            controller.createGameObjects((int) (random.nextDouble()*difficulty));
        
        
        controller.updateObjects();
       
        super.paintComponent(g);
        
       mode.UpdateTime();
  
  
        frame.setscorelabel(score);
        frame.settimerlabel(time);
        
        
    ImageIcon im = new ImageIcon("Background.png");
    g.drawImage(im.getImage(), 0, 0,1000,640, this);
    ImageIcon scoreim = new ImageIcon("score.png");
    g.drawImage(scoreim.getImage(), 0, 0, this);
    
   if(mode.HaveLives()){
    ImageIcon life1 = new ImageIcon("x.png");
    ImageIcon life2 = new ImageIcon("xx.png");
    ImageIcon life3 = new ImageIcon("xxx.png");
    
         
    if(lifeout1 == false){
        life1 = new ImageIcon("x.png");
    }else
        life1= new ImageIcon("xf.png");
    
    if(lifeout2 == false){
        life2 = new ImageIcon("xx.png");
    }else
        life2= new ImageIcon("xxf.png");
    
    if(lifeout3 == false){
        life3 = new ImageIcon("xxx.png");
    }else
        life3= new ImageIcon("xxxf.png");
    
     
    g.drawImage(life1.getImage(), 890, 0, this);
    g.drawImage(life2.getImage(), 920, 0, this);
    g.drawImage(life3.getImage(),950, 0, this);
    }

    for(GameObject temp :onscreen){
        
        g.drawImage(temp.getImageicon().getImage(), temp.getXlocation(),temp.getYlocation(),temp.getimagewidth() , temp.getimageheight(), this);
        
    }

    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(mode.GameOver())
            frame.lost();
 
 
   for(GameObject temp : onscreen){
       temp.move();
       
       if(temp.hasMovedOffScreen() && temp.isSliced()== false && temp instanceof Fruit) {
            decrementlives();
       }   
 
   }      
        repaint();    
    }

    public void setFrame(GameFrame frame) {
        this.frame = frame;
    }

    public void setController(GameController controller) {
        this.controller = controller;
    }
    
    public void render(){
        
        onscreen = controller.getobjects();
        score = controller.getScore();
        
    }
    
    public boolean isScreenEmpty(){
        
        if(onscreen.size() ==0)
            return true;
        
        return false;
        
    }
    public void UpdateLives(){
        
            
           if(lives ==2)
               lifeout1 = true;
           if(lives ==1)
               lifeout2 = true;
           if(lives <=0)
               lifeout3 = true;
        
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }
    
    public void decrementlives(){
        lives --;
        if(lives ==2)
               lifeout1 = true;
           if(lives ==1)
               lifeout2 = true;
           if(lives <=0)
               lifeout3 = true;
    }
    
    public void havelost(){
        
        lives =0;
        lifeout1 = true;
        lifeout2 = true;
        lifeout3 = true;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    
    public void resetgame(){
        
        score = 0;
        lives = 3;
        time = 0;
        lifeout1 = false;
        lifeout2 = false;
        lifeout3 = false;
        
    }
    
    public void stoprendering(){    
        t.stop();
          
    }

    public void setTimespeed(int timespeed) {
        this.timespeed = timespeed;
        t.setDelay(this.timespeed);
    
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public float getTime() {
        return time;
    }
    

    public void setTime(float time) {
        this.time = time;
    }

    public void settime (float x){
        
        time = x;
        
    }

    public int getTimespeed() {
        return timespeed;
    }
    
    public int getdelay(){
        
       return t.getDelay();
           
    }
     
    
}
