import greenfoot.*;

public class Kembali extends Button
{
    private GreenfootImage original;
    private boolean enlarged = false;

    public Kembali() {
        original = new GreenfootImage(getImage());
    }

    public void act()
    {
        hoverEffect();
        clickAction();
    }

    private void hoverEffect()
    {
        // Mouse di atas tombol → perbesar
        if (Greenfoot.mouseMoved(this)) {
            if (!enlarged) {
                GreenfootImage big = new GreenfootImage(original);
                big.scale((int)(original.getWidth() * 1.12), (int)(original.getHeight() * 1.12));
                setImage(big);
                enlarged = true;
            }
        }

        // Mouse keluar dari tombol → kembali ukuran normal
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
            Greenfoot.setWorld(new HalamanUtama());
        }
    }
}
