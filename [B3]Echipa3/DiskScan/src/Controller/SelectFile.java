package Controller;

import Model.Fisier;
import Model.ListFisier;

/**
 * Created by lenovo on 4/27/2015.
 */
public class SelectFile {

    ListFisier fileList = new ListFisier();
    Fisier file = new Fisier();

    public Fisier getFile() {
        return file;
    }



    public Fisier SelectOneFile(Fisier f)
    {
        for(int i=0; i< fileList.listFisierSize(); i++ )
        {
            if(f == fileList.getFisier(i))
                return f;
        }
        return null;
    }

}
