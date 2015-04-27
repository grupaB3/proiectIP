package RestoreFilePackage;

/**
 * Created by lenovo on 4/27/2015.
 */
public class SelectFile {

    ListFile fileList = new ListFile();
    File file = new File();

    public File getFile() {
        return file;
    }



    public File SelectOneFile(File f)
    {
        for(int i=0; i< fileList.listFileSize(); i++ )
        {
            if(f == fileList.getFile(i))
                return f;
        }
        return null;
    }

}
