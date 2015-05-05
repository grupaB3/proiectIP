package Model;
import Model.Fisier;
import java.util.Set;


public class Diff {
	public static Scan computeDifferences(Scan oldScan, Scan newScan) {
		//TO DO: add code for computing differences
		Set<Fisier> hash;
		Scan result = new Scan
		for(auto x: oldScan.getFileList()) {
			hash.add(x);
		}
		Scan result = newScan.clone();
		result.setFileList(new ListFisier());
		for(auto x: newScan.getFileList()) {
			if(hash.contains(x) == false)
				result.addFile(x);
		}
		return result;
	}
}
