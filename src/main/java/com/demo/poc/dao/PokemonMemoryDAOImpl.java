package com.demo.poc.dao;

import com.demo.poc.dto.PokemonDTO;
import java.util.Arrays;
import java.util.List;

public class PokemonMemoryDAOImpl implements PokemonDAO {

    private final List<PokemonDTO> pokemones = Arrays.asList(
        new PokemonDTO("Eléctrico", "Pikachu", 123),
        new PokemonDTO("Fuego", "Charmander", 321),
        new PokemonDTO("Agua", "Squirtle", 789)
    );

    @Override
    public List<PokemonDTO> findAll() {
        return this.pokemones;
    }

    @Override
    public PokemonDTO findByCode(int code) {
        for(PokemonDTO pokemon: this.pokemones) {
            if(pokemon.getCode() == code)
                return pokemon;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> selectedCass) {
        return selectedCass.isAssignableFrom(PokemonMemoryDAOImpl.class);
    }
}
