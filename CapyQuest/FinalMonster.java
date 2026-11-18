import greenfoot.*;

public class FinalMonster extends Actor
{
    private double frame = 0;     // untuk animasi sinus
    private int baseY;            // posisi Y asli

    public void addedToWorld(World w)
    {
        baseY = getY();   // simpan posisi awal
    }

    public void act()
    {
        breathe();
    }

    private void breathe()
    {
        frame += 0.08;  // semakin kecil semakin halus

        int offset = (int)(Math.sin(frame) * 2); 
        // *2 = naik turun 2 pixel. Bisa kamu ubah jadi 3 atau 4

        setLocation(getX(), baseY + offset);
    }
}
