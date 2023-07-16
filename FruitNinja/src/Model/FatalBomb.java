/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author USER
 */
public class FatalBomb extends Bomb{
    Random random = new Random();
    
 public FatalBomb(){
        
        positionX = 100 + ((int)random.nextDouble() * 800);
        positionY = 620;
        deltaY = 12;
        image = new ImageIcon("Fatal.png");
        height = 300;
        imagewidth=50;
        imageheight=50;
        
        
    }
    
    
    @Override
    public void slice() {
     
        sliced = true;
    }
    
    @Override
  public GameObject makeCopy(){
      Bomb temp = new FatalBomb();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }
    
}
