import java.io.IOException;

public class Glavna {
	
	public static void main(String[] args) throws IOException {
		
		Poliklinika poliklinika = new Poliklinika();
		
		Pulmolog saNajmanjomPlatom = poliklinika.vratiPulmologaSaNajmanjom();
		
		if(saNajmanjomPlatom == null) {
			System.out.println("Greska");
		} else {
			System.out.println("Pulmolog sa najmanjom platom je: " +saNajmanjomPlatom.getIme() +" "+ saNajmanjomPlatom.getPrezime());
		}
		
		Pedijatar pedo = poliklinika.najstarijiPedijatar();
		if(pedo == null) {
			System.out.println("greska :( ");
		} else {
			System.out.println("Pedijatar sa najstarijim prosekom pacijenata je: " + pedo.getIme() +" "+ pedo.getPrezime());
		}
		
		System.out.println("Proveravam da li ima ostalih u listi " + poliklinika.getRandom().getIme());
	}
}
