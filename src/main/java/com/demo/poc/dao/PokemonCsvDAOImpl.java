package com.demo.poc.dao;

import com.demo.poc.commons.CsvReader;
import com.demo.poc.dto.PokemonDTO;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PokemonCsvDAOImpl implements PokemonDAO {

    private static final String FILE = "/pokemones/pokemons.csv";
    private static final char SEPARATOR = ',';

    @Override
    public List<PokemonDTO> findAll() {
        List<PokemonDTO> pokemonList = new ArrayList<>();
        try {
            CsvReader.getRecords(FILE, SEPARATOR)
                    .forEach(csvRecord -> {

                        PokemonDTO pokemon = PokemonDTO.builder()
                                .name(csvRecord.get("NAME"))
                                .type(csvRecord.get("TYPE"))
                                .code(Integer.parseInt(csvRecord.get("CODE")))
                                .build();

                        pokemonList.add(pokemon);
                    });
        } catch (Exception exception) {
            throw new IllegalArgumentException("Error reading CSV", exception);
        }
        return pokemonList;
    }

    @Override
    public PokemonDTO findByCode(int code) {
        List<PokemonDTO> allPokemon = this.findAll();
        for (PokemonDTO pokemon: allPokemon) {
            if (pokemon.getCode() == code) {
                return pokemon;
            }
        }
        throw new IllegalArgumentException("No such pokemon");
    }

    @Override
    public boolean supports(Class<?> selectedCass) {
        return PokemonCsvDAOImpl.class.isAssignableFrom(selectedCass);
    }
}
