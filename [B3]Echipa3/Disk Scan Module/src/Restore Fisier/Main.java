package Main;

import RestoreFilePackage.File;
import RestoreFilePackage.ListFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {

    public static void main(String[] args) {
        File f1 = new File();
        File f2 = new File();
        File f3 = new File();

        ListFile list = new ListFile();

        list.addFile(f1);
        list.addFile(f2);
        list.addFile(f3);

        list.serialization();
        list.deserialization();
    }
}
