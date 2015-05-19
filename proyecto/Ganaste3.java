import greenfoot.*;
/**
 * Crea un anuncio en mundo de Ganaste que al salirte te mostrara otro letrero de continuar, hace que suene 
 * una explosion.Al salir has acabado el juego.
 */
public class Ganaste3 extends World
{
    private World w;
    
    public Ganaste3()
    {    
        super(800, 700, 1); 
        Back bp=new Back();
        addObject(bp,400,650);
        GreenfootSound music=new GreenfootSound("explosion.mp3");
        music.play();
        music.setVolume(50);
    }
    
}
