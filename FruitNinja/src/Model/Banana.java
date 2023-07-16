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
 * @author abdelrahman
 */
public class Banana extends Fruit{
    
    Random random = new Random();
    
    
    public Banana(){
        
        positionX = 100 +(int)random.nextDouble() * 400;
        positionY = 620;
        deltaY = 10;
        image = new ImageIcon("Banana.png");
        height = 400;
        imagewidth=50;
        imageheight=50;
        addscore = 1;
        
        
    }

    @Override
    public void slice() {
       sliced = true;
       image = new ImageIcon("Banana1.png");
    }
    
   @Override
  public GameObject makeCopy(){
      Fruit temp = new Banana();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }

    
}
