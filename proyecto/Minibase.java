import greenfoot.*;

public class Minibase extends Actor
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
           /* band=1;
        }
        if(band==1)
        {*/
            //drawRect(100,300,200,400);
            //fillRect(100,300,200,400);
            int r=Greenfoot.getRandomNumber(100);
            int s=Greenfoot.getRandomNumber(100);
            getWorld().addObject(new Guerreros(),getX()-r,getY()+s);
        }
    }
}
  

