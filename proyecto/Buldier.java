import greenfoot.*;
public class Buldier extends Actor
{
    private int band;
    private int x;
    private int y;
    private int band2;
    public Buldier()
    {
        band=0;
        band2=0;
    }
    public void act() 
    {
        MouseInfo mouse=Greenfoot.getMouseInfo();
            
       if(Greenfoot.mouseClicked(this))
       {
           band=1;
       }
       if(band==1&&Greenfoot.mouseClicked(null))
       {
           x=mouse.getX();
           y=mouse.getY();
           band2=1;
           turnTowards(mouse.getX(),mouse.getY());
       }
       if(band2==1)
       {
            if(getX()>x-5&&getX()<x+5 || getY()>y-5&&getY()<y+5)
            band2=0;
            else
            move(20);
        }
       if(Greenfoot.isKeyDown("q"))
          band=0;
       if(band2==0&&Greenfoot.isKeyDown("c")&&band==1)
           getWorld().addObject(new Minibase(),getX(),getY());
       
    }
    
}
