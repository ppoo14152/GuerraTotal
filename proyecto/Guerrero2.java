import greenfoot.*;
public class Guerrero2 extends Minibase
{
    private int band;
    private int x;
    private int y;
    private int band2;
    private int i;
    private int h;
    private GreenfootImage[] lord=new GreenfootImage[4];
    private int cambio;
    public Guerrero2()
    {
        band=0;
        band2=0;
        h=0;
        cambio=0;
        for(i=0;i<4;i++)
            lord[i]=new GreenfootImage("lord"+i+".png");

    }
    public void act() 
    {
        MouseInfo mouse=Greenfoot.getMouseInfo();  
        elimina();
        if(Greenfoot.mouseClicked(this))
        {
            band=1;
            removeTouching(MiniSelecciones.class);
            removeTouching(Guerreros.class);

        }
        if(band==1&&Greenfoot.mouseClicked(null))
        {
            x=mouse.getX();
            y=mouse.getY();
            band2=1;
            turnTowards(mouse.getX(),mouse.getY());
            seleccionEjercito(x,y);
        }
        if(band2==1)
        {
            if(getX()>x-5&&getX()<x+5||getY()>y-5&&getY()<y+5)
            { setImage(lord[1]);
                band2=0;
            }
            else
            {
                setImage(lord[h]);//permite el cambio de imagenes
                h+=1;
                if(h==4)
                    h=0;
                move(20); 
            }  
        }  
        if(Greenfoot.isKeyDown("q"))
            band=0;
    }    

    public void seleccionEjercito(int x,int y)
    {
        getWorld().addObject(new Bueno(),660+(x/10),10+(y/10));

    }

    public void elimina()//cuando toca a los enemigos
    {
        if(isTouching(BuldierEnemigo.class))
        {
            band=1;
            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(BuldierEnemigo.class);
                band=0;
            }
            ataque();
        }else
        if(isTouching(MinibaseEnemiga.class))
        {
            band=1;
            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(MinibaseEnemiga.class);
                band=0;
            }
         else
        if(isTouching(Enemigo.class))
        {
            band=1;
            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(Enemigo.class);
                band=0;
            }
            ataque();
        }
    }
    }

    public void ataque()
    {
        setImage(lord[cambio]);//permite el cambio de imagenes
        cambio+=1;
        if(cambio==2)
            cambio=0;
    }

}

