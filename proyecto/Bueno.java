import greenfoot.*;

public class Bueno extends MiniMapa
{
    private Buldier bul;
    private int x;
    private int y;
    private int band;
    public Bueno()
    {
        bul=new Buldier();
        band=0;
    }
    public void act() 
    {
        /*MouseInfo m= Greenfoot.getMouseInfo();
        turnTowards(m.getX(),m.getY());
        if(Greenfoot.mouseClicked(null))
        {
            x=m.getX();
            y=m.getY();
        
        if((getX()>(x/10)-5&&getX()<(x/10)+5) && (getX()>(x/10)-5&&getX()<(x/10)+5))
         band=1;
        else
          move(20);
        }
       //move(20);*/
    }
}
