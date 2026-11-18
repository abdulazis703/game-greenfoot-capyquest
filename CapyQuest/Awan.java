import greenfoot.*;

public class Awan extends Actor
{
    private int speed;
    private boolean movingRight; // Variabel baru untuk melacak arah: true = kanan, false = kiri

    /**
     * Constructor untuk kelas Awan.
     * @param initialSpeed Kecepatan awal.
     * @param startsRight Apakah awan mulai bergerak ke kanan?
     */
    public Awan(int initialSpeed, boolean startsRight) {
        // Kecepatan akan menjadi positif (ke kanan) atau negatif (ke kiri)
        if (startsRight) {
            this.speed = initialSpeed; 
        } else {
            this.speed = -initialSpeed; 
        }
        this.movingRight = startsRight;
    }

    public void act()
    {
        moveCloud();
    }

    private void moveCloud()
    {
        World w = getWorld();
        if (w == null) return; // Lindungi jika dunia belum ada

        // Geser awan
        setLocation(getX() + speed, getY());

        int lebarAwanSetengah = getImage().getWidth() / 2;
        
        // --- LOGIKA MEMANTUL (BOUNCING) ---

        // 1. Cek jika awan mencapai tepi kanan
        // Jika pusat awan melewati batas kanan dikurangi setengah lebar awan
        if (getX() >= w.getWidth() - lebarAwanSetengah) {
            // Ubah arah (speed dibalik)
            speed = -Math.abs(speed); // Pastikan speed menjadi negatif
            movingRight = false;
        }
        
        // 2. Cek jika awan mencapai tepi kiri
        // Jika pusat awan melewati batas kiri ditambah setengah lebar awan
        if (getX() <= lebarAwanSetengah) {
            // Ubah arah (speed dibalik)
            speed = Math.abs(speed); // Pastikan speed menjadi positif
            movingRight = true;
        }
    }
}