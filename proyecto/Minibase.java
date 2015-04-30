import greenfoot.*;

public class Minibase extends Base
{
    private int r;
    private int s;
    private int band;
    public Minibase()
    {
        band=0;
    }
   
    public void act() 
    {
        
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().addObject(new MiniSelecciones(),getX(),getY());
        }
        removeTouching(Buldier.class);
    }
}
  

