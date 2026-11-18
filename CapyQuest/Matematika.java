import greenfoot.*;

public class Matematika extends Button
{
    private GreenfootImage original;
    private boolean enlarged = false;

    public Matematika() {
        original = new GreenfootImage(getImage());
    }

    public void act()
    {
        hoverEffect();
        clickAction();
    }

    private void hoverEffect()
    {
        // Saat mouse berada di atas tombol → membesar
        if (Greenfoot.mouseMoved(this)) {
            if (!enlarged) {
                GreenfootImage big = new GreenfootImage(original);
                big.scale((int)(original.getWidth() * 1.12), (int)(original.getHeight() * 1.12));
                setImage(big);
                enlarged = true;
            }
        }

        // Saat mouse keluar dari tombol → kembali normal
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
            Greenfoot.setWorld(new MatematikaWorld());
        }
    }
}
