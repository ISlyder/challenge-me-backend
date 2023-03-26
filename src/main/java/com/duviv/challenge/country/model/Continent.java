package com.duviv.challenge.country.model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public enum Continent {
    AFRIQUE("afrique"),
    ASIE("asie"),
    EUROPE("europe"),
    AMERIQUE("amerique"),
    OCEANIE("oceanie");

    private final String name;

    Continent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonCreator
    public static Continent decode(final String name) {
        return Stream.of(Continent.values())
                .filter(targetEnum -> targetEnum.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No continent with name " + name));
    }
}
