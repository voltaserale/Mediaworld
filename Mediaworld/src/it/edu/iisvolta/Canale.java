package it.edu.iisvolta;

public class Canale {
	private int numero;
	private int frequenza;
	private String nome;
	
	public Canale(int numero, int frequenza, String nome) {
		super();
		this.numero = numero;
		this.frequenza = frequenza;
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public int getFrequenza() {
		return frequenza;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
