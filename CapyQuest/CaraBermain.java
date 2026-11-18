import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CaraBermain extends World
{
    public CaraBermain()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // 🔥 Panggil Musik Menu (ScreenCapy.wav)
        // Ini akan otomatis mematikan musik Battle.wav jika sedang menyala
        capybara.putarMusikMenu();
        
        // Siapkan objek-objek (Tombol, dll)
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Masukkan tombol Kembali
        Xkembali xkembali = new Xkembali();
        addObject(xkembali, 751, 43);

        // Masukkan tombol Selanjutnya
        ButtonSelanjutnya buttonSelanjutnya = new ButtonSelanjutnya();
        addObject(buttonSelanjutnya, 750, 547);
    }
}