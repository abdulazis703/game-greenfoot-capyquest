import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class CaraBermain2 extends World
{
    public CaraBermain2()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        // 🔥 Panggil Musik Menu
        // Ini memastikan musik "ScreenCapy.wav" terus berlanjut
        // dan tidak diganti dengan musik Battle.
        capybara.putarMusikMenu();
        
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Masukkan tombol Sebelumnya
        ButtonSebelumnya buttonSebelumnya = new ButtonSebelumnya();
        addObject(buttonSebelumnya, 53, 557);
        
        // (Opsional) Jika ingin menambah tombol X (Kembali) di sini juga:
        // addObject(new Xkembali(), 751, 43);
    }
}