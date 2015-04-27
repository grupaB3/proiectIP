package RestoreFilePackage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 4/27/2015.
 */
public class ListFile implements Serializable {


    List<File> listFile = new ArrayList<File>();

    public List<File> getListFile() {
        return listFile;
    }

    public void setListFile(List<File> listFile) {
        this.listFile = listFile;
    }

    public void addFile (File file)
    {
        this.listFile.add(file);
    }

    public void removeFile (File file)
    {
        this.listFile.remove(file);
    }

    public File getFile(int index)
    {
        return listFile.get(index);
    }

    public void serialization() {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this.listFile);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();

        }
    }

    public void deserialization()
    {

        try
        {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.listFile = (List<File>) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
    }

    public int listFileSize()
    {
        return listFile.size();
    }


}
