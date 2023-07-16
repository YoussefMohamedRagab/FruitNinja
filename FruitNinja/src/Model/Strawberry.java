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
public class Strawberry extends Fruit{

    Random random = new Random();
      public Strawberry(){
        
        positionX = 400 +(int)random.nextDouble() * 800;
        positionY = 620;
        deltaY = 8;
        image = new ImageIcon("Strawberry.png");
        height = 500;
        imagewidth=50;
        imageheight=50;
        addscore = 1;
        
        
    }
    
    
    
    @Override
    public void slice() {
        sliced = true;
        image = new ImageIcon("Straw1.png");
    }
    @Override
  public GameObject makeCopy(){
      Fruit temp = new Strawberry();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }
    
}
