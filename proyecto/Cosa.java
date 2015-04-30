import greenfoot.*;

public class Cosa extends Mira
{
    private GreenfootImage[] cosa=new GreenfootImage[2];
    private int i;
    private int h;
    public Cosa()
    {
        h=0;
        for(i=0;i<2;i++)
            cosa[i]=new GreenfootImage("cosa"+i+".png");
    }

    public void act() 
    {
        /*if(Greenfoot.getRandomNumber(2)==1)
        setImage("cosa0.png");
        else
        setImage("cosa1.png");*/
        
        /*setImage(cosa[h]);//Animacion de imagenes
        h+=1;
        if(h==2)
            h=0;*/
    }    
}
