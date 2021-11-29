package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import model.Konto;



public class TestKonto {

	@Test
	public void testKonstruktor() {
		//fail("Not yet implemented");
		Konto k = new Konto("alf");
		
		//Prüfen ob IBAN korrekt übernommen wurde
		assertEquals("Korrekte Übernahme IBAN","alf", k.getIban());
		
		//Prüfe, ob Kontostand nach dem Erstellen 0 ist
		assertEquals("Kontostand am Anfang 0",0, k.getKontostand(),0);
	}
	
	@Test
	public void testEinzahlen() {
		Konto k = new Konto("CH4000q245jfglskjdg");
		
		k.einzahlen(200);
		
		assertEquals("Kontostand nach erster einzahlung 200",
				200, k.getKontostand(),0);
		
		
		k.einzahlen(200);
		assertEquals("Sollte nach zweiter einzahlung 400 sein",
				400, k.getKontostand(),0);
		
		k.einzahlen(-100);
		assertEquals("Prüft ob der Kontostand bei negativer Einzahlung gleich bleibt",400, k.getKontostand(),0);
		
	}
	
	@Test
	public void testAbheben() {
		Konto k = new Konto("ailkjflkasjf");
		
		k.einzahlen(200);
		
		
		assertEquals("Prüft ob das Geld ausgegeben wird",100, k.abheben(100),0);
		assertEquals("Sollte nach erster Abhebung 100 sein",100, k.getKontostand(), 0);
		
		assertEquals("Prüft ob wirklich kein Geld zurück gegeben wurde",0, k.abheben(200),0);
		
		assertEquals("Abhebung zu gross Kontostand bleibt 100",100, k.getKontostand(),0);
		
		assertEquals("Prüft ob abzuhebender Wert positiv ist",0, k.abheben(-100),0);
		assertEquals("Prüft ob der Kontostand gleichgeblieben ist",100, k.getKontostand(),0);
	}
}
