/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author boda
 */
public class Kiwii extends Fruit {
  Random random = new Random();
  private static Kiwii kiwi;
  
    private Kiwii(){
        
        positionX = 450 +(int)random.nextDouble() * 800;
        positionY = 620;
        deltaY = 9;
        image = new ImageIcon("kiwi1.png");
        height = 350;
        imagewidth=50;
        imageheight=50;
        addscore = 5;
        
        
    }
    
    
    public static Kiwii getkiwi (){
        
        if(kiwi == null)
            kiwi = new Kiwii();
        
        return kiwi;
        
    }
    
    
    @Override
    public void slice() {
        sliced = true;
        image = new ImageIcon("half.png");
    }
    
    @Override
  public GameObject makeCopy(){
      Fruit temp = new Kiwii();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }
    
}
