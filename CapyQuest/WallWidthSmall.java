import greenfoot.*;

public class WallWidthSmall extends walls // Assuming 'walls' is the correct superclass name
{
    public WallWidthSmall()
    {
        
        int newWidth = getImage().getWidth() * 1;
        int originalHeight = getImage().getHeight();
        
        
        getImage().scale(newWidth, originalHeight);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}