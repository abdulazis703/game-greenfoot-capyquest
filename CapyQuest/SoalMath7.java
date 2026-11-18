import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SoalMath7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoalMath7 extends Soal
{

    /**
     * Constructor for objects of class SoalMath7.
     * 
     */
    public SoalMath7()
    {
        tampilkanNyawa();
        addObject(new BigCapy(), 107, 483);
        addObject(new BigNormalMonster7(), 652, 458);
        addObject(new JawabanMath7A(), 422, 320);
        addObject(new JawabanMath7B(), 420, 392);
        addObject(new JawabanMath7C(), 422, 468);
        addObject(new JawabanMath7D(), 429, 543);
        addObject(new BaganSoalMath7(), 418, 144);
    }
    
    public void tampilkanNyawa()
    {
        // Pengaturan Posisi
        int jarak = 40;   // Jarak antar hati
        int startX = 50;  // Posisi awal X (kiri)
        int startY = 40;  // Posisi awal Y (atas - pastikan tidak menutupi soal)
        
        // Looping: Ulangi sebanyak jumlah nyawa yang dimiliki capybara
        for(int i = 0; i < capybara.nyawa; i++)
        {
            // Buat objek nyawa baru
            nyawa objNyawa = new nyawa();
            
            // Masukkan ke world. 
            // Rumus X: posisi awal + (urutan * jarak)
            addObject(objNyawa, startX + (i * jarak), startY);
        }
    }
}
