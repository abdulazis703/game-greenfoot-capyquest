import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class TJawabanBenar extends Button
{
    // Timer untuk menghitung mundur
    private int timer = 0;
    
    // 300 act = 5 detik (karena Greenfoot biasanya 60 act/detik)
    private int durasi = 50; 

    public void act()
    {
        // Kita HAPUS hoverEffect() dan clickAction() 
        // karena pop-up ini jalan otomatis, tidak perlu diklik.
        
        timer++; // Tambah waktu terus menerus
        
        // Jika waktu sudah sampai 5 detik
        if (timer >= durasi) 
        {
            kembaliKeMap();
        }
    }

    private void kembaliKeMap()
    {
        // ==========================================
        // 🔥 LOGIKA PENTING
        // ==========================================
        
        // 1. Matikan Monster
        // (PENTING: Pastikan ini sesuai level. Jika Soal 1, matikan Monster 1)
        capybara.isMonster1Dead = true; 
        
        // 2. Hapus pop-up ini dari layar
        getWorld().removeObject(this);

        // 3. Kembali ke Dunia Utama
        // Pastikan nama world utamamu benar (misal: WorldMatematika atau MatematikaWorld)
        Greenfoot.setWorld(new MatematikaWorld());
    }
}