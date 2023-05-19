package it.edu.iisvolta;

import java.time.LocalDate;

public class Smartphone extends Dispositivo {	
	private int pollici;
	private int megaPixel;
	private String presa;
	private SIM scheda;
	
	
	public Smartphone(String marca, String modello, int pollici, 
			int megaPixel, String presa) {
		super(marca, modello);
		this.pollici = pollici;
		this.megaPixel = megaPixel;
		this.presa = presa;
		this.scheda = null;
	}
	
	public void inserisciSIM(SIM scheda) {
		if (this.scheda!=null)
			System.out.println("Scheda già presente");
		else 
		{
			this.scheda=scheda;
			System.out.println("Scheda inserita");
		}
	}
	
	public void rimuoviSIM() {
		if (this.scheda==null)
			System.out.println("Nessuna scheda presente");
		else
		{
			this.scheda=null;
			System.out.println("Scheda rimossa");
		}
	}
	
	public void telefona(int durata) {		//durata in minuti
		if (durata<0) 
			System.out.println("Durata non valida");
		else if (!stato) 
			System.out.println("Telefono spento");
		else if (scheda.getScadenza().isBefore(LocalDate.now()))
			System.out.println("Scheda scaduta");			
		else if (durata*0.1f>scheda.getCredito())
			System.out.println("Credito insufficiente");
		else  //posso telefonare
		{
			scheda.setCredito(scheda.getCredito()-durata*0.1f);
			System.out.println("Chiamata effettuata");
		}
	}

	public int getPollici() {
		return pollici;
	}

	public int getMegaPixel() {
		return megaPixel;
	}

	public String getPresa() {
		return presa;
	}

	public SIM getScheda() {
		return scheda;
	}
	
	
	
	

}
