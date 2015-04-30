import greenfoot.*;
public class Enemigo extends BaseEnemiga
{
    private int a;
    private int i;
    private int h;
    private int x;
    private int y;
    private int cambio;
    private GreenfootImage[] dia=new GreenfootImage[3];
    public Enemigo()
    {
        a=Greenfoot.getRandomNumber(360);
        x=Greenfoot.getRandomNumber(100);
        y=Greenfoot.getRandomNumber(100);
        h=0;
        cambio=0;
        for(i=0;i<3;i++)
            dia[i]=new GreenfootImage("dia"+i+".png");
    }

    public void act() 
    {
        estorbo();

        if(Greenfoot.getRandomNumber(4)==2)
        {
            setImage(dia[h]);//permite el cambio de imagenes
            h+=1;
            if(h==3)
                h=0;
            move(20);

        }
        if(isAtEdge())
        {
            turn(90);
        }
        if(Greenfoot.getRandomNumber(50)==3 || isAtEdge())
        {
            turn(a);
        }
        elimina(); 

    }

    public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
            turnTowards(x,y);
            //hace que el jugador ya no se mueva
        }
    }

    public void elimina()//cuando toca a los enemigos
    {
        if(isTouching(Buldier.class))
        {

            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(Buldier.class);

            }
            ataque();
        }else
        if(isTouching(Minibase.class))
        {

            if(Greenfoot.getRandomNumber(50)==25)
            {
                removeTouching(Minibase.class);

            }
            ataque();
        }
    }

    public void ataque()
    {
        setImage(dia[cambio]);//permite el cambio de imagenes
        cambio+=1;
        if(cambio==2)
            cambio=0;
    }
}
