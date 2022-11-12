
public class Pacijent {
	
	private String ime;
	private String prezime;
	private int brojGodina;
	
	public Pacijent(String ime, String prezime, int brojGodina) {
		this.ime = ime;
		this.prezime = prezime;
		this.brojGodina = brojGodina;
	}
	
	public String getIme() {
		return ime;
	}
	
	public String getPrezime() {
		return prezime;
	}
	
	public int getBrojGodina() {
		return brojGodina;
	}
	
	public String toString() {
		return "ime " + ime + ", prezime " + prezime + ", godina " + brojGodina;
	}
	
}
