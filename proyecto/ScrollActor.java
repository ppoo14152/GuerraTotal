import greenfoot.*;

public abstract class ScrollActor extends Actor
{
    private int camX, camY;
    private int globalX, globalY;
    private boolean isCameraFollower;
    private ScrollWorld world;
    
    public ScrollActor()
    {
        camX = 0;
        camY = 0;
        globalX = 0;
        globalY = 0;
        isCameraFollower = false;
        world = null;
    }
    
    public int getGlobalX()
    {
        if (world == null)
            throw new IllegalStateException("Actor not in world. Either is hasn't"+
            " been inserted, or it has been deleted.");
        return globalX;
    }
   
    public int getGlobalY()
    {
        if (world == null)
            throw new IllegalStateException("Actor not in world. Either is hasn't"+
            " been inserted, or it has been deleted.");
        return globalY;
    }
    
    public int getXFromCamera()
    {
        if (world == null)
            throw new IllegalStateException("Actor not in world. Either is hasn't"+
            " been inserted, or it has been deleted.");
        return camX;
    }
    
    public int getYFromCamera()
    {
        if (world == null)
            throw new IllegalStateException("Actor not in world. Either is hasn't"+
            " been inserted, or it has been deleted.");
        return camY;
    }
    
    public void setLocation(int x, int y)
    {
        if (world == null) return;
        super.setLocation(x,y);
        int halfWorldWidth = world.getWidth() /2;
        int halfWorldHeight = world.getHeight() /2;
        camX = x -halfWorldWidth;
        camY = y -halfWorldHeight;
        globalX = x +(world.getCameraX() -halfWorldWidth);
        globalY = y +(world.getCameraY() -halfWorldHeight);
    }
    
    public void setLocationFromCamera(int x, int y)
    {
        setLocation(x +world.getCameraX(), y +world.getCameraY());
    }
    
    public void setGlobalLocation(int x, int y)
    {
        int subX = world.getCameraX() -world.getWidth() /2;
        int subY = world.getCameraY() -world.getHeight() /2;
        setLocation(x -subX, y -subY);
    }
    
    public ScrollWorld getWorld()
    {
        return world;
    }
    
    public void move(int distance)
    {
        if (distance == 0) return;
        double radians = Math.toRadians(getRotation());
        double sin = Math.sin(radians);
        double cos = Math.cos(radians);
        int dx = (int)Math.round(cos *distance);
        int dy = (int)Math.round(sin *distance);
        setLocation(getX() +dx, getY() +dy);
    }
    
    public void turnTowardsGlobalLocation(int x, int y)
    {
        if (x == globalX && y == globalY) return;
        double a = Math.atan2(y -globalY, x -globalX);
        int newRotation = (int)Math.round(Math.toDegrees(a));
        setRotation(newRotation);
    }
    
    public void turnTowardsCameraLocation(int x, int y)
    {
        if (x == camX && y == camY) return;
        double a = Math.atan2(y -camY, x -camX);
        int newRotation = (int)Math.round(Math.toDegrees(a));
        setRotation(newRotation);
    }
    
    public boolean isCameraFollower()
    {
        if (world == null)
            throw new IllegalStateException("Actor not in world. Either is hasn't"+
            " been inserted, or it has been deleted.");
        return isCameraFollower;
    }
    
    void setIsCameraFollower(boolean value)
    {
        this.isCameraFollower = value;
        this.world = (ScrollWorld) super.getWorld();
        if (value) {
            setLocation(getX(), getY());
        }
    }
}