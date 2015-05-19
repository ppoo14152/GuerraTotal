
import greenfoot.*;
/**
 * Hace que al momento de seleccionar al guerrero a este lo puedas mover por todo el mapa indicandole hacia donde ir, al 
 * momento de llegar al punto se detendra hasta que le vuelvas a dar otro click en otra posición.
 *
 * Al tener seleccionado al Buldier apachurras c para contruir.
 */
public class Buldier extends Mira
{
    private int usarlos;
    private int x;
    private int y;
    private int jugandolo;
    private GreenfootImage[] bu=new GreenfootImage[3];
    private int cambioImagen;
    
    public Buldier()
    {
        usarlos=0;
        jugandolo=0;
        cambioImagen=0;
       
        
        for(int i=0;i<3;i++)
            bu[i]=new GreenfootImage("bu"+i+".png");
    }

    public void act() 
    {
        escogerTodo();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        
        if(Greenfoot.mouseClicked(this))
        {
            usarlos=1;
            removeTouching(Selecciones.class);
            removeTouching(Bomba.class);
        }
        if(usarlos==1&&Greenfoot.mouseClicked(null))
        {
            jugandolo=1;
            turnTowards(mouse.getX(),mouse.getY());
            x=mouse.getX();
            y=mouse.getY();
        }
        localizacionEjercito();
        if(jugandolo==1)
        {
            
            if(getX()>x-10&&getX()<x+10 || getY()>y-10&&getY()<y+10)//para el minimapa
            {
                setImage(bu[1]);
                jugandolo=0;
                
            }
            else
            {
                setImage(bu[cambioImagen]);//permite el cambio de imagenes
                cambioImagen+=1;
                if(cambioImagen==2)
                    cambioImagen=0;
                move(10);
                
            }
        }
        soltar();
        if(Greenfoot.isKeyDown("q"))//se detiene
            usarlos=0;
            else
        construir();
       
        estorbo();
    }

    public void localizacionEjercito()
    {
        
        getWorld().addObject(new Bueno(),660+(getX()/10),10+(getY()/10));
        
    }

    public void estorbo()
    {
        if(isTouching(Cosa.class))
        {
           turnTowards(getX(),getY());
           jugandolo=0;//hace que el jugador ya no se mueva
        }
    }

    public void construir()
    {
        if(jugandolo==0&&Greenfoot.isKeyDown("c")&&usarlos==1)//colocar "Presioe c para construir"
        {   
            getWorld().addObject(new Minibase(),x,y);

        }

    }
    
    public void soltar()//checar que lo toque la cordenada
    {
        if(x==getX()||y==getY())
        jugandolo=0;
    }
    
    public void escogerTodo()
    {
        if(Greenfoot.isKeyDown("b"))
        usarlos=1;
        if(Greenfoot.isKeyDown("g"))
        usarlos=0;
    }
}
