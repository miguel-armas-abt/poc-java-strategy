package com.demo.poc.commons;

import com.demo.poc.dao.PokemonCsvDAOImpl;
import com.demo.poc.dao.PokemonDAO;
import com.demo.poc.dao.PokemonMemoryDAOImpl;
import com.demo.poc.repository.PokemonRepository;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ComponentInjectorConfig extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<PokemonDAO> binderSet = Multibinder.newSetBinder(binder(), PokemonDAO.class);
        binderSet.addBinding().to(PokemonCsvDAOImpl.class);
        binderSet.addBinding().to(PokemonMemoryDAOImpl.class);

        bind(PokemonRepository.class);
    }
}
