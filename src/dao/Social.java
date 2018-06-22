package dao;

import java.util.ArrayList;
import java.util.List;
import entities.*;

public class Social {
	
	String percorso;
	public List<Persona> persone = null;
	public Social(String percorso) {
		this.percorso = percorso;
	}

	public Persona persona(int id) 
	{
		JsonConverter jConv = new JsonConverter(this.percorso);
		persone = jConv.parseFile();
		Persona ris = null;
		for(Persona p:persone) {
			if(id == p.id)
				ris = p;
		}
		return ris;
	}

	public List<Persona> amiciPersona(int id) 
	{
		JsonConverter jConv = new JsonConverter(this.percorso);
		persone = jConv.parseFile();
		List<Persona> ris = new ArrayList<Persona>();
		for(Persona p:persone)
			if(id != p.id)
				ris.add(p);
		return ris;
	}
}
