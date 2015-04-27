/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip5;
import java.lang.*;
/**
 *
 * @author user
 */
public class ScanDetails {
    private int currentDuration;
    private double totalDuration;
    private double progress;
    private float speed;
    private long totalMemory;
    private long progressMemory;
    
    public int getCurrentDuration(){
        return this.currentDuration;
    }
    
    public void calculateTotalDuration(){
        totalDuration = Math.floor(totalMemory/speed);
    }
    
    public double getTotalDuration(){
        return this.totalDuration;
    }
    
    public void calculateProgress(){
        progress = currentDuration/totalDuration*100;
    }
    
    public double getProgress(){
        return this.progress;
    }
    
    public void setSpeed(){
        
    }
    
    public float getSpeed(){
        return this.speed;
    }
    
    public void setTotalMemory(long totalMemory){
        this.totalMemory = totalMemory;
    }
    
    public void calculateProgressMemory(){
        
    }
    
    public long getProgressMemory(){
        return this.progressMemory;
    }
}
