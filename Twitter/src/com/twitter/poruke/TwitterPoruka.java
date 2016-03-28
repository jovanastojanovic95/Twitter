package com.twitter.poruke;

/**
  *Ovo je klasa koja sadrzi dva atributa i predstavlja poruku na Twitteru.
 * @author Jovana Stojanovic
 */
public class TwitterPoruka {
	/**
	 * Ovaj atribut predstavlja ime korisnika.
	 */
	private String korisnik;
	/**
	 * Ovaj atribut predstavlja zeljenu poruku.
	 */
	private String poruka;
/**
 * Ova metoda vraca ime korisnika
 * @return ime korisnika
 */
	public String getKorisnik() {
		return korisnik;
	}
/**
 * Ova metoda postavlja odgovarajuce ime korisnika
 * @param korisnik ime korisnika
 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
/**
 * Ova metoda vraca odgovarajucu poruku.
 * @return odgovarajuca poruka
 */
	public String getPoruka() {
		return poruka;
	}
/**
 * Ova metoda postavlja vrednost atributa poruka na unetu poruku.
 * @param poruka odgovarajuca poruka
 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
/**
 * Ova metoda vraca vrednosti oba atributa.
 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
