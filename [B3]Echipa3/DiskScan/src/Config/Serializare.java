/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author user
 */
public class Serializare {
    public void processSolution() {

        try {
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Save.ser"));
            o.writeObject(this);
            o.close();
        } 
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }
}
