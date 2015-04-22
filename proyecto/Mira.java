import greenfoot.*;
public class Mira extends Actor
{
    private int band;
    public Mira()
    {
        band=0;
    }
    
    public void act() 
    {
        if(Greenfoot.mouseMoved(null))
        {
            MouseInfo mouse=Greenfoot.getMouseInfo();
            setLocation(mouse.getX(),mouse.getY());
        }
        if(isAtEdge()&&getX()>600)
        {
            Greenfoot.setWorld(new Mapa1());
        }
        if(isAtEdge()&&getX()<1)//bandera para evitar que se regrese en el mismo mapa
        {
            Greenfoot.setWorld(new Mapa());
            band=1;
        }
        
    }  
    
    
}
