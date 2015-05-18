package diskscan;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		int i;
		Scanner input = new Scanner(System.in);
		DiskPartition listDisk = new DiskPartition();
		for(i = 0; i < listDisk.getPhysDrives().size(); i++)
			System.out.println(listDisk.getPhysDrives().get(i));
//		System.out.println("Selectati disk-ul de scanat:");
//		int numberDisk = input.nextInt();
		Scan scanare = new Scan(String.valueOf(listDisk.getPhysDrives().get(0)));
	}

}
