package it.edu.iisvolta;

import java.time.LocalDate;

public class SIM {
	private float credito;
	private String gestore;
	private LocalDate scadenza;
	
	public SIM(String gestore, LocalDate scadenza) {
		super();
		this.credito = 0;
		this.gestore = gestore;
		this.scadenza = scadenza;
	}
	
	public void ricarica(float importo) {
		if (importo>0) {
			credito+=importo;
			scadenza=scadenza.plusYears(1);		
			}
		else
			System.out.println("Importo non valido!");
	}

	public void setCredito(float credito) {
		this.credito = credito;
	}

	public float getCredito() {
		return credito;
	}

	public String getGestore() {
		return gestore;
	}

	public LocalDate getScadenza() {
		return scadenza;
	}
	
	
}
