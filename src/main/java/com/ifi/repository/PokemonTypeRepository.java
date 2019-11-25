package com.ifi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.bo.PokemonType;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepository() {
        try {
            var pokemonsStream = this.getClass().getResourceAsStream("/pokemons.json");

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PokemonType findPokemonById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        for (PokemonType p : pokemons){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public PokemonType findPokemonByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        for (PokemonType p : pokemons){
            if (p.getName().equals(name)){
                return p;
            }
        }
        return null;
    }

    public List<PokemonType> findAllPokemon() {
        return pokemons;
    }
}
