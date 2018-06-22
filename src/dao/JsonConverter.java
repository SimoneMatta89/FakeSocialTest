package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import entities.*;


public class JsonConverter {
	
		String percorso;
		public JsonConverter(String p) {
			this.percorso = p;
		}
		
		public List<Persona> parseFile()
		{
			Object[] v1;
			List<Persona> persone= new ArrayList<Persona>();
			Persona a = null;
			int id;
			String nome;
			String cognome;
			String avatar;
			File jsonInputFile = new File(this.percorso+"\\"+"users.txt");
			InputStream is = null;
		    try
		    {
		        is = new FileInputStream(jsonInputFile);
		        JsonReader reader = Json.createReader(is);
		        JsonObject json = reader.readObject();
		        v1 = new Object[json.getJsonArray("data").size()];
		
		        for(int i = 0;i<v1.length;i++)
		        {
		        	v1[i] = json.getJsonArray("data").get(i);
		        	
		        }
		        for(int i = 0;i<v1.length;i++)
		        {
		        	JsonObject json1 = (JsonObject) v1[i];
		        	id = json1.getInt("id");
		        	nome = json1.getString("first_name");
		        	cognome = json1.getString("last_name");
		        	avatar = json1.getString("avatar");
		        	a = new Persona(id,nome,cognome,avatar);
		        	persone.add(a);
		        }
		        reader.close();
		    } 
		    catch (Exception e) 
		    {
		        e.printStackTrace();
		    }
			return persone;
		}
}
