import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Poliklinika {
	
	private Lekar[] lekari;
	
	public Poliklinika() throws IOException {
		ucitajLekare();
		ucitajPacijente();
	}
	
	public void ucitajLekare() throws IOException{
		BufferedReader in = new BufferedReader(new FileReader ("Lekari.txt"));
		int stvarniBroj = Integer.parseInt(in.readLine());
		lekari = new Lekar[stvarniBroj];
		
		for(int i = 0; i < stvarniBroj; i++) {
			String ime = in.readLine();
			String prezime = in.readLine();
			String zanimanje = in.readLine();
			
			if(zanimanje.equalsIgnoreCase("pedijatar")){
				lekari[i] = new Pedijatar(ime, prezime);
			} else if(zanimanje.equalsIgnoreCase("pulmolog")) {
				lekari[i] = new Pulmolog(ime, prezime);
			}
		}
		in.close();
	}
	
	public void ucitajPacijente() throws IOException{	
		BufferedReader in = new BufferedReader(new FileReader("Pacijenti.txt"));
		int brojPacijenata = Integer.parseInt(in.readLine().trim());
		Random randomGenerator = new Random();
		
		
		for(int i = 0; i < brojPacijenata; i++) {
			String ime = in.readLine().trim();
			String prezime = in.readLine().trim();
			int brojGodina = Integer.parseInt(in.readLine().trim());
			
			Pacijent pacijent = new Pacijent(ime, prezime, brojGodina);
			Lekar lekar = lekari[randomGenerator.nextInt(lekari.length)];
			lekar.prihvati(pacijent);
		}
		in.close();
	}
	
	public Lekar getRandom() {
		int index = (int) (Math.random() * lekari.length);
		Lekar l = lekari[index];
		return l;
	}
	
	public Pulmolog vratiPulmologaSaNajmanjom() {
		int najmanja = 0;
		Pulmolog sirotinja = null;
		for(int i = 0; i < lekari.length; i++) {
			if(lekari[i] instanceof Pulmolog) {
				// ovde ide || sirotinja == null da bi prvog koji naidje stavili na mesto minimuma a nikad nece okinuti jer plata nikad nece biti manja od najmanje tj. od nule
				if(lekari[i].plata() < najmanja || sirotinja == null) {
					najmanja = lekari[i].plata();
					sirotinja = (Pulmolog) lekari[i];
				}
			}
		}
		return sirotinja;
	}
	
	/*
	 * public Pulmolog vratiPulmologaSaNajmanjom() {
		Pulmolog sirotinja = null;
		for(int i = 0; i < lekari.length; i++) {
			if(lekari[i] instanceof Pulmolog &&(sirotinja == null || lekari[i].plata() < sirotinja.plata())) {
					sirotinja = (Pulmolog) lekari[i];
			}
		}
		return sirotinja;
	}
	 */
	
	// vraca metod koji je pedijatar sa u proseku najstarijim pacijentima, ispravi ovaj kod
	public Pedijatar najstarijiPedijatar() {
		Pedijatar pediijatar = null;
		double najveciProsek = 0;
		for(int i = 0; i < lekari.length; i++) {
			if(lekari[i] instanceof Pedijatar) {
				if(pediijatar == null || prosekGodinaPacijenta(lekari[i])> najveciProsek) {
					pediijatar = (Pedijatar) lekari[i];
					najveciProsek = prosekGodinaPacijenta(lekari[i]);
				}
			}
		}
		return pediijatar;
	}
	
	// u ovom grmu lezi zec za onaj konstruktor
	private double prosekGodinaPacijenta(Lekar lekar) {
		int brojac = 0;
		double godine = 0;
		for(int i = 0; i < lekar.getStvarniBroj(); i++) {
			if(lekar != null && lekar.getPacijenti()[i] != null) {
				godine += lekar.getPacijenti()[i].getBrojGodina();
				brojac++;
			} else {
				System.out.println(lekar.getPacijenti()[i]);
			}
		}
		return godine/brojac;
	}
	
	public String vratiDrugog() {
		return lekari[2].getIme();
	}
}

