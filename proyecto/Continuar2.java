import greenfoot.*;
/**
 * Permite seguir al tercer nivel al seleccionarla
 */


public class Continuar2 extends Actor
{
    private World w;
    public Continuar2()
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
            w=new Mapa3();
            Greenfoot.setWorld(w);
        } 
    }


}