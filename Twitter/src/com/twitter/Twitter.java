package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * 
 * Ovo je klasa koja sadrzi listu TwitterPoruka i metode za vracanje i unos istih.
 * @author Jovana Stojanovic
 *
 */


public class Twitter {


	/**
	 * Ovaj atribut predstavlja listu TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
	
     /**
      * Ova metoda vraca listu poruka.
      * @return lista TwitterPoruka
      */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}
/**
 * Ova metoda pravi novi objekat TwitterPoruka, postavlja vrednosti njegovih atrubuta i unosi ga u listu.
 * @param korisnik ime korisnika
 * @param poruka odgovarajuca poruka
 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
/**
 * Ova metoda vraca niz poruka koje sadrze odgvarajuci tag.
 * @param maxBroj predstavlja maksimalni broj elemenata u novom nizu.
 * @param tag trazeni tag u poruci.
 * @return niz poruka koje sadrze zeljeni tag.
 * @throws java.lang.RuntimeException kada je tag null ili prazan string.
 */

	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0; // Pomocni niz koja predstavlja rezultat pretrage tj.
						// sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}