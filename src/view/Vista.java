package view;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import entities.*;

public class Vista implements IVista
{
	String percorso;
	
	public Vista(String percorso)
	{
		this.percorso = percorso;
	}
	
	public String contenutoFile(String file)
	{
		String ris = "";
		try
		{
			Scanner dati = new Scanner(new File(percorso+"\\"+file));
			while(dati.hasNextLine())
				ris+=dati.nextLine();			
			dati.close();
		}
		catch(Exception e)
		{
			ris = "File "+(percorso+"/"+file)+"non trovato";
		}
		return ris;
	}

	@Override
	public String scheda(Persona p) 
	{
		String ris = contenutoFile("persona.html");		
		ris = ris.replace("[nome]", p.nome);
		ris = ris.replace("[cognome]", p.cogn);
		ris = ris.replace("[avatar]", p.avatar);
		return ris;
	}

	@Override
	public String scheda(List<Persona> p) 
	{
		String ris = "";
		for(Persona pers: p)
			ris+=scheda(pers) + "\n";
		return ris;
	}	
}
