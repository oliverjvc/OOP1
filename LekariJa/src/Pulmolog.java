
public class Pulmolog extends Lekar {
	
	public Pulmolog (String ime, String prezime) {
		super(ime, prezime, 200);
	}
	
	@Override
	public int plata() {
		int platica = 0;
		for(int i = 0; i < getPacijenti().length; i++){
			platica += 500;
		}
		return platica;
	}
	
	public boolean prihvati(Pacijent p) {
		super.prihvati(p);
		return true;
	}
	
}
