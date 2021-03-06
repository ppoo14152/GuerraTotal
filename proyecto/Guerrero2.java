import greenfoot.*;
public class Guerrero2 extends Minibase
{
    private int usarlos;
    private int x;
    private int y;
    private int band2;
    private int i;
    private int h;
    private GreenfootImage[] lord=new GreenfootImage[2];
    private int cambio;
    private int bajaSangre;
    private int dano;
    private int tocar;
    public Guerrero2()
    {
        usarlos=0;
        band2=0;
        h=0;
        cambio=0;
        bajaSangre=0;
        dano=0;
        tocar=0;
   
        for(i=0;i<2;i++)
            lord[i]=new GreenfootImage("g"+i+".png");
        
    }
    public void act() 
    {
        escogerTodo();
        estorbo();
        MouseInfo mouse=Greenfoot.getMouseInfo();  
        elimina();
        if(Greenfoot.mouseClicked(this))
        {
            usarlos=1;
            removeTouching(MiniSelecciones.class);
            removeTouching(Guerreros.class);
           
        }
        if(usarlos==1&&Greenfoot.mouseClicked(null))
        {
            x=mouse.getX();
            y=mouse.getY();
            band2=1;
            turnTowards(mouse.getX(),mouse.getY());
            GreenfootSound musica=new GreenfootSound("Lucha.mp3");
            musica.play();
            musica.setVolume(30);
        }
        localizacionEjercito();
        if(band2==1)
        {
            
            if(getX()>x-5&&getX()<x+5||getY()>y-5&&getY()<y+5)
            { setImage(lord[1]);
                band2=0;
                
            }
            else
            {
                
                setImage(lord[h]);//permite el cambio de imagenes
                h+=1;
                if(h==2)
                    h=0;
                move(10); 
                
            }  
        }  
        if(Greenfoot.isKeyDown("q"))
            usarlos=0;
    }    

    public void localizacionEjercito()
    {
        getWorld().addObject(new Bueno(),660+(getX()/10),10+(getY()/10));

    }

    public void elimina()//cuando toca a los enemigos
    {
        if(isTouching(BuldierEnemigo.class))
        {
            bajaSangre++;
            if(bajaSangre==20)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==2)
            {
                    removeTouching(BuldierEnemigo.class);
                    
            }
            ataque();
        }else

        if(isTouching(MinibaseEnemiga.class))
        {
            bajaSangre++;
            if(bajaSangre==10)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==4)
            {
                    removeTouching(MinibaseEnemiga.class);
                    
            }
            ataque();
        }
        else
        if(isTouching(Enemigo.class))
        {
            bajaSangre++;
            if(bajaSangre==30)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==3)
            {
                    removeTouching(Enemigo.class);
                    
            }
            ataque();
        }
        else
        if(isTouching(Enemigo2.class))
        {
            bajaSangre++;
            if(bajaSangre==30)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==3)
            {
                    removeTouching(Enemigo2.class);
                    
            }
            ataque();
        }
        else
        if(isTouching(BombaEnemiga.class))
        {
            bajaSangre++;
            
            if(bajaSangre==20)
            {
                
               removeTouching(BombaEnemiga.class);
            }
            ataque();
        }
    
    
}

    public void ataque()
    {
        
       GreenfootSound efecto=new GreenfootSound("espadas.mp3");
       efecto.play();
       efecto.setVolume(15);
        
        setImage(lord[cambio]);//permite el cambio de imagenes
        cambio+=1;
        if(cambio==2)
            cambio=0;
    }
    
    public void escogerTodo()
    {
        if(Greenfoot.isKeyDown("g"))
        usarlos=1;
        if(Greenfoot.isKeyDown("b"))
        usarlos=0;
        
    }
    
     public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
           turnTowards(getX(),getY());
           band2=0;//hace que el jugador ya no se mueva
        }
    }
}

