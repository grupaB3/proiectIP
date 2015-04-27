
public class ListFisier {
	private Fisier[] fisiere;
	private Serializare salvare;
	private Deserializare citire;
	public void addFisier(Fisier fisierul){
		fisiere[fisiere.length] = fisierul;
	}
	public void removeFisier(Fisier fisierul){
		for(int i = 0; i<fisiere.length; i++)
			if(fisiere[i].equals(fisierul))
				for(int j = i; j<fisiere.length-1; j++)
					fisiere[j] = fisiere[j+1];
	}
	public Fisier[] getList(){
		return this.fisiere;
	}
}
