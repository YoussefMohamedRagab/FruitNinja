/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.ImageIcon;

/**
 *
 * @author abdelrahman
 */
public abstract class Fruit implements GameObject{
    
    int addscore;
    int positionX;
    int positionY;
    int imagewidth;
    int height;
    int imageheight;
    int deltaY;
    ImageIcon image ;
    boolean moveup = false;
    boolean movedown = false;
    boolean sliced = false;
    boolean firstjump = true;
    
  
    @Override
    public int getXlocation() {
      return positionX;
    }

    @Override
    public int getYlocation() {
        return positionY;
    }

    @Override
    public int getMaxHeight() {
        
        return height;  
    }
    @Override
    public void setpositionX(int x){
        
        positionX = x;
        
    }

    @Override
    public int getInitialVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getFallingVelocity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isclicked(int x , int y) {
        if(x >= positionX && x <= positionX+imagewidth)
            if(y >= positionY && y <= positionY+imageheight){
             //   sliced = true;
                return true;
                
            }
        
        return false;
    }

    @Override
    public Boolean hasMovedOffScreen() {
        if(positionY <= 0)
            return true;
        return false;
    }

    @Override
    public abstract void slice();

    @Override
    public void move() {
       
        if(positionY >= 620){
            moveup = true;
        }
          
        if(moveup == true){
                       
                positionY = positionY -deltaY; 
        }
    }

    @Override
    public ImageIcon getImageicon() {
        return image;
    }
    
public int getimagewidth(){
    return imagewidth;
}
public int getimageheight(){
    
    return imageheight;
}

public void moveup(){
    moveup = true;
    
}
  public void movedown(){
      
      movedown = true;
  }  
  
  public boolean isSliced(){
      
      return sliced;
  }
    
  public boolean getjump(){
      return firstjump;
  }
  public int addscore(){
      
      return addscore;
  }
  public void setdeltaY(int y){
      deltaY = deltaY +y;
  }

    public void setAddscore(int addscore) {
        this.addscore = addscore;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public void setImagewidth(int imagewidth) {
        this.imagewidth = imagewidth;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setImageheight(int imageheight) {
        this.imageheight = imageheight;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public void setMoveup(boolean moveup) {
        this.moveup = moveup;
    }

    public void setMovedown(boolean movedown) {
        this.movedown = movedown;
    }

    public void setSliced(boolean sliced) {
        this.sliced = sliced;
    }

    public void setFirstjump(boolean firstjump) {
        this.firstjump = firstjump;
    }
  
  
}
