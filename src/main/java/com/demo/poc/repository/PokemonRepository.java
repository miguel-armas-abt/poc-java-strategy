package com.demo.poc.repository;

import com.demo.poc.commons.PropertiesReader;
import com.demo.poc.dao.PokemonDAO;
import com.demo.poc.dto.PokemonDTO;
import com.google.inject.Inject;
import java.util.List;
import java.util.Set;

public class PokemonRepository {

    private final Set<PokemonDAO> pokemonDAOSet;

    @Inject
    public PokemonRepository(Set<PokemonDAO> pokemonDAOSet) {
        this.pokemonDAOSet = pokemonDAOSet;
    }

    public List<PokemonDTO> findAll() {
        return selectDAO().findAll();
    }

    public PokemonDTO findByCode(int code) {
        return selectDAO().findByCode(code);
    }

    private PokemonDAO selectDAO() {
        Class<?> selectedClass = PropertiesReader.getPropertyClass("pokemones.dao.selector-class");
        for(PokemonDAO dao: this.pokemonDAOSet) {
            if(dao.supports(selectedClass))
                return dao;
        }
        throw new IllegalArgumentException("No such DAO");
    }
}
