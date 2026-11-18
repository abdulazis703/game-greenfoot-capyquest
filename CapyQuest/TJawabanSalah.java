import greenfoot.*;

public class TJawabanSalah extends Button
{
    private int timer = 0;
    private int durasi = 50; 

    public void act()
    {
        timer++;
        if (timer >= durasi) 
        {
            eksekusiHukuman();
        }
    }

    private void eksekusiHukuman()
    {
        // 1. Kurangi Nyawa
        capybara.nyawa = capybara.nyawa - 1;
        
        // 2. Cek apakah Game Over?
        if (capybara.nyawa <= 0) 
        {
            Greenfoot.stop(); // Atau pindah ke GameOverWorld
        } 
        else 
        {
            // ==========================================
            // 🔥 LOGIKA BARU: BACA CATATAN LEVEL
            // ==========================================
            
            // Kita tidak cek 'getWorld()' lagi, tapi cek 'capybara.levelAktif'
            
            if (capybara.levelAktif == 1) {
                Greenfoot.setWorld(new SoalMath1());
            }
            else if (capybara.levelAktif == 2) {
                Greenfoot.setWorld(new SoalMath2());
            }
            else if (capybara.levelAktif == 3) {
                Greenfoot.setWorld(new SoalMath3());
            }
            else if (capybara.levelAktif == 4) {
                Greenfoot.setWorld(new SoalMath4());
            }
            else if (capybara.levelAktif == 5) {
                Greenfoot.setWorld(new SoalMath5());
            }
            else if (capybara.levelAktif == 6) {
                Greenfoot.setWorld(new SoalMath6());
            }
            else if (capybara.levelAktif == 7) {
                Greenfoot.setWorld(new SoalMath7());
            }
            else if (capybara.levelAktif == 8) {
                Greenfoot.setWorld(new SoalMath8());
            }
            else if (capybara.levelAktif == 9) {
                Greenfoot.setWorld(new SoalMath9());
            }
            else if (capybara.levelAktif == 10) {
                Greenfoot.setWorld(new SoalMath10());
            }
            else {
                // Kalau muncul ini, berarti kamu lupa tulis 'capybara.levelAktif = ...' di SoalMath
                System.out.println("ERROR: Level tidak diketahui! Cek Constructor SoalMath kamu.");
            }
        }
        
        // Hapus pop up (opsional)
        if (getWorld() != null) {
            getWorld().removeObject(this); 
        }
    }
}