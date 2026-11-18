import greenfoot.*;

public class IPANormalMonster2 extends Monster
{
    private int breathFrame = 0;
    private int baseY = 0;
    private boolean baseYSet = false;

    public void act()
    {
        if (!baseYSet)
        {
            baseY = getY();  // posisi Y awal disimpan sekali
            baseYSet = true;
        }

        animateBreathing();
    }

    private void animateBreathing()
    {
        breathFrame++;

        // nafas halus naik turun 2 piksel
        int offset = (int)(Math.sin(breathFrame * 0.15) * 2);

        setLocation(getX(), baseY + offset);
    }
    

}
