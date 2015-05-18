package diskscan;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Serialize {
	public Serialize(MasterFileTable mft, String physDrive){
		Serializer serializer = new Persister();
		DateFormat dateFormat = new SimpleDateFormat("[dd][MM][yyyy]");
		Date date = new Date();
		File output = new File("Scan_" + physDrive + "_" + dateFormat.format(date) + ".xml");
		try{
			serializer.write(mft, output);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
