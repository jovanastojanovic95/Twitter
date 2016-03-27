package menjacnica;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import menjacnica.interfejs.MenjacnicaInterfejs;

public class Menjacnica implements MenjacnicaInterfejs {
	
	LinkedList<Valuta> valuta=new LinkedList<Valuta>();

	@Override
	public void dodavanjeKursa(GregorianCalendar datum, String naziv, String skraceniNaziv, double prodajniKurs,
			double kupovniKurs, double srednjiKurs) {
		
		Valuta v=new Valuta();
		
		v.setDatum(datum);
		v.setNaziv(naziv);
		v.setSkraceniNaziv(skraceniNaziv);
		v.setProdajniKurs(prodajniKurs);
		v.setKupovniKurs(kupovniKurs);
		v.setSrednjiKurs(srednjiKurs);
		
		valuta.add(v);
		

	}

	@Override
	public void brisanjeKursa(GregorianCalendar datum, String naziv, String skraceniNaziv) {
		
		Valuta v=new Valuta();
		v.setDatum(datum);
		v.setNaziv(skraceniNaziv);
		v.setSkraceniNaziv(skraceniNaziv);
		
		for(int i=0;i<valuta.size();i++){
			
			if(valuta.get(i).equals(v)){
				valuta.get(i).setProdajniKurs(0);
				valuta.get(i).setKupovniKurs(0);
				valuta.get(i).setSrednjiKurs(0);
				
				break;
			}
		}

	}

	@Override
	public double[] pronadjiIVratiKurs(GregorianCalendar datum, String naziv, String skraceniNaziv) {
		
		Valuta v=new Valuta();
		double [] kursevi=new double[3];
		
		
		v.setDatum(datum);
		v.setNaziv(skraceniNaziv);
		v.setSkraceniNaziv(skraceniNaziv);
		
		for(int i=0;i<valuta.size();i++){
			
			if(valuta.get(i).equals(v)){
			kursevi[0]=valuta.get(i).getProdajniKurs();
			kursevi[1]=valuta.get(i).getSrednjiKurs();
			kursevi[2]=valuta.get(i).getKupovniKurs();
			
			
			}
		}
		
		
		return kursevi;
	}

}
