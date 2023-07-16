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
public class DangerousBomb extends Bomb {

     Random random = new Random();
    
    public DangerousBomb(){
        
        positionX = 550+(int)random.nextDouble() * 800;
        positionY = 620;
        deltaY = 8;
        image = new ImageIcon("boom.png");
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
      Bomb temp = new DangerousBomb();
      temp.firstjump = this.firstjump;
      temp.image = this.image;
      temp.movedown = this.movedown;
      temp.moveup = this.moveup;
      temp.positionX = this.positionX;
      temp.positionY = this.positionY;
      
      return temp;
  }
}
