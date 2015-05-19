import greenfoot.*;
/**
 * Al momento de seleccionarlo te manda a ver los records del juego
 */

public class Records extends Actor
{
    private World w;
    public Records()
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
            w=new Marcador();
            Greenfoot.setWorld(w);
        } 
    }


}