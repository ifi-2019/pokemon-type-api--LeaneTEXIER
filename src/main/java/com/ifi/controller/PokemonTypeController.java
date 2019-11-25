package com.ifi.controller;

import com.ifi.bo.PokemonType;
import com.ifi.repository.PokemonTypeRepository;
import com.ifi.servlet.Controller;
import com.ifi.servlet.RequestMapping;

import java.util.Map;

@Controller
public class PokemonTypeController {
    private PokemonTypeRepository repository = new PokemonTypeRepository();

    @RequestMapping(uri="/pokemons")
    public PokemonType getPokemon(Map<String,String[]> parameters){
        // Check there is a parameter
        if(parameters == null){
            throw new IllegalArgumentException("parameters should not be empty");
        }
        if (parameters.containsKey("name")) {
            return repository.findPokemonByName(parameters.get("name")[0]);
        }
        else if (parameters.containsKey("id")) {
            return repository.findPokemonById(Integer.parseInt(parameters.get("id")[0]));
        }
        // Parameter unknown
        else {
            throw new IllegalArgumentException("unknown parameter");
        }
    }
}