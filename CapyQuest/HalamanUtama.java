import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HalamanUtama extends World
{
    public HalamanUtama()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        // 🔥 PENTING: Nyalakan Musik Menu
        // Saat game dibuka, lagu ScreenCapy.wav akan berbunyi.
        capybara.putarMusikMenu();
        
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Masukkan Tombol
        addObject(new TombolMulai(), 406, 403);
        addObject(new TombolCaraBermain(), 417, 488);

        // Masukkan Hiasan Awan
        addObject(new AwanSmall(), 73, 70);
        addObject(new AwanBig(), 125, 169);
        addObject(new AwanMedium(), 353, 127);
        addObject(new AwanBig(), 644, 63);

        // Masukkan Judul Game
        addObject(new JudulCapy(), 417, 157);
    }
}