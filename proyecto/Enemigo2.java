import greenfoot.*;
/**
 * Aqui se realiza el movimiento de el enemigo, también cuando toca a el jugador lo ataca
 * y cuando toca a un obstaculo cambia de dirección.
 */
public class Enemigo2 extends MinibaseEnemiga
{
    private int a;
    private int cambioImagen;
    private int cambio;
    private int detener;
    private GreenfootImage[] lord=new GreenfootImage[4];
    private int bajaSangre;
    private int dano;
    public Enemigo2()
    {
        a=Greenfoot.getRandomNumber(360);
        cambioImagen=0;
        cambio=0;
        detener=0;
        bajaSangre=0;
        dano=0;
        for(int i=0;i<4;i++)
            lord[i]=new GreenfootImage("lord"+i+".png");
    }

    public void act() 
    {
        estorbo();
        localizacionMapa();
        if(detener!=1)
        {
            setImage(lord[cambioImagen]);//permite el cambio de imagenes
            cambioImagen+=1;
            if(cambioImagen==4)
                cambioImagen=0;
            move(10);
            
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
            turn(180);
            
        }
    }

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
            if(dano==3)
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
    public void ataque()
    {

        setImage(lord[cambio]);//permite el cambio de imagenes
        cambio+=1;
        if(cambio==2)
            cambio=0;

    }

    public void localizacionMapa()
    {

        getWorld().addObject(new Malo(),680+(getX()/10),20+(getY()/10));

    }
    
    
    
}


