import greenfoot.*;
/**
 * Hace que que el objeto bombaEnemigo se mueva aleatoriamente por todo el mapa, tambien si toca la
 * base del jugador perderas.
 */
public class BombaEnemiga extends Mira
{
    private int detener;
    private World w;
    public BombaEnemiga()
    {
        detener=0;
        w=getWorld();

    }

    public void act() 
    {
        int a=Greenfoot.getRandomNumber(360);
        estorbo();
        localizacionMapa();
        if(detener!=1)
        {

            move(10);

        }

        if(Greenfoot.getRandomNumber(50)==3 || isAtEdge())
        {
            turn(a);
        }
        perdiste();

    }

    public void estorbo()
    {
        int x=Greenfoot.getRandomNumber(100);
        int y=Greenfoot.getRandomNumber(100);
        if(isTouching(Cosa.class))
        {
            turnTowards(x,y);

        }
    }

    public void localizacionMapa()
    {

        getWorld().addObject(new Malo(),680+(getX()/10),20+(getY()/10));

    }

    public void perdiste()
    {
        if(isTouching(Base.class))
        {

            removeTouching(Base.class);
            detener=1;
            w=new Perdiste();
            Greenfoot.setWorld(w);

        }

    }
}

