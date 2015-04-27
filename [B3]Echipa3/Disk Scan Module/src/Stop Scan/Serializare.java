package ip.stop.scan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class Serializare extends File {

    public ListFisier fisier;


  public void setSalvare( ListFisier fisier) {
       try
      {
         FileOutputStream fileOut =
         new FileOutputStream("Salvare.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in Salvare.ser");
      }catch(IOException i){
  }
  }

}