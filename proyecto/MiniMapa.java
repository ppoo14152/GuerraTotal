import greenfoot.*;

public class MiniMapa extends Actor
{
    
    public void act() 
    {
       getWorld().addObject(new Localizacion(),660+getX()/10,10+getY()/10);
    }    
}
