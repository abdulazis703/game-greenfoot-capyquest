import greenfoot.*;

public class IPAWorld extends World
{
    public int health = 3;     // ★★★ jumlah nyawa capybara
    private nyawa nyawa1, nyawa2, nyawa3;  // ★★★ reference supaya bisa dihapus

    public IPAWorld()
    {    
        super(800, 600, 1); 
        
        addObject(new capybara(), 36, 61);
        addObject(new FinalMonster(), 682, 532);

        // WallHeightBig
        addObject(new WallHeightBig(), 790, 248);
        addObject(new WallHeightBig(), 13, 356);

        // WallHeightSmall
        addObject(new WallHeightSmall(), 181, 344);
        addObject(new WallHeightSmall(), 317, 258);
        addObject(new WallHeightSmall(), 502, 343);
        addObject(new WallHeightSmall(), 632, 257);

        // WallWidthBig
        addObject(new WallWidthBig(), 406, 588);
        addObject(new WallWidthBig(), 397, 15);

        // WallWidthSmall
        addObject(new WallWidthSmall(), 358, 106);
        addObject(new WallWidthSmall(), 442, 205);
        addObject(new WallWidthSmall(), 365, 390);
        addObject(new WallWidthSmall(), 457, 489);

        // NormalMonster
        addObject(new IPANormalMonster3(), 115, 254);
        addObject(new IPANormalMonster4(), 410, 289);
        addObject(new IPANormalMonster5(), 728, 332);
        
        // NormalMonsterMirror
        addObject(new IPANormalMonster1(), 605, 156);
        addObject(new IPANormalMonster2(), 247, 150);
        addObject(new IPANormalMonster6(), 496, 441);
        addObject(new IPANormalMonster7(), 161, 436);
        
        
        // ★★★ Tambah nyawa dgn reference
        nyawa1 = new nyawa();
        nyawa2 = new nyawa();
        nyawa3 = new nyawa();

        addObject(nyawa1, 677, 25);
        addObject(nyawa2, 722, 25);
        addObject(nyawa3, 767, 25);
    }

    // ★★★ fungsi untuk mengurangi nyawa
    public void kurangiNyawa()
    {
        if (health <= 0) return;

        health--;

        if (health == 2) removeObject(nyawa3);
        if (health == 1) removeObject(nyawa2);
        if (health == 0) removeObject(nyawa1);

        System.out.println("Nyawa tersisa: " + health);

        // kalau mau: Game Over
        if (health == 0) {
            Greenfoot.stop();
            System.out.println("GAME OVER");
        }
    }
}
