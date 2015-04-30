import greenfoot.*;

public class BaseEnemiga extends Mira
{
    private int r;
    private int s;
    private int band;
    public BaseEnemiga()
    {
        band=0;
    }
   
    public void act() 
    {
        if(Greenfoot.getRandomNumber(150)==5)
        {
            int r=Greenfoot.getRandomNumber(100);
            int s=Greenfoot.getRandomNumber(100);
            getWorld().addObject(new BuldierEnemigo(),getX()-r,getY()+s);
        }
    }
}