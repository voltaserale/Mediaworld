package it.edu.iisvolta;

public class Dispositivo {
	protected boolean stato;
	protected String marca;
	protected String modello;
	
	public Dispositivo(String marca, String modello) {
		super();
		this.marca = marca;
		this.modello = modello;
		this.stato=false;
	}
	
	public void accendi() {
		if (stato)
			System.out.println("Disposivo già acceso");
		else
			stato=true;
	}
	
	public void spegni() {
		if (!stato)
			System.out.println("Disposivo già spento");
		else
			stato=false;
	}

	public boolean getStato() {
		return stato;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}
	

}
