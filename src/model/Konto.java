package model;
/**
 * speichert wichtigste Informationen zu einem Konto 
 * @author sven
 *
 */
public class Konto {
	
	private String iban;
	private double kontostand;
	public int abheben;
	public int einzahlen;

	/**
	 * Konstruktor f�r Konto-Objekte
	 * @param iban
	 * @param kontostand
	 */
	public Konto(String iban) {
		super();
		this.iban = iban;
		this.kontostand = 0;
	}
	
	/**
	 * gibt aktuellen Kontostand zur�ck
	 * @return
	 */
	public double getKontostand() {
		return kontostand;
	}
	
	public String getIban(){
		return iban;
	}
	
	/**
	 * erh�ht den kontostand und betrag
	 * @param betrag
	 */
	public void einzahlen(double betrag) {
		kontostand += betrag;
	}
	
	/**
	 * verringert Kontostand und gew�nschten Betrag und zahlt diesen aus, 
	 * wenn Konto ausreichend gedeckt ist
	 * 
	 * @param betrag gew�nschter betrag
	 * @return gew�nschte betrag
	 */
	public double abheben(double betrag) {
		if (betrag <= this.kontostand && betrag > 0) {
			this.kontostand -=betrag;
			return betrag;
		}else {
			System.out.print("der Abgehobene Betrag ist zu hoch");
			return 0;
		}
		
		
		

	}
	
	

}