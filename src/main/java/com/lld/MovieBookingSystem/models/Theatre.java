package com.lld.MovieBookingSystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{
    private String theatreName;
    private String theatreAddress;
    @ManyToOne
    private Region region;

}
