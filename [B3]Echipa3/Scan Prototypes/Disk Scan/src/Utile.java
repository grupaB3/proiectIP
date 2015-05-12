import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Utile {

	public static byte[] getReverseBytes(byte[] obj1) {
		byte[] obj = obj1.clone();
		for(int i = 0, j = obj.length - 1; i < j; i++, j--) {
			byte aux = obj[i];
			obj[i] = obj[j];
			obj[j] = aux;
		}
		return obj;
	}
}
