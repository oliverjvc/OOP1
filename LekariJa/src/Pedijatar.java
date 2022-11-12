
public class Pedijatar extends Lekar {
	
	
	public Pedijatar(String ime, String prezime) {
		super(ime, prezime, 200);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean prihvati(Pacijent p) {
		if(p.getBrojGodina() < 18) {
			super.prihvati(p);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int plata() {
		int plata = 0;
		for(int i = 0; i < getStvarniBroj(); i++) {
			if(getPacijenti()[i].getBrojGodina() < 18) {
				plata += 300;
				if(getPacijenti()[i].getBrojGodina() < 5) {
					plata += 100;
				}
			}
		}
		return plata;
	}

}
