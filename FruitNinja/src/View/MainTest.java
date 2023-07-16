/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Random;

/**
 *
 * @author USER
 */
public class MainTest {
    
    public static void main (String args[]){
        
        Random r = new Random();
        
        for(int i=0;i<5;i++){
        System.out.println((int) (r.nextDouble()*5) );
    }
    }
    
}
