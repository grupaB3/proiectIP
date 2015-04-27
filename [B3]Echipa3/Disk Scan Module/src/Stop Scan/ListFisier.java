package ip.stop.scan;

import java.util.Vector;

public class ListFisier {

    private File[] files;
    private Serializare save;

  public void Add_Files(File myFile) {
      files[files.length]=myFile;
  }

  public File[] getList() {
      return this.files;
  }
    
  public void removeFisier(File myFile){
        for(int i = 0; i<files.length; i++)
            if(files[i].equals(myFile))
                for(int j = i; j<files.length-1; j++)
                    files[j] = files[j+1];
    }
  
}