/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclicker;
import java.awt.Robot;
import java.awt.event.InputEvent;
/**
 *
 * @author vileelf
 */
public class AutoClicker extends Thread{
    
    /**
     * @param args the command line arguments
     */
    boolean loop;
    int ms;
    AutoClicker(){
        loop=true;
        this.ms=1;
    }
    AutoClicker(int ms){
        loop=true;
        this.ms=ms;
    }
    public void run(){
        //start the autoclicker
        try {
            Robot r = new Robot();
            while(loop){
                Thread.sleep(ms);
                r.mousePress(InputEvent.BUTTON1_MASK);
                r.mouseRelease(InputEvent.BUTTON1_MASK);
            }
        }
        catch(Exception e){
            
        }
    }
    public void stopclick(){
        //stop the autoclicker
        loop=false;
    }
    
    public void startclick(){
        loop=true;
    }
    
    public void setMs(int ms){
        this.ms=ms;
    }
    
}
