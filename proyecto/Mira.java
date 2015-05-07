import greenfoot.*;
public class Mira extends ScrollActor
{
    private int band;
    private int limX;
    private int limY;
    private int limX2;
    private int limY2;
    private static final int MOVE_AMOUNT = 30;
    public Mira()
    {
        band=0;
        limX=150;
        limY=150;
        limX2=650;
        limY2=450;
    }

    public void act()
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if (m != null) 
        {
            turnTowards(m.getX(), m.getY());
            getWorld().setCameraDirection(getRotation());
            setLocation(m.getX(),m.getY());
        }
   
        if(Greenfoot.mouseMoved(null)&&limX2<m.getX()) 
        {

            getWorld().moveCamera(MOVE_AMOUNT);
            limX2+=5;

        }else
        if(Greenfoot.mouseMoved(null)&&limX>m.getX()) 
        {

            getWorld().moveCamera(MOVE_AMOUNT);
            limX-=5;

        }else
        if(Greenfoot.mouseMoved(null)&&limY2<m.getY()) 
        {
            getWorld().moveCamera(MOVE_AMOUNT);
            limY+=5;
        }else
        if(Greenfoot.mouseMoved(null)&&limY>m.getY()) 
        {
            getWorld().moveCamera(MOVE_AMOUNT);
            limY-=5;
        }
    }
   

}
