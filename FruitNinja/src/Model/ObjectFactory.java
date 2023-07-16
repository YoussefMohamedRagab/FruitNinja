/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USER
 */
public class ObjectFactory {
  
    private Kiwii kiw = Kiwii.getkiwi();
    
    public GameObject getobject(int x){
        
        
        switch (x) {
            case 0:
                return new Banana();
            case 1:
                return kiw;
            case 2:
                return new Peach();
            case 3:
                return new WaterMelon();
            case 4:
                return new Strawberry();
            case 5:
                return new DangerousBomb();
            case 6:
                return new FatalBomb();
            case 7:
                return new Apple();
                
            default:
                return null;
        }
        
        
    } 
    
}
