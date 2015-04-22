import greenfoot.*;
public class Enemigo extends Actor
{
    private int x;
    private int y;
    private int a;
    
    public Enemigo()
    {
        x=Greenfoot.getRandomNumber(800);
        y=Greenfoot.getRandomNumber(600);
        a=Greenfoot.getRandomNumber(360);
    }
    
    public void act() 
    {
        if(Greenfoot.getRandomNumber(4)==2)
        {
            move(30);
        }
        if(Greenfoot.getRandomNumber(50)==3)
            turn(a);
        
    }    
    
}
