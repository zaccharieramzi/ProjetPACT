package jeu;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Game
{    
    // Single instance is allowed
    private static Game instance;
    
    public Game()
    {
        try
        {
            instance = this;
            Display.create();
            setDisplayMode(800, 600);
            Display.setVSyncEnabled(true);
            Display.setResizable(true);
            gameLoop();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
            System.exit(-1);
        }
    }
    
    // The gameloop. Runs at 60 fps
    private void gameLoop()
    {
        long lastFrame = getCurrentTime();
        long thisFrame = getCurrentTime();
        
        init();
        
        while (!Display.isCloseRequested())
        {
            thisFrame = getCurrentTime();
            
            update(thisFrame - lastFrame);
            render();
            
            Display.update();
            
            if (Display.wasResized())
            {
                resized();
            }
            
            Display.sync(60);
            
            lastFrame = thisFrame;
        }
        
        end();
    }
    
    /**
     * Switch the fullscreen state.
     */
    public static void switchFullscreen()
    {
        setFullscreen(!Display.isFullscreen());
    }
    
    /**
     * Sets the fullscreen state.
     */
    public static void setFullscreen(boolean fullscreen)
    {
        setDisplayMode(Display.getDisplayMode(), fullscreen);
    }
    
   
    public static boolean setDisplayMode(DisplayMode mode, boolean fullscreen)
    {
        return setDisplayMode(mode.getWidth(), mode.getHeight(), fullscreen);
    }
    
  
    public static boolean setDisplayMode(DisplayMode mode)
    {
        return setDisplayMode(mode, false);
    }
    
  
    public static boolean setDisplayMode(int width, int height)
    {
        return setDisplayMode(width, height, false);
    }
   
    public static boolean setDisplayMode(int width, int height, boolean fullscreen)
    {        
        // return if requested DisplayMode is already set
        if ((Display.getDisplayMode().getWidth() == width) && 
            (Display.getDisplayMode().getHeight() == height) && 
            (Display.isFullscreen() == fullscreen))
                return true;
     
        try
        {
            // The target DisplayMode
            DisplayMode targetDisplayMode = null;
     
            if (fullscreen)
            {
                // Gather all the DisplayModes available at fullscreen
                DisplayMode[] modes = Display.getAvailableDisplayModes();
                int freq = 0;
     
                // Iterate through all of them
                for (DisplayMode current : modes)
                {
                    // Make sure that the width and height matches
                    if ((current.getWidth() == width) && (current.getHeight() == height)) 
                    {
                        // Select the one with greater frequency
                        if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) 
                        {
                            // Select the one with greater bits per pixel
                            if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel()))
                            {
                                targetDisplayMode = current;
                                freq = targetDisplayMode.getFrequency();
                            }
                        }
     
                        // if we've found a match for bpp and frequency against the 
                        // original display mode then it's probably best to go for this one
                        // since it's most likely compatible with the monitor
                        if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&
                            (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency()))
                        {
                                targetDisplayMode = current;
                                break;
                        }
                    }
                }
            } 
            else
            {
                // No need to query for windowed mode
                targetDisplayMode = new DisplayMode(width,height);
            }
     
            if (targetDisplayMode == null)
            {
                System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);
                return false;
            }
     
            // Set the DisplayMode we've found
            Display.setDisplayMode(targetDisplayMode);
            Display.setFullscreen(fullscreen);
            
            System.out.println("Selected DisplayMode: " + targetDisplayMode.toString());
            
            // Generate a resized event
            instance.resized();
            
            return true;
        }
        catch (LWJGLException e)
        {
            System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);
        }
        
        return false;
    }
    
 
    public static long getCurrentTime()
    {
        return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }
    
  
    public static void end()
    {
        instance.dispose();
        instance = null;
        Display.destroy();
        System.exit(0);
    }
    
  
    public void init()
    {
    }
    
    
    public void update(long elapsedTime)
    {
    }
    
   
    public void render()
    {
    }
    
  
    public void resized()
    {
    }
    
 
    public void dispose()
    {
    }

}