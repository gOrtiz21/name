package com.revature.webservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

public class PokemonWebService {
	
	public static void getPokemon(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
//		System.out.println(id);
		Pokemon p = PokemonService.getPokemon(id);
		
		//Some logic/code;
		
		ObjectMapper om = new ObjectMapper();
		
		try {
			
			String pokemonJSON = om.writeValueAsString(p);
			response.getWriter().append(pokemonJSON).close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	public static void addPokemon(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		System.out.println(id+ " " + name + " " + type);
		
		Pokemon p = new Pokemon(id, name, type);
		PokemonService.addPokemon(p);
		
		try {
			
			response.getWriter().append("Pokemon added to the database.").close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	public static void getAllPokemon(HttpServletRequest request, HttpServletResponse response) {

		ObjectMapper om = new ObjectMapper();
		ArrayList<Pokemon> pokemans = PokemonService.getAllPokemon();
		
		try {
			response.getWriter().append(om.writeValueAsString(pokemans));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
