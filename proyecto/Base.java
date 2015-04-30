import greenfoot.*;

public class Base extends Mira
{
    private int r;
    private int s;
    private int band;
    public Base()
    {
        band=0;
    }
   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new Selecciones(),getX(),getY());
        }
    }
    
}
  

