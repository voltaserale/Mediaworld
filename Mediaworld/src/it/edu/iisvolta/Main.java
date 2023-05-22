package it.edu.iisvolta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String scelta;
		String marca, modello;
		int pollici;
		
		SIM scheda=null;
		Smartphone telefono=null;
		TV televisore=null;
		DateTimeFormatter formatter = 
			DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		do {
            Console.clear();
            System.out.println("MEDIAWORLD\n");
            System.out.println("1 - crea scheda SIM");
            System.out.println("2 - visualizza scheda SIM");            
            System.out.println("3 - ricarica scheda SIM");
            System.out.println("4 - crea smartphone");                    
            System.out.println("5 - visualizza smartphone");
            System.out.println("6 - inserisci/rimuovi SIM");
            System.out.println("7 - accendi/spegni smartphone");
            System.out.println("8 - telefona");
            System.out.println("9 - crea TV");
            System.out.println("10 - visualizza TV");
            System.out.println("11 - accendi/spegni TV");
            System.out.println("12 - sintonizza TV");
            System.out.println("13 - guarda canale");
            System.out.println("99 - esci\n");
            System.out.print("Inserisci la tua scelta: ");
            scelta=s.nextLine();
            
            switch(scelta) {
            case "1":
            	System.out.print("Inserisci il nome del gestore: ");
            	String gestore=s.nextLine();
            	System.out.print("Inserisci la data di scadenza: ");            	
            	String dataScad=s.nextLine();
            	try {
            		LocalDate dataScadenza=LocalDate.parse(dataScad, formatter);
                	scheda=new SIM(gestore, dataScadenza);  
            	} catch(DateTimeParseException ex) {
            		System.out.println("Formato della data non valido: "+ex.getMessage());
            	}
            	
            	break;
            case "2":
            	if(scheda==null)
            		System.out.println("Scheda non creata");
            	else
            	{
            		System.out.println("Gestore: "+scheda.getGestore());
            		System.out.println("Credito: "+scheda.getCredito());
            		System.out.println("Scadenza: "+
            				formatter.format(scheda.getScadenza()));           		
            	}
            	break;
            case "3":
            	if(scheda==null)
            		System.out.println("Scheda non creata");
            	else
            	{
            		float importo;
            		System.out.print("Quanto vuoi ricaricare? ");
            		
            		try {
            			importo=Float.parseFloat(s.nextLine());
            			scheda.ricarica(importo);
                	} catch(NumberFormatException ex) {
                		System.out.println("Importo non valido: "+ex.getMessage());
                	}   
            	}
            	break;
            case "4":
            	System.out.print("Inserisci la marca: ");
            	marca=s.nextLine();
            	System.out.print("Inserisci il modello: ");            	
            	modello=s.nextLine();
            	
            	pollici=0;
            	do {
            		System.out.print("Inserisci i pollici: ");  
            		try {
                		pollici=Integer.parseInt(s.nextLine());    
                		if (pollici<0)		//numero intero negativo (non va in catch)
                			System.out.println("Numero di pollici non valido");
                	} catch(NumberFormatException ex) {
                		System.out.println("Numero di pollici non valido: "+ex.getMessage());
                	}
            	} while (pollici<=0);
            	
            	int megaPixel=0;
            	do {
            		System.out.print("Inserisci i MegaPixel: ");  
            		try {
            			megaPixel=Integer.parseInt(s.nextLine());    
                		if (megaPixel<0)		//numero intero negativo (non va in catch)
                			System.out.println("Numero di Mega Pixel non valido");
                	} catch(NumberFormatException ex) {
                		System.out.println("Numero di MegaPixel non valido: "+ex.getMessage());
                	}
            	} while (megaPixel<=0);
            	
            	System.out.print("Inserisci il tipo di presa: ");            	
            	String presa=s.nextLine();
            	
            	telefono=new Smartphone(marca, modello, pollici, megaPixel, presa);
            	
            	break;
            case "5":
            	if(telefono==null)
            		System.out.println("Telefono non creato");
            	else
            	{
            		System.out.println("Marca: "+telefono.getMarca());
            		System.out.println("Modello: "+telefono.getModello());
            		System.out.println("Pollici: "+telefono.getPollici());  
            		System.out.println("MegaPixel: "+telefono.getMegaPixel());   
            		System.out.println("Presa: "+telefono.getPresa());
            		System.out.print("Scheda: ");
            		if (telefono.getScheda()==null)
            			System.out.println("non inserita");
            		else
            			System.out.println("presente. Credito: "+telefono.getScheda().getCredito());
            		if (telefono.getStato())
            			System.out.println("Stato: acceso");
            		else
            			System.out.println("Stato: spento");
            	}
            	break;
            case "6":
            	if(telefono==null)
            		System.out.println("Telefono non creato");
            	else
            	{
	            	if (telefono.getScheda()==null)
	            		telefono.inserisciSIM(scheda);
	            	else
	            		telefono.rimuoviSIM();
	            	break;
            	}
            case "7":
            	if(telefono==null)
            		System.out.println("Telefono non creato");
            	else
            	{
	            	if (telefono.getStato()==false)
	            		telefono.accendi();
	            	else
	            		telefono.spegni();
	            	break;
            	}
            case "8":
            	if(telefono==null)
            		System.out.println("Telefono non creato");
            	else
            	{
	            	if(telefono.getStato()) 
	            	{
		            	int durata;            	
		            	System.out.println("Inserisci la durata: ");
		            	try {
		            		durata=Integer.parseInt(s.nextLine());   
		            		telefono.telefona(durata);
		            	} catch(NumberFormatException ex) {
		            		System.out.println("Durata non valida: "+ex.getMessage());
		            	}
	            	} else
	            		System.out.println("Telefono spento");
	            	}
            	break;
            case "9":
            	System.out.print("Inserisci la marca: ");
            	marca=s.nextLine();
            	System.out.print("Inserisci il modello: ");            	
            	modello=s.nextLine();
            	
            	pollici=0;
            	do {
            		System.out.print("Inserisci i pollici: ");  
            		try {
                		pollici=Integer.parseInt(s.nextLine());    
                		if (pollici<0)		//numero intero negativo (non va in catch)
                			System.out.println("Numero di pollici non valido");
                	} catch(NumberFormatException ex) {
                		System.out.println("Numero di pollici non valido: "+ex.getMessage());
                	}
            	} while (pollici<=0);
            	
            	System.out.print("Inserisci il sistema operativo: ");
            	String sistOp=s.nextLine();
            	String smart;
            	do {
            		System.out.print("La TV è smart (sì/no): ");            	
                	smart=s.nextLine();
                	if (!smart.equals("sì") && !smart.equals("no"))
                		System.out.println("Risposta non valida!");
            	} while (!smart.equals("sì") && !smart.equals("no"));
            	
            	boolean isSmart=false;
            	if (smart.equals("sì"))
            		isSmart=true;            	
            	
            	televisore=new TV(marca, modello, pollici, isSmart, sistOp);
            	
            	break;
            case "10":
            	if(televisore==null)
            		System.out.println("TV non creata");
            	else
            	{
            		System.out.println("Marca: "+televisore.getMarca());
            		System.out.println("Modello: "+televisore.getModello());
            		System.out.println("Pollici: "+televisore.getPollici());  
            		System.out.println("Sistema operativo: "+televisore.getSistemaOperativo());   
            		System.out.print("Smart: ");
            		if (televisore.isSmart())
            			System.out.println("sì");
            		else
            			System.out.println("no");    
            		if (televisore.getStato())
            			System.out.println("Stato: acceso");
            		else
            			System.out.println("Stato: spento");
            	}
            	break;
            case "11":
            	if(televisore==null)
            		System.out.println("TV non creata");
            	else
            	{
	            	if (televisore.getStato()==false)
	            		televisore.accendi();
	            	else
	            		televisore.spegni();
	            	break;
            	}
            	break;
            case "12":
            	if(televisore==null)
            		System.out.println("TV non creata");
            	else
            	{
            		televisore.sintonizza();
            	}
            	break;
            case "13":
            	if(televisore==null)
            		System.out.println("TV non creata");
            	else
            	{
            		//inserisco il canale
            		int canale=0;
                	do {
                		System.out.print("Inserisci il canale da guardare: ");  
                		try {
                			canale=Integer.parseInt(s.nextLine());    
                    		if (canale<1 || canale>televisore.getCanali().size())		//numero intero negativo (non va in catch)
                    			System.out.println("Canale non valido");
                    	} catch(NumberFormatException ex) {
                    		System.out.println("Canale non valido: "+ex.getMessage());
                    	}
                	} while (canale<=0);
            		televisore.guardaCanale(canale);
            	}
            	break;
            
            }
            
            
            
            
            	
            System.out.println("Premi Enter per continuare...");
            s.nextLine();
		} while(!scelta.equals("99"));
		s.close();
	}

}
