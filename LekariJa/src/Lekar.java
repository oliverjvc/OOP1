
public abstract class Lekar {
		
	private String ime;
	private String prezime;
	private Pacijent[] pacijenti;
	private int stvarniBroj;
	
	// zasto za ovo izbacuje null pointer exception? zasto je Pacijent[] null onda
	// mislim da je fora to da maksimalni broj koristimo da bi obezbedili dovoljno mesta ali da treba odvojeno da koristimo stvarni kad pretrazujemo niz (da ne bi isli do 200 kad ih ima tipa 10)
	
	/*
		public Lekar(String ime, String prezime, int stvarniBroj) {
			this.ime = ime;
			this.prezime = prezime;
			this.stvarniBroj = stvarniBroj;
			pacijenti = new Pacijent[stvarniBroj];
		}
	*/
	// nije mi samo jasno gde se napuni stvarni broj -- ODGOVOR: Kad procitamo iz fajla 
	public Lekar(String ime, String prezime, int maksimalniBrojPacijenata) {
		this.ime = ime;
		this.prezime = prezime;
		stvarniBroj = 0;
		pacijenti = new Pacijent[maksimalniBrojPacijenata];
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public Pacijent[] getPacijenti() {
		return pacijenti;
	}
	
	public int getStvarniBroj() {
		return stvarniBroj;
	}
	
	//zasto ovo getClass...
	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + ime;
	}
	
	public boolean prihvati(Pacijent p) {
		if(stvarniBroj + 1 < pacijenti.length) {
			pacijenti[stvarniBroj+1] = new Pacijent(p.getIme(), p.getPrezime(), p.getBrojGodina());
			return true;
		}
		return false;
	}
	
	public abstract int plata();
	
	/*
	public String toString() {
		return "ime " + ime + ", prezime " + prezime + ", pacijent " +
	}
	
	*/
 }
