import greenfoot.*;

public class capybara extends Actor
{
    // ==========================================
    // 🔥 DATA GLOBAL (MEMORY GAME)
    // ==========================================
    public static int nyawa = 3;
    public static int levelAktif = 1;
    
    // ==========================================
    // 🎵 UPDATE MUSIK: DUA LAGU
    // ==========================================
    
    // 1. Lagu Battle (Untuk Map & Soal)
    public static GreenfootSound bgm = new GreenfootSound("Battle.wav");
    
    // 2. Lagu Menu (Untuk Halaman Utama & Cara Bermain)
    public static GreenfootSound bgmMenu = new GreenfootSound("ScreenCapy.wav");
    
    // ==========================================
    
    // Status kematian monster (1 sampai 7)
    public static boolean isMonster1Dead = false;
    public static boolean isMonster2Dead = false;
    public static boolean isMonster3Dead = false;
    public static boolean isMonster4Dead = false;
    public static boolean isMonster5Dead = false;
    public static boolean isMonster6Dead = false;
    public static boolean isMonster7Dead = false;
    
    // Variable untuk menyimpan posisi terakhir
    public static int lastX = 36; 
    public static int lastY = 61;

    // ==========================================
    
    private int speed = 3;
    private GreenfootImage imgRight;
    private GreenfootImage imgLeft;
    private double breathFrame = 0;
    private int realY;      
    private boolean moving;
    private boolean sudahKenaMonster = false;

    public capybara()
    {
        imgRight = getImage();
        imgLeft = new GreenfootImage(imgRight);
        imgLeft.mirrorHorizontally();
    }

    public void addedToWorld(World w)
    {
        realY = getY();     
        sudahKenaMonster = false; 
    }

    public void act()
    {
        checkMouse();
        moveCapy();
        animateBreathing();
        cekTabrakanMonster();   
        tampilkanInfoNyawa();
    }
    
    public void tampilkanInfoNyawa() {
        // Optional debugging
    }
    
    // ==========================================
    // 🎵 PENGATURAN MUSIK (LOGIKA BARU)
    // ==========================================
    
    // 1. Putar Lagu BATTLE (Dipanggil di Map & Soal)
    public static void putarMusik()
    {
        // Matikan musik menu jika sedang bunyi
        if (bgmMenu.isPlaying()) {
            bgmMenu.stop();
        }

        // Putar musik battle jika belum bunyi
        if (bgm.isPlaying() == false) {
            bgm.setVolume(50); 
            bgm.playLoop();
        }
    }
    
    // 2. Putar Lagu MENU (Dipanggil di HalamanUtama/CaraBermain)
    public static void putarMusikMenu()
    {
        // Matikan musik battle jika sedang bunyi
        if (bgm.isPlaying()) {
            bgm.stop();
        }
        
        // Putar musik menu jika belum bunyi
        if (bgmMenu.isPlaying() == false) {
            bgmMenu.setVolume(50); 
            bgmMenu.playLoop();
        }
    }
    
    // 3. Stop Semua (Untuk Reset/Keluar)
    public static void stopMusik()
    {
        bgm.stop();
        bgmMenu.stop();
    }

    // ==========================================

    public void checkMouse()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            if (mouse.getButton() == 1) setImage(imgLeft);
            else if (mouse.getButton() == 3) setImage(imgRight);
        }
    }

    public void moveCapy()
    {
        int x = getX();
        moving = false;

        if (Greenfoot.isKeyDown("left")) {
            moving = true;
            if (getOneObjectAtOffset(-speed, 0, walls.class) == null) x -= speed;
            setImage(imgLeft);
        }
        if (Greenfoot.isKeyDown("right")) {
            moving = true;
            if (getOneObjectAtOffset(speed, 0, walls.class) == null) x += speed;
            setImage(imgRight);
        }
        if (Greenfoot.isKeyDown("up")) {
            moving = true;
            if (getOneObjectAtOffset(0, -speed, walls.class) == null) realY -= speed;
        }
        if (Greenfoot.isKeyDown("down")) {
            moving = true;
            if (getOneObjectAtOffset(0, speed, walls.class) == null) realY += speed;
        }

        if (moving) {
            breathFrame = 0;
            setLocation(x, realY);
        }
    }

    public void animateBreathing()
    {
        if (!moving) {
            breathFrame += 0.15;
            int offset = (int)(Math.sin(breathFrame) * 2);
            setLocation(getX(), realY + offset);
        }
    }

    public void cekTabrakanMonster()
    {
        // Jangan cek tabrakan lagi jika barusan kena
        if (sudahKenaMonster) return;

        // --- MONSTER 1 ---
        if (isTouching(NormalMonster1.class) && !isMonster1Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath1());
        }
        
        // --- MONSTER 2 ---
        else if (isTouching(NormalMonster2.class) && !isMonster2Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath2());
        }
        
        // --- MONSTER 3 ---
        else if (isTouching(NormalMonster3.class) && !isMonster3Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath3());
        }

        // --- MONSTER 4 ---
        else if (isTouching(NormalMonster4.class) && !isMonster4Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath4());
        }

        // --- MONSTER 5 ---
        else if (isTouching(NormalMonster5.class) && !isMonster5Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath5());
        }

        // --- MONSTER 6 ---
        else if (isTouching(NormalMonster6.class) && !isMonster6Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath6());
        }

        // --- MONSTER 7 ---
        else if (isTouching(NormalMonster7.class) && !isMonster7Dead)
        {
            persiapanPindahWorld();
            Greenfoot.setWorld(new SoalMath7());
        }
    }
    
    private void persiapanPindahWorld() 
    {
        sudahKenaMonster = true;
        lastX = getX();
        lastY = getY();
        Greenfoot.delay(5);
    }

    // ==========================================
    // 🔄 FUNGSI RESET DATA (Update)
    // ==========================================
    public static void resetGame()
    {
        stopMusik(); // 🔥 Matikan SEMUA musik dulu
        
        nyawa = 3;                
        
        // Reset semua status monster jadi hidup kembali
        isMonster1Dead = false;
        isMonster2Dead = false;
        isMonster3Dead = false;
        isMonster4Dead = false;
        isMonster5Dead = false;
        isMonster6Dead = false;
        isMonster7Dead = false;
        
        // Reset posisi kembali ke start awal
        lastX = 36;
        lastY = 61;
        
        // Nyalakan musik Battle (Asumsi reset berarti main lagi)
        putarMusik(); 
    }
}