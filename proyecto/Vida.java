import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class Vida extends ScrollActor
{
    private GreenfootImage[] vida=new GreenfootImage[6];
    private int j;
    public int cambio;
    public Vida() 
    {
        cambio=0;
        for(j=0;j<6;j++)//vidas
            vida[j]=new GreenfootImage("vida"+j+".png");
    }
    public void act()
    {
        if(isTouching(BuldierEnemigo.class))
        {
            setImage(vida[cambio]);//permite el cambio de imagenes
            cambio+=1;
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            setImage(vida[cambio]);
        }
    }
   
    }
