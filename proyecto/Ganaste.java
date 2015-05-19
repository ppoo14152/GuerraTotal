import greenfoot.*;
/**
 * Crea un anuncio en mundo de Ganaste que al salirte te mostrara otro letrero de continuar, hace que suene 
 * una explosion.Este te manda al nivel 2
 */
public class Ganaste extends World
{
    private World w;
    public Ganaste()
    {    
        super(800, 700, 1); 
        Continuar bp=new Continuar();
        addObject(bp,400,650);
        GreenfootSound music=new GreenfootSound("explosion.mp3");
        music.play();
        music.setVolume(50);
    }
    
}
