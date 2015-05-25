import greenfoot.*;
/**
 * Crea un anuncio en mundo de Ganaste que al salirte te mostrara otro letrero de continuar, hace que suene 
 * una explosion.Este te manda al nivel 2
 */
public class Ganaste1 extends Ganaste
{

    /**
     * Constructor for objects of class Ganaste1.
     * 
     */
    public Ganaste1()
    {
        Continuar bp=new Continuar();
        addObject(bp,400,650);
    }
}
