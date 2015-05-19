import greenfoot.*;
/**
 * Crea un anuncio en mundo de Ganaste que al salirte te mostrara otro letrero de continuar, hace que suene 
 * una explosion.Este te manda al nivel 3
 */
public class Ganaste2 extends World
{
    private World w;
    public Ganaste2()
    {    
        super(800, 700, 1); 
        Continuar2 bp=new Continuar2();
        addObject(bp,400,650);
        GreenfootSound music=new GreenfootSound("explosion.mp3");
        music.play();
        music.setVolume(50);
    }
    
}