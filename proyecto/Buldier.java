
//import java.util.*;
import greenfoot.*;

public class Buldier extends Base
{
    
    private int band;
    private int x;
    private int y;
    private int band2;
    private GreenfootImage[] bu=new GreenfootImage[3];
    private Mira mira;
    private int i,j;
    private int cambio,cambio2;
    private int copias;
    private int car;
    private MouseInfo mouse;
    private int noUsar;
    private int ale;
    private int estaX;
    private int estaY;
    public Buldier()
    {
        band=0;
        band2=0;
        cambio=0;
        copias=0;
        mira=new Mira();
        mouse = Greenfoot.getMouseInfo();
        
        for(i=0;i<3;i++)
            bu[i]=new GreenfootImage("bu_"+i+".png");
    }

    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(this))
        {
            band=1;
            removeTouching(Selecciones.class);
            removeTouching(Guerreros.class);
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
            if(getX()>x-5&&getX()<x+5 || getY()>y-5&&getY()<y+5)//para el minimapa
            {
                setImage(bu[1]);
                band2=0;
                seleccionEjercito();
                
            }
            else
            {
                setImage(bu[cambio]);//permite el cambio de imagenes
                cambio+=1;
                if(cambio==2)
                    cambio=0;
                move(20);
            }
        }
        soltar();
        if(Greenfoot.isKeyDown("q"))//se detiene
            band=0;
            else
        construir();
       
        estorbo();
    }

    public void seleccionEjercito()
    {
        getWorld().addObject(new Bueno(),660+(getX()/10),10+(getY()/10));
    }

    public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
           turnTowards(getX(),getY());
           band2=0;//hace que el jugador ya no se mueva
        }
    }

    public void construir()
    {
        if(band2==0&&Greenfoot.isKeyDown("c")&&band==1)//colocar "Presioe c para construir"
        {   
            estaX=getX();
            estaY=getY();
            getWorld().addObject(new Minibase(),estaX,estaY);

        }

    }
    
    public void soltar()//checar que lo toque la cordenada
    {
        if(x==getX()||y==getY())
        band2=0;
    }
    
}
