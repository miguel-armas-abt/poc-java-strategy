package com.demo.poc.dao;

import com.demo.poc.dto.PokemonDTO;
import java.util.List;

public interface PokemonDAO {

    List<PokemonDTO> findAll();

    PokemonDTO findByCode(int code);

    boolean supports(Class<?> selectedCass);
}
