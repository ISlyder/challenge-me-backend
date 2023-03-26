package com.duviv.challenge.country.model;

import lombok.*;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "name")
@Builder
public class Country implements Comparable<Country> {
    private String name;
    private String capital;
    private String flag;
    private Continent continent;

    @Override
    public int compareTo(Country o) {
        return this.getName().compareTo(o.getName());
    }
}
