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
public class WaterMelon extends Fruit{

    Random random = new Random();
    
    public WaterMelon(){
        
        positionX = 500 +(int)random.nextDouble() * 800;
        positionY = 620;
        deltaY = 7;
        image = new ImageIcon("WaterMelon.png");
        height = 250;
        imagewidth=50;
        imageheight=50;
        addscore = 5;
        
        
    }
    
    @Override
    public void slice() {
        
        sliced = true;
        image = new ImageIcon("melon11.png");
           
    }
    @Override
  public GameObject makeCopy(){
      Fruit temp = new WaterMelon();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }
    
}
