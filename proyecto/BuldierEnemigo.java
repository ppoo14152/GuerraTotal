import greenfoot.*;
/**
 * Permite que el objeto se pueda mover por si solo por todo el mapa y pueda construir minibases 
 * por todo el mapa.
 */
public class BuldierEnemigo extends Mira
{
    private int ale;
    private int cambioImagen;
    private int permite;
    private int limite;
    private GreenfootImage[] bu=new GreenfootImage[3];
    public BuldierEnemigo()
    {
        ale=Greenfoot.getRandomNumber(360);
        cambioImagen=0;
        permite=0;
        limite=0;
        for(int i=0;i<3;i++)
            bu[i]=new GreenfootImage("bu_"+i+".png");
    }
    /**
     * Se realiza el movimiento, cambio de imagenes al moverse y las condiciones al tocar
     * la orilla y coloque una minibaseEnemiga.
     */
    public void act() 
    {
        estorbo();
        if(permite==0)
        {
            setImage(bu[cambioImagen]);
            cambioImagen+=1;
            if(cambioImagen==2)
                cambioImagen=0;
            move(10);
            localizacionMapa();

            if(isAtEdge())
            {
                turn(90);
            }
            else
            if(Greenfoot.getRandomNumber(50)==3 || isAtEdge())
            {
                turn(ale);
            }
            if(Greenfoot.getRandomNumber(200)==3&&limite!=2)
            {
                getWorld().addObject(new MinibaseEnemiga(),getX(),getY());
                limite++;
            }
        }
    }
    
    /**
     * No deja que choque con los obsatculos, lo hace girar
     */
    public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
            turnTowards(getX(),getY());
        }
    }
    /**
     * Pone un punto rojo en el minimapa para indicar que existe
     */
    public void localizacionMapa()
    {
        getWorld().addObject(new Malo(),660+(getX()/15),10+(getY()/15));

    }
}
