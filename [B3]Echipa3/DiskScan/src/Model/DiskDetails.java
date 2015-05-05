/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.io.*;
/**
 *
 * @author user
 */
public class DiskDetails {
    private String type;
    private String format;
    private long totalMemory;
    private long usedMemory;
    private long freeMemory;
    
    public DiskDetails(String path){
        File fisierul = new File(path);
        setType();
        setFormat();
        setTotalMemory(fisierul);
        setFreeMemory(fisierul);
        setUsedMemory(fisierul);
    }
    
    private void setType(){
        
    }
    
    public String getType(){
        return this.type;
    }
    
    private void setFormat(){
        
    }
    
    public String getFormat(){
        return this.format;
    }
    
    private void setTotalMemory(File fisierul){
        totalMemory = fisierul.getTotalSpace();
    }
    
    public long getTotalMemory(){
        return this.totalMemory;
    }
    
    private void setUsedMemory(File fisierul){
        usedMemory = this.totalMemory - this.freeMemory;
    }
    
    public long getUsedMemory(){
        return this.usedMemory;
    }
    
    private void setFreeMemory(File fisierul){
        freeMemory = fisierul.getUsableSpace();
    }
    
    public long getFreeMemory(){
        return this.freeMemory;
    }
}
