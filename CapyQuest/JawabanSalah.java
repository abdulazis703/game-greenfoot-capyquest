import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JawabanSalah here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JawabanSalah extends World
{

    /**
     * Constructor for objects of class JawabanSalah.
     * 
     */
    public JawabanSalah()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        addObject(new BigCapy(), 91, 459);
        addObject(new BigNormalMonster1(), 674, 423);
        addObject(new TJawabanSalah(), 380, 296);
    }
}
