import greenfoot.*;
/**
 * Permite seguir al segundo nivel al seleccionarla
 */

public class Continuar extends Actor
{
    private World w;
    public Continuar()
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
            w=new Mapa2();
            Greenfoot.setWorld(w);
        } 
    }


}
