package com.lld.MovieBookingSystem.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String title;
    @ElementCollection
    private List<String> actors;
    private int releaseYear;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Language> languages;
    @ElementCollection
    private List<String> genres;
    private int duration;
    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

}


// @ElementCollection since I donot want to put list of actors in a single cell.
// With @ElementCollection annotation, it wil create a separate table
