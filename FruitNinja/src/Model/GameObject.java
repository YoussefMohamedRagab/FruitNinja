/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author abdelrahman
 */
public interface GameObject {
    
 public int getXlocation();
 
 public void setpositionX(int x);
/*
*@return Y location of game object
*/
public int getYlocation();
/*
*@return max Y location that the object can reach on the screen
*/
public int getMaxHeight();
/*
*@return velocity at which game object is thrown
*/
public int getInitialVelocity();
/*
*@return failing velocity of game object
*/
public int getFallingVelocity();
/*
*@return whether the object is sliced or not
*/
public Boolean isclicked(int x , int y);
/*
*@return whether the object is dropped off the screen or not
*/
public Boolean hasMovedOffScreen();

/*
*it is used to slice the object
*/
public void slice();
/*
*it is used to move the object on the screen
@param deltaTime: time elapsed since the object is thrown
it is used calculate the new position of
fruit object.
*/
public void move();
/*
*@return at least two images of the object, one when it is
sliced and one when it is not.
*/
public ImageIcon getImageicon();
 
public int getimagewidth();
public int getimageheight();
public void moveup();
public void movedown();
public boolean isSliced();
public boolean getjump ();
public int addscore();
public void setdeltaY(int y);
public GameObject makeCopy();


    

    
}
