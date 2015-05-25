import greenfoot.*;
/**
 * Aqui se realiza el movimiento de el enemigo, también cuando toca a el jugador lo ataca
 * y cuando toca a un obstaculo cambia de dirección.
 */
public class Enemigo extends MinibaseEnemiga
{
    private int cambioImagen;
    private int cambio;
    private int detener;
    private GreenfootImage[] lord=new GreenfootImage[2];
    private int bajaSangre;
    private int dano;
    public Enemigo()
    {
        
        cambioImagen=0;
        cambio=0;
        detener=0;
        bajaSangre=0;
        dano=0;
        
        for(int i=0;i<2;i++)
            lord[i]=new GreenfootImage("gm"+i+".png");
    }
   /**
    * Permite el movimiento del enemigo y los movimientos del mismo.
    * Hace que el enemigo al tocar la orilla o cada cierto tiempo girar.
    */
    public void act() 
    {
        int aleatorioGiro=Greenfoot.getRandomNumber(360);
        estorbo();
        localizacionMapa();
        if(detener!=1)
        {
            setImage(lord[cambioImagen]);//permite el cambio de imagenes
            cambioImagen+=1;
            if(cambioImagen==2)
                cambioImagen=0;
            move(10);
            
        }
        
        if(isAtEdge())
        {
            turn(90);
        }
        if(Greenfoot.getRandomNumber(50)==3 || isAtEdge())
        {
            turn(aleatorioGiro);
        }
        elimina(); 

    }
    /**
     * Hce que cambie de rumbo al momento de topar con un muro.
     */
    public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
            turn(180);
            
        }
    }
    /**
     * derrota a tus unidades al momento de tocarlas después de haber conbatido
     */
    public void elimina()//cuando toca a los enemigos
    {
        if(isTouching(Buldier.class))
        {
            bajaSangre++;
            detener=1;
            if(bajaSangre==20)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==2)
            {
                    removeTouching(Buldier.class);
                    
            }
            ataque();
        }else

        if(isTouching(Minibase.class))
        {
            bajaSangre++;
            detener=1;
            if(bajaSangre==40)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==5)
            {
                    removeTouching(Minibase.class);
                    
            }
            ataque();
        }
        else
        if(isTouching(Guerreros.class))
        {
            bajaSangre++;
            detener=1;
            if(bajaSangre==30)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==3)
            {
                    removeTouching(Guerreros.class);
                    
            }
            ataque();
        }
        else
        if(isTouching(Guerrero2.class))
        {
            bajaSangre++;
            detener=1;
            if(bajaSangre==30)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==3)
            {
                    removeTouching(Guerrero2.class);
                    
            }
            ataque();
        }
        else
        if(isTouching(Bomba.class))
        {
            bajaSangre++;
            detener=1;
            if(bajaSangre==20)
            {
                
               removeTouching(Bomba.class);
            }
            ataque();
        }
        
    }
    /**
     * Simula un ataque al cambiar de imagenes
     */
    public void ataque()
    {

        setImage(lord[cambio]);//permite el cambio de imagenes
        cambio+=1;
        if(cambio==2)
            cambio=0;

    }
    /**
     * Hace aparecer un punto en el mini mapa indicando que existe en el mundo.
     * 
     */
    public void localizacionMapa()
    {

        getWorld().addObject(new Malo(),680+(getX()/10),20+(getY()/10));

    }
    
    
}

