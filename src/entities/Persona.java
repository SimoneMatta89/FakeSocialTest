package entities;

import java.util.ArrayList;
import java.util.List;

public class Persona
{
	public int id;
	public String nome;
	public String cogn;
	public String avatar;
	public List<Persona> friends = new ArrayList<Persona>();
	public Persona
	(
		int id, 
		String nome, 
		String cogn,
		String avatar
	) 
	{
		this.id = id;
		this.nome = nome;
		this.cogn = cogn;
		this.avatar = avatar;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cogn=" + cogn + ", avatar=" + avatar + ", friends=" + friends
				+ "]";
	}
	
	
}
