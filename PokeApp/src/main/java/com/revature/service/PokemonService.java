package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.db.FakeDB;
import com.revature.model.Pokemon;

public class PokemonService {
	
	public static Pokemon getPokemon(int id) {
		
		return FakeDB.team.get(id);
		
	}
	
	public static Pokemon addPokemon(Pokemon p) {
		
		return FakeDB.team.put(p.getId(), p);
		
	}

	public static ArrayList<Pokemon> getAllPokemon() {
		
		return new ArrayList<Pokemon>(FakeDB.team.values());
		
	}

}
