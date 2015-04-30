import greenfoot.*;
public class BuldierEnemigo extends BaseEnemiga
{
    private int ale;
    private int cambio;
    private int band;
    private int contador;
    private int co;
    public BuldierEnemigo()
    {
        ale=Greenfoot.getRandomNumber(360);
        cambio=0;
        band=0;
        //getWorld().addObject(new Vida(),getX()-50,getY());
        //getWorld().getVida().getX();
    }

    public void act() 
    {
        estorbo();
        if(band==0)
        {
            if(Greenfoot.getRandomNumber(4)==2)
            {
                move(30);
            }
            if(isAtEdge())
            {
                turn(90);
            }
            else
            if(Greenfoot.getRandomNumber(50)==3 || isAtEdge())
            {
                turn(ale);
            }
            if(Greenfoot.getRandomNumber(200)==3)
            {
                getWorld().addObject(new MinibaseEnemiga(),getX(),getY());
            }
        }
    }
    
    public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
            turnTowards(getX(),getY());
            //hace que el jugador ya no se mueva
        }
    }
}
