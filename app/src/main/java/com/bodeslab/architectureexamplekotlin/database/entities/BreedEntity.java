package com.bodeslab.architectureexamplekotlin.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.bodeslab.architectureexamplekotlin.database.converters.DateConverter;
import com.bodeslab.architectureexamplekotlin.network.api.breed.Breeds;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {Created by Jonatas Caram on 15/05/2018}.
 */
@Entity
public class BreedEntity {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String breed;
    private String country;
    private String origin;
    private String coat;
    private String pattern;

    @TypeConverters({DateConverter.class})
    private Date insertDate;


    public BreedEntity() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getCoat() {
        return coat;
    }

    public void setCoat(String coat) {
        this.coat = coat;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public static BreedEntity fromModelToEntity(Breeds breedsResponse) {
        BreedEntity entity = new BreedEntity();
        entity.setBreed(breedsResponse.getBreed());
        entity.setCoat(breedsResponse.getCoat());
        entity.setCountry(breedsResponse.getCountry());
        entity.setPattern(breedsResponse.getPattern());
        entity.setOrigin(breedsResponse.getOrigin());
        entity.setInsertDate(new Date());
        return entity;
    }

    public static List<BreedEntity> fromModelsToEntities(List<Breeds> breeds) {
        List<BreedEntity> entities = new ArrayList<>();
        for (int i = 0; i < breeds.size(); i++) {
            entities.add(fromModelToEntity(breeds.get(i)));
        }
        return entities;
    }
}
