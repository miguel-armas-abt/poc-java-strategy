package com.demo.poc;

import com.demo.poc.commons.ComponentInjectorConfig;
import com.demo.poc.dto.PokemonDTO;
import com.demo.poc.repository.PokemonRepository;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ComponentInjectorConfig());
        PokemonRepository repository = injector.getInstance(PokemonRepository.class);

        for (PokemonDTO pokemon: repository.findAll()) {
            System.out.println(pokemon);
        }
    }
}
