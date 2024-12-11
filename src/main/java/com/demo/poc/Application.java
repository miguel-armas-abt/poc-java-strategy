package com.demo.poc;

import com.demo.poc.dto.PokemonDTO;
import com.demo.poc.repository.PokemonRepository;

public class Application {

    public static void main(String[] args) {
        PokemonRepository repository = new PokemonRepository();

        for (PokemonDTO pokemon: repository.findAll()) {
            System.out.println(pokemon);
        }
    }
}
