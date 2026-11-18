import greenfoot.*;

public class TombolMulai extends Button
{
    private GreenfootImage original;   // gambar asli
    private boolean enlarged = false;  // apakah sedang membesar?

    public TombolMulai() {
        original = new GreenfootImage(getImage()); // simpan gambar asli
    }

    // 🔥 HANYA BOLEH ADA SATU act()
    public void act()
    {
        hoverEffect(); // Cek animasi membesar
        checkClick();  // Cek apakah diklik
    }

    private void hoverEffect()
    {
        // Jika mouse berada di atas tombol → perbesar
        if (Greenfoot.mouseMoved(this)) {
            if (!enlarged) {
                GreenfootImage big = new GreenfootImage(original);
                big.scale((int)(original.getWidth() * 1.12), (int)(original.getHeight() * 1.12));
                setImage(big);
                enlarged = true;
            }
        }

        // Jika mouse pindah ke tempat lain → kembali normal
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            if (enlarged) {
                setImage(original);
                enlarged = false;
            }
        }
    }

    // Method khusus untuk menangani klik
    private void checkClick()
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("button.wav"); // Jika ada suara
            
            // 🔥 WAJIB: Reset semua data sebelum masuk game
            // Pastikan kamu sudah menambahkan method 'resetGame()' di class capybara
            capybara.resetGame(); 
            
            // Masuk ke Menu Mata Pelajaran (sesuai request kodemu)
            Greenfoot.setWorld(new MenuMataPelajaran());
        }
    }
}