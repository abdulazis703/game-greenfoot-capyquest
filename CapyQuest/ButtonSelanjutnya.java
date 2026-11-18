import greenfoot.*;  

public class ButtonSelanjutnya extends Button
{
    private GreenfootImage original;   
    private boolean enlarged = false;  

    public ButtonSelanjutnya() 
    {
        original = new GreenfootImage(getImage()); 
    }

    public void act()
    {
        hoverEffect();
        clickAction();
    }

    // -----------------------------
    //  HOVER (membesar saat disentuh)
    // -----------------------------
    private void hoverEffect()
    {
        // Jika mouse berada di atas tombol
        if (Greenfoot.mouseMoved(this)) 
        {
            if (!enlarged) {
                GreenfootImage big = new GreenfootImage(original);
                big.scale((int)(original.getWidth() * 1.12),
                          (int)(original.getHeight() * 1.12));
                setImage(big);
                enlarged = true;
            }
        }

        // Jika mouse pindah ke area lain (keluar dari tombol)
        if (Greenfoot.mouseMoved(null) && enlarged && !Greenfoot.mouseMoved(this)) 
        {
            setImage(original);
            enlarged = false;
        }
    }

    // -----------------------------
    //  AKSI KLIK
    // -----------------------------
    private void clickAction()
    {
        if (Greenfoot.mouseClicked(this)) 
        {
            Greenfoot.playSound("button.wav");
            Greenfoot.setWorld(new CaraBermain2());
        }
    }
}
