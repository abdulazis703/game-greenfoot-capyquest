import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JawabanMath8B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JawabanMath8B extends JawabanMath8
{
    private GreenfootImage original;
    private boolean enlarged = false;

    public JawabanMath8B() {
        original = new GreenfootImage(getImage()); // simpan gambar asli
    }

    public void act()
    {
        hoverEffect();
        clickAction();
    }

    private void hoverEffect()
    {
        // Mouse masuk → membesar
        if (Greenfoot.mouseMoved(this)) {
            if (!enlarged) {
                GreenfootImage big = new GreenfootImage(original);
                big.scale((int)(original.getWidth() * 1.12), (int)(original.getHeight() * 1.12));
                setImage(big);
                enlarged = true;
            }
        }

        // Mouse keluar → kembali normal
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            if (enlarged) {
                setImage(original);
                enlarged = false;
            }
        }
    }

    private void clickAction()
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.playSound("button.wav");
            Greenfoot.setWorld(new JawabanSalah());
            
        }
    }
}