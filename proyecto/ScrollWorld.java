import greenfoot.*;
import java.util.ArrayList;

public abstract class ScrollWorld extends World
{
    private final int width, height, cellSize;
    private final ArrayList<Mira> objects;
    private final ArrayList<Mira> camFollowers;
    private final int fullWidth, fullHeight;
    
    private int camX, camY, camDir;
    
    private final GreenfootImage bigBackground, back;
    private int scrollPosX, scrollPosY;
    
    public ScrollWorld(int width, int height, int cellSize, int fullWidth, int fullHeight)
    {
        super(width, height, cellSize, false);
        this.back = getBackground();
        this.width = back.getWidth();
        this.height = back.getHeight();
        this.cellSize = cellSize;
        this.fullWidth = fullWidth;
        this.fullHeight = fullHeight;
        if (fullWidth <= 0)
            throw new IllegalArgumentException("The width of the big space ("+fullWidth
            +") can't be smaller then the width of the world ("+width+")");
        if (fullHeight <= 0)
            throw new IllegalArgumentException("The height of the big space ("+fullHeight
            +") can't be smaller then the height of the world ("+height+")");
        
        objects = new ArrayList<Mira>();
        camFollowers = new ArrayList<Mira>();
        
        camX = getWidth() /2;
        camY = getHeight() /2;
        camDir = 0;
        
        scrollPosX = 0;
        scrollPosY = 0;
        
        bigBackground = new GreenfootImage(width+width, height+height);
       setNewBackground(back);
    }
   
    public void setNewBackground(GreenfootImage background)
    {
        bigBackground.clear();
        if (background.getWidth() == bigBackground.getWidth() &&
            background.getHeight() == bigBackground.getHeight()) {
            bigBackground.drawImage(background, 0,0);
            back.clear();
            back.drawImage(bigBackground, scrollPosX,scrollPosY);
            return;
        }
        
        bigBackground.drawImage(background, 0,0);
        bigBackground.drawImage(background, background.getWidth(),0);
        bigBackground.drawImage(background, 0,background.getHeight());
        bigBackground.drawImage(background, background.getWidth(),background.getHeight());
        
        back.clear();
        back.drawImage(bigBackground, scrollPosX,scrollPosY);
    }
    
   public void addCameraFollower(Mira cameraFollower, int x, int y)
    {
        super.addObject(cameraFollower, getWidth() /2 +x, getHeight() /2 +y);
        camFollowers.add(cameraFollower);
        cameraFollower.setIsCameraFollower(true);
    }
    
    
    public void addObject(Actor object, int x, int y)
    {
        if (object instanceof Mira) {
            if (x >= fullWidth)
                x = fullWidth -1;
            else if (x < 0)
                x = 0;
            if (y >= fullHeight)
                y = fullHeight -1;
            else if (y < 0)
                y = 0;
            Mira sa = (Mira) object;
            super.addObject(sa, x -(camX -getWidth() /2), y -(camY -getHeight() /2));
            objects.add(sa);
            sa.setIsCameraFollower(false);
        } else
            super.addObject(object,x,y);
    }
    
  
    public void removeObject(Actor object)
    {
        super.removeObject(object);
        if (object instanceof Mira) {
            Mira a = (Mira) object;
            objects.remove(a);
            camFollowers.remove(a);
            a.setIsCameraFollower(false);
        }
    }
    
    public int getCameraX()
    {
        return camX;
    }
    
    public int getCameraY()
    {
        return camY;
    }
    
    public int getFullWidth()
    {
        return fullWidth;
    }
   
    public int getFullHeight()
    {
        return fullHeight;
    }
    
    public void setCameraLocation(int x, int y)
    {
        if (camX == x && camY == y) return;
        if (x > fullWidth -getWidth() /2)
            x = fullWidth -getWidth() /2;
        else if (x < getWidth() /2)
            x = getWidth() /2;
        if (y > fullHeight -getHeight() /2)
            y = fullHeight -getHeight() /2;
        else if (y < getHeight() /2)
            y = getHeight() /2;
        int dx = x -camX;
        int dy = y -camY;
        camX = x;
        camY = y;
        for (Mira a : objects)
            a.setLocation(a.getX() -dx, a.getY() -dy);
        for (Mira a : camFollowers)
            a.setLocation(a.getX(), a.getY());
        moveBackgroundRight(dx *cellSize);
        moveBackgroundUp(dy *cellSize);
    }
    
    public void setCameraDirection(int degrees)
    {
        if (degrees >= 360) {
            if (degrees < 720)
                degrees -= 360;
            else
                degrees %= 360;
        } else if (degrees < 0) {
            if (degrees >= -360)
                degrees += 360;
            else
                degrees = 360 +(degrees %360);
        }
        if (camDir == degrees) return;
        camDir = degrees;
    }
   
    public void turnCamera(int amount)
    {
        setCameraDirection(camDir +amount);
    }
    
    public void moveCamera(int amount)
    {
        if (amount == 0) return;
        double radians = Math.toRadians(camDir);
        double dx = Math.cos(radians) *amount;
        double dy = Math.sin(radians) *amount;
        setCameraLocation((int)(camX +dx +0.5), (int)(camY +dy +0.5));
    }
    
    /** MOVING BACKGROUND: */
    
    /**
     * All the honor for this goes to Busch2207 from
     * greenfoot.org
     */
    private void moveBackgroundUp(int amount)
    {
        if (amount == 0) return;
        int height = getHeight();
        scrollPosY -= amount;
        while (scrollPosY < 0)
            scrollPosY += height;
        scrollPosY %= height;
        getBackground().drawImage(bigBackground, scrollPosX -getWidth(),scrollPosY -height);
    }
    
    /**
     * All the honor for this goes to Busch2207 from
     * greenfoot.org
     */
    private void moveBackgroundRight(int amount)
    {
        if (amount == 0) return;
        int width = getWidth();
        scrollPosX -= amount;
        while (scrollPosX < 0)
            scrollPosX += width;
        scrollPosX %= width;
        getBackground().drawImage(bigBackground, scrollPosX -width,scrollPosY -getHeight());
    }
}