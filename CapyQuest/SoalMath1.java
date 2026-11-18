import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SoalMath1 extends Soal
{
    /**
     * Constructor for objects of class SoalMath1.
     */
    public SoalMath1()
    {
        // ==========================================
        // 🔥 WAJIB DITAMBAHKAN:
        // Mencatat bahwa sekarang kita sedang berada di LEVEL 1
        // ==========================================
        capybara.levelAktif = 1; 
        
        // Tampilkan nyawa (Hati)
        tampilkanNyawa();
        capybara.levelAktif = 1;
        
        // Munculkan objek-objek game
        addObject(new BigCapy(), 107, 483);
        addObject(new BigNormalMonster1(), 652, 458);
        addObject(new JawabanMath1A(), 422, 320);
        addObject(new JawabanMath1B(), 420, 392);
        addObject(new JawabanMath1C(), 429, 470);
        addObject(new JawabanMath1D(), 429, 543);
        addObject(new BaganSoalMath1(), 418, 144);
    }
    
    /**
     * Fungsi untuk menampilkan icon nyawa berjejer
     */
    public void tampilkanNyawa()
    {
        // Pengaturan Posisi
        int jarak = 40;   // Jarak antar hati
        int startX = 50;  // Posisi awal X (kiri)
        int startY = 40;  // Posisi awal Y (atas)
        
        // Looping: Ulangi sebanyak jumlah nyawa yang dimiliki capybara
        for(int i = 0; i < capybara.nyawa; i++)
        {
            // Buat objek nyawa baru
            nyawa objNyawa = new nyawa();
            
            // Masukkan ke world. 
            addObject(objNyawa, startX + (i * jarak), startY);
        }
    }
}