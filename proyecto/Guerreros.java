import greenfoot.*;
/**
 * Hace que al momento de seleccionar al guerrero a este lo puedas mover por todo el mapa indicandole hacia donde ir, al 
 * momento de llegar al punto se detendra hasta que le vuelvas a dar otro click en otra posición.
 * Cuando toca a un enemigo este luchara con él hasta perder o ganar.
 */
public class Guerreros extends Minibase
{
    private int usarlos;
    private int manejarlo;
    private int cambiaImagen;
    private GreenfootImage[] dragon=new GreenfootImage[4];
    private int cambioIma;
    private int bajaSangre;
    private int dano;
    private int x;
    private int y;
    public Guerreros()
    {
        usarlos=0;
        manejarlo=0;
        cambiaImagen=0;
        cambioIma=0;
        bajaSangre=0;
        dano=0;
        for(int i=0;i<4;i++)
            dragon[i]=new GreenfootImage("dragon_"+i+".png");

    }
    public void act() 
    {
        escogerTodo();
        MouseInfo mouse=Greenfoot.getMouseInfo();  
        estorbo();
        elimina();
        if(Greenfoot.mouseClicked(this))
        {
            usarlos=1;
            removeTouching(MiniSelecciones.class);
            removeTouching(Guerrero2.class);
        }
        if(usarlos==1&&Greenfoot.mouseClicked(null))
        {
            x=mouse.getX();
            y=mouse.getY();
            manejarlo=1;
            turnTowards(mouse.getX(),mouse.getY());
            GreenfootSound music=new GreenfootSound("alas.mp3");
            music.play();
            music.setVolume(40);
        }
        localizacionEjercito();
        if(manejarlo==1)
        {
            if(getX()>x-5&&getX()<x+5||getY()>y-5&&getY()<y+5)
            { setImage(dragon[3]);
                manejarlo=0;
            }
            else
            {
                //Greenfoot.playSound("dragon.mp3");
                setImage(dragon[cambiaImagen]);//permite el cambio de imagenes
                cambiaImagen+=1;
                if(cambiaImagen==4)
                    cambiaImagen=0;
                move(20); 
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
            if(bajaSangre==40)
            {
                
                dano+=1;
                bajaSangre=0;
            }
            if(dano==5)
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
        setImage(dragon[cambioIma]);//permite el cambio de imagenes
        cambioIma+=1;
        if(cambioIma==2)
            cambioIma=0;
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
          manejarlo=0;//hace que el jugador ya no se mueva
        }
    }
}
