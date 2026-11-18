import greenfoot.*;

public class MatematikaWorld extends World
{
    // Kita tidak perlu 'public int health' lagi di sini
    // karena kita baca langsung dari 'capybara.nyawa'

    public MatematikaWorld()
    {    
        super(800, 600, 1); 
        
        // 🔥 TAMBAHAN BARU: MUSIK
        // Panggil musik saat world dibuat.
        // Karena method di capybara sudah pintar, musik tidak akan restart dari awal.
        capybara.putarMusik();
        
        prepare();
    }

    private void prepare()
    {
        // ==========================================
        // 🔥 UPDATE PENTING: POSISI CAPYBARA DINAMIS
        // ==========================================
        // Capybara muncul di tempat terakhir dia berdiri (disimpan di variable static)
        addObject(new capybara(), capybara.lastX, capybara.lastY);
        
        
        // 2. Tambah Final Boss
        addObject(new FinalMonster(), 682, 532);

        // ==========================================
        // 🧱 DINDING / WALLS
        // ==========================================
        
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

        // ==========================================
        // 👹 MONSTER (LOGIKA MEMORI LENGKAP)
        // ==========================================
        // Kita cek status kematian SETIAP monster agar tidak muncul lagi jika sudah mati
        
        // Monster 1
        if (!capybara.isMonster1Dead) {
             addObject(new NormalMonster1(), 605, 169);
        }

        // Monster 2
        if (!capybara.isMonster2Dead) {
            addObject(new NormalMonster2(), 247, 150);
        }

        // Monster 3
        if (!capybara.isMonster3Dead) {
            addObject(new NormalMonster3(), 115, 254);
        }

        // Monster 4
        if (!capybara.isMonster4Dead) {
            addObject(new NormalMonster4(), 410, 289);
        }

        // Monster 5
        if (!capybara.isMonster5Dead) {
            addObject(new NormalMonster5(), 728, 332);
        }

        // Monster 6
        if (!capybara.isMonster6Dead) {
            addObject(new NormalMonster6(), 496, 441);
        }

        // Monster 7
        if (!capybara.isMonster7Dead) {
            addObject(new NormalMonster7(), 161, 436);
        }
        
        
        // ==========================================
        // ❤️ TAMPILAN NYAWA (Sinkron dengan capybara.nyawa)
        // ==========================================
        showHealth();
    }

    // Fungsi untuk menampilkan hati berdasarkan sisa nyawa
    private void showHealth()
    {
        // Ambil data dari static variable
        int sisaNyawa = capybara.nyawa;

        // Tampilkan hati sesuai jumlah nyawa
        if (sisaNyawa >= 1) {
            addObject(new nyawa(), 677, 25);
        }
        if (sisaNyawa >= 2) {
            addObject(new nyawa(), 722, 25);
        }
        if (sisaNyawa >= 3) {
            addObject(new nyawa(), 767, 25);
        }
        
        // Cek Game Over saat World dimuat
        if (sisaNyawa <= 0) {
             // System.out.println("GAME OVER");
             // Greenfoot.setWorld(new GameOverWorld()); // Aktifkan jika punya world game over
             Greenfoot.stop();
        }
    }
}