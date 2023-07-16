/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Bomb;
import Model.FatalBomb;
import Model.Fruit;
import Model.GameObject;
import Model.Kiwii;
import Model.ObjectFactory;
import Model.WaterMelon;
import View.GameFrame;
import View.GamePanel;
import jaco.mp3.player.MP3Player;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author USER
 */
public class Controller implements GameController{
    
    private ArrayList<GameObject> OnScreen = new ArrayList<>();
    private GameFrame frame;
    private GamePanel panel;
    private int score;
    private int lives;
    private int bestscore;
    private GameState state = new GameState();
    
    public Controller (){
        score =0;
        lives =3;
        
    }
    public static final String song1="splatter.mp3";
    MP3Player mp3s=new MP3Player(new File(song1));
    public static final String song="boom.mp3";
    MP3Player mp3boom=new MP3Player(new File(song));

    @Override
    public void createGameObjects(int n) {
        
        Random random = new Random();
        GameObject temp;
        ObjectFactory factory = new ObjectFactory();
        int lastdelta;
        int deltaX = (int)(random.nextDouble()*900);
        int obj = (int)(random.nextDouble()* 8);
        int lastobj =obj;
        lastdelta = deltaX;
        
        for(int i =0;i<n;i++){
       
            
            temp = factory.getobject(obj);
            if(temp instanceof Kiwii && OnScreen.size() == 0)
                continue;
            temp.setpositionX(deltaX);
            lastobj = obj;
            lastdelta = deltaX;
            obj = (int)(random.nextDouble()* 8);
            deltaX = (int)(random.nextDouble()*900);
            if(obj == lastobj)
                temp.setdeltaY(3);
            if(deltaX - lastdelta <= 20 || lastdelta - deltaX <= 20)
                deltaX = deltaX + 50;
            
            
            
            OnScreen.add(temp);
            
        }
        
        
    }

    @Override
    public ArrayList<GameObject> getobjects() {
            return OnScreen;
        }
    
    public void updateObjects(){
        
        Iterator<GameObject> iterator = OnScreen.iterator();
        
        while(iterator.hasNext()){
            
            GameObject object = iterator.next();
            if(object.hasMovedOffScreen())
                iterator.remove();          
            
        }       
        
    }

    @Override
    public void click(int posx,int posy) {
        
        Iterator<GameObject> iterator = OnScreen.iterator();
        
      while(iterator.hasNext()){
          GameObject temp = iterator.next();
          
        if(temp.isclicked(posx, posy)){
           
           if(temp.isSliced() == false){
               if(temp instanceof Kiwii){
                   iterator.remove();
                   SliceAll();
                                     
               }             
               else{
               temp.slice();
               mp3s.play();
               score = score + temp.addscore();
               max_score();
               }
               
           }
          
           if(temp instanceof Bomb )
           {
               if(temp instanceof FatalBomb)
               {
                   mp3boom.play();
                   panel.havelost();
               }
                mp3boom.play();
               panel.decrementlives();
               iterator.remove();
                        
           }
       }  
       
        
       panel.render();
    }
    }
    @Override
    public void resetgame(){
        
        OnScreen.clear();
        score =0;
        panel.setLives(3);
        
        
    }

    @Override
    public void setpanel(GamePanel panel) {
        this.panel = panel;
    }

    public int getScore() {
        return score;
    }

    public int getLives() {
        return lives;
    }
    
    public void setframe (GameFrame frame){
        this.frame = frame;
    }

    @Override
    public void savescore() {
        
        try {
           FileOutputStream fos = new FileOutputStream(new File("./scores.xml"));
           XMLEncoder encoder = new XMLEncoder(fos); 
           encoder.writeObject(bestscore);
           encoder.close();
           fos.close();
        
           }
          catch (FileNotFoundException ex) {
           ex.printStackTrace();
        
    }   catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void readbest() {
        try{
            
            FileInputStream fis = new FileInputStream(new File("./scores.xml"));
             XMLDecoder decoder = new XMLDecoder(fis);
                       
                
            bestscore  = (int) decoder.readObject();                         
            decoder.close();
            fis.close();
                       
        }     
         catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void newgame(int timespeed, int difficulty) {
        
        panel.setDifficulty(difficulty);
        panel.setTimespeed(timespeed);
                
    }

   @Override
   public void savegame(){
       
       state.createState(OnScreen, score, bestscore, lives, panel.getTime());
        try {
           FileOutputStream fos = new FileOutputStream(new File("./State.xml"));
           XMLEncoder encoder = new XMLEncoder(fos); 
           encoder.writeObject(state);
           encoder.close();
           fos.close();
        
           }
          catch (FileNotFoundException ex) {
           ex.printStackTrace();
        
    }   catch (IOException ex) {
            ex.printStackTrace();
        }
       
   }
   @Override
   public void loadgame(){
       
       
       try{         
            FileInputStream fis = new FileInputStream(new File("./State.xml"));
             XMLDecoder decoder = new XMLDecoder(fis);
                            
            state  = (GameState) decoder.readObject();                         
            decoder.close();
            fis.close();                     
        }     
         catch(IOException ex){
            ex.printStackTrace();
        }
       
     score = state.getScore();
     bestscore = state.getBest();
     lives = state.getLives();
     OnScreen = state.getOnScreen();
     panel.setTime(state.getTime());
       
   }
   
   public int getbestscore(){
       
       return bestscore;
   }
   
   public void max_score(){
       
       if(score > bestscore)
           bestscore = score;
       
       
   }
   
    public void SliceAll(){
       for(GameObject temp : OnScreen){
           
           if(temp instanceof Fruit){
               
               if(temp.isSliced() == false){
                   temp.slice();
                   mp3s.play();
                   score = score + temp.addscore();
                   max_score();
                   
               }
               
           }
                
       }
       
       
   }
    

}
