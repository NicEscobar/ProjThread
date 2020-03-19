/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStream;

import java.util.logging.Level;

import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.AudioData;

import sun.audio.AudioPlayer;

import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
/**
 *
 * @author Aguinaldo
 */
public class Som extends Thread {
    
     boolean f = false;
    private static boolean stopThreadVariable =  false;
    
    public static void setStopThreadVariable(boolean stopThreadVariable){
        Som.stopThreadVariable = stopThreadVariable;
        
    }
    @Override
    
    public void run()
    {
       
        AudioInputStream inputStream;
        try {
            inputStream = AudioSystem.getAudioInputStream(new File("src\\Music\\dano.wav"));
            Clip clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                Thread.sleep(10000); // looping as long as this thread is alive
           
           } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Som.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Som.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Som.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Som.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
        
        
    }
    
