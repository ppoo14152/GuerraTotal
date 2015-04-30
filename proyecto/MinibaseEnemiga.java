import greenfoot.*;

public class MinibaseEnemiga extends BaseEnemiga
{
    private int r;
    private int s;
    private int band;
    public MinibaseEnemiga()
    {
        band=0;
    }
   
    public void act() 
    {
        if(Greenfoot.getRandomNumber(300)==2)
        {
            int r=Greenfoot.getRandomNumber(100);
            int s=Greenfoot.getRandomNumber(100);
            getWorld().addObject(new Enemigo(),getX()-r,getY()+s);
        }
    }
}