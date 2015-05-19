import greenfoot.*;
/**
 * En el se han creado las 2 bases principales y colocado el escenario correspondiente, el super y
 * lo que contiene como parametros las primeras es la extension de solo lo que se mira del mapa
 * en cambio las 2 ultimas son el tamaño de la imagen completa.
 */
public class Mapa2 extends ScrollWorld
{
    
    private Base f;
    private Buldier bul;
    private World w;
    public Mapa2()
    {    
        super(800, 600, 1, 1500,1500);
        Mapa();
        bul=new Buldier();
    }
   /**
    * Se inicializaron todo el enterno del mapa, los aleaorios son para que los obstaculos salgan 
    * en diferentes posiciones de todo el mapa
    */
    public void Mapa()
    {
        Greenfoot.getMicLevel();
        
        Ambiente();
        Mira m=new Mira();
        addObject(m,400,300);
        f=new Base();
        addObject(f,150,150);
        BaseEnemiga2 be=new BaseEnemiga2();
        addObject(be,1300,1300);
        MiniMapa mm=new MiniMapa();
        addObject(mm,720,50);
        Nivel re=new Nivel();
        addObject(re,500,50);
        
        Reco rec=new Reco();
        rec.guardaRecords(800);
        showText("2",500,50);
    }

    public void Ambiente()
    {
        for(int i=0;i<15;i++)
        {
            int aleatorio=Greenfoot.getRandomNumber(1500);
            int aleatorio2=Greenfoot.getRandomNumber(1500);
            Cosa am=new Cosa();
            if(aleatorio>150&&aleatorio2>150 && aleatorio<1400&&aleatorio2<1300)
            addObject(am,aleatorio,aleatorio2);
              
        }
        
    }
   
  
}