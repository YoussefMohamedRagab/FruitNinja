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
public class Apple extends Fruit{

    Random random = new Random();
    
    
    public Apple(){
        
        positionX = 200 +(int)random.nextDouble() * 800;
        positionY = 620;
        deltaY = 5;
        image = new ImageIcon("Apple.png");
        height = 100;
        imagewidth=50;
        imageheight=50;
        addscore = 4;
        
        
    }
    
    
    
    @Override
    public void slice() {
        sliced = true;
        image = new ImageIcon("app.png");
    }
    @Override
  public GameObject makeCopy(){
      Fruit temp = new Apple();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }
    
}
