import greenfoot.*;

public class Base extends Actor
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
            int r=Greenfoot.getRandomNumber(100);
            int s=Greenfoot.getRandomNumber(100);
            getWorld().addObject(new Buldier(),getX()-r,getY()+s);
        }
    }
}
  

