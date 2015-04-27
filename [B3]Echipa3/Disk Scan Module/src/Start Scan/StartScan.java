/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ip5;

/**
 *
 * @author user
 */
public class StartScan {
    private String path;
    private Scan scanare;
    private int state = 0;
    
    public StartScan(String path){
        this.path = path;
        updateScan();
    }
    
    public void updateScan(){
        if(state == 0){
            scanare = new Scan();
            scanare.beginScan(path);
            changeState();
        }
    }
    
    public void changeState(){
        switch(state){
            case 0:
                this.state = 1;
                break;
            case 1:
                this.state = 0;
                break;
        }
    }
    
    public Scan sendInformation(){
        return this.scanare;
    }
}
