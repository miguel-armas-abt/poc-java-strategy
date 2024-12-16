package com.demo.poc.dao;

import com.demo.poc.dto.PokemonDTO;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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
        throw new IllegalArgumentException("No such element with code " + code);
    }

    @Override
    public boolean supports(Class<?> selectedCass) {
        return PokemonMemoryDAOImpl.class.isAssignableFrom(selectedCass);
    }
}
