package it.edu.iisvolta;

import java.util.ArrayList;

public class TV extends Dispositivo {
	private int pollici;
	private boolean smart;
	private String sistemaOperativo;
	private ArrayList<Canale> canali=new ArrayList<>();
	
	public TV(String marca, String modello, int pollici, boolean smart, String sistemaOperativo) {
		super(marca, modello);
		this.pollici = pollici;
		this.smart = smart;
		this.sistemaOperativo = sistemaOperativo;
	}

	public int getPollici() {
		return pollici;
	}

	public boolean isSmart() {
		return smart;
	}

	public String getSistemaOperativo() {
		return sistemaOperativo;
	}

	public ArrayList<Canale> getCanali() {
		return canali;
	}
	
	public void sintonizza() {
		canali.add(new Canale(1,430,"Rai 1"));
		canali.add(new Canale(2,654,"Rai 2"));
		canali.add(new Canale(3,763,"Rai 3"));
		canali.add(new Canale(4,993,"Italia 1"));
		canali.add(new Canale(5,999,"Canale 5"));
		
		System.out.println("Sintonizzazione effettuata");
		
	}
	
	public void guardaCanale(int nrCanale) {
		boolean trovato=false;
		for(Canale c:canali) {
			if (c.getNumero()==nrCanale)
			{
				trovato=true;
				System.out.println(
					"Stai guardando il canale "+c.getNome()+
					" frequenza "+c.getFrequenza()+" Mhz");
			}
		}
		if (!trovato)
			System.out.println("Canale non trovato");
	}
	
	
}
