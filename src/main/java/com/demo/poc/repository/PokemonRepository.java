package com.demo.poc.repository;

import com.demo.poc.commons.PropertiesReader;
import com.demo.poc.dao.PokemonCsvDAOImpl;
import com.demo.poc.dao.PokemonDAO;
import com.demo.poc.dao.PokemonMemoryDAOImpl;
import com.demo.poc.dto.PokemonDTO;
import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {

    private final List<PokemonDAO> pokemonDAOList;

    public PokemonRepository() {
        this.pokemonDAOList = new ArrayList<>();
        PokemonCsvDAOImpl csvDAO = new PokemonCsvDAOImpl();
        PokemonMemoryDAOImpl memoryDAO = new PokemonMemoryDAOImpl();
        pokemonDAOList.add(csvDAO);
        pokemonDAOList.add(memoryDAO);
    }

    public List<PokemonDTO> findAll() {
        return selectDAO().findAll();
    }

    public PokemonDTO findByCode(int code) {
        return selectDAO().findByCode(code);
    }

    private PokemonDAO selectDAO() {
        Class<?> selectedClass = PropertiesReader.getPropertyClass("pokemones.dao.selector-class");
        for(PokemonDAO dao: this.pokemonDAOList) {
            if(dao.supports(selectedClass))
                return dao;
        }
        throw new IllegalArgumentException("No such DAO");
    }
}
