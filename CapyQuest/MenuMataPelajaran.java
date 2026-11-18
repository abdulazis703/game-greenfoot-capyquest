import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuMataPelajaran here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuMataPelajaran extends World
{

    /**
     * Constructor for objects of class MenuMataPelajaran.
     * 
     */
    public MenuMataPelajaran()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        addObject(new TabelMataPelajaran(), 401, 315);
        addObject(new Matematika(), 400, 244);
        addObject(new IPA(), 396, 330);
        addObject(new IPS(), 405, 419);
        addObject(new Kembali(), 408, 526);
    }
}
