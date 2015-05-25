import greenfoot.*;
/**
 * Hace que regresemos al menu principal
 */

public class Back extends Actor
{
    private World w;
    public Back()
    {
        
        w=getWorld();
    }
    
    public void act() 
    {
        otroMundo();
    }  
   
    public void otroMundo()
    {
        if(Greenfoot.mouseClicked(this))
        {
            w=new Menu();
            Greenfoot.setWorld(w);
        } 
    }


}