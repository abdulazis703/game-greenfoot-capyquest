import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class JawabanMath1A extends JawabanMath1
{
    private GreenfootImage original;
    private boolean enlarged = false;

    public JawabanMath1A() {
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
            
            // ============================================
            // 🔥 TAMBAHAN PENTING:
            // Tandai monster sudah mati sebelum pindah world
            // ============================================
            capybara.isMonster1Dead = true; 
            
            // Pindah ke world Jawaban Benar
            Greenfoot.setWorld(new JawabanBenar());
        }
    }
}