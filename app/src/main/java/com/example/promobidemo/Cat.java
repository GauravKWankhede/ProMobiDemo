package com.example.promobidemo;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;


//This is the model class for room db
@Entity
public class Cat  {

    @PrimaryKey (autoGenerate = true)
    private int identity;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="temperament")
    private String temperament;

    @ColumnInfo(name="origin")
    private String origin;

    @ColumnInfo(name="description")
    private String description;

    @ColumnInfo(name="life_span")
    private String life_span;

    @ColumnInfo(name="alt_names")
    private String alt_names;

    @ColumnInfo(name="adaptability")
    private int adaptability;

    @ColumnInfo(name="affection_level")
    private int affection_level;

    @ColumnInfo(name="child_friendly")
    private int child_friendly;

    @ColumnInfo(name="dog_friendly")
    private int dog_friendly;

    @ColumnInfo(name="energy_level")
    private int energy_level;

    @ColumnInfo(name="grooming")
    private int grooming;

    @ColumnInfo(name="health_issues")
    private int health_issues;

    @ColumnInfo(name="intelligence")
    private int intelligence;

    @ColumnInfo(name="shredding_level")
    private int shedding_level;

    @ColumnInfo(name="social_needs")
    private int social_needs;

    @ColumnInfo(name="stranger_friendly")
    private int stranger_friendly;

    @ColumnInfo(name="vocalization")
    private int vocalisation;

    @ColumnInfo(name="experimental")
    private int experimental;

    @ColumnInfo(name="wikipedia_url")
    private String wikipedia_url;

    @Embedded
    private Image image;


    public Cat(){}

    public Cat(@NonNull String name, String temperament, String origin, String country_codes, String country_code, String description, String life_span, String alt_names, int adaptability, int affection_level, int child_friendly, int dog_friendly, int energy_level, int grooming, int health_issues, int intelligence, int shedding_level, int social_needs, int stranger_friendly, int vocalisation, int experimental, String wikipedia_url, Image image) {
        this.name = name;
        this.temperament = temperament;
        this.origin = origin;
        this.description = description;
        this.life_span = life_span;
        this.alt_names = alt_names;
        this.adaptability = adaptability;
        this.affection_level = affection_level;
        this.child_friendly = child_friendly;
        this.dog_friendly = dog_friendly;
        this.energy_level = energy_level;
        this.grooming = grooming;
        this.health_issues = health_issues;
        this.intelligence = intelligence;
        this.shedding_level = shedding_level;
        this.social_needs = social_needs;
        this.stranger_friendly = stranger_friendly;
        this.vocalisation = vocalisation;
        this.experimental = experimental;
        this.wikipedia_url = wikipedia_url;
        this.image = image;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int id) {
        this.identity = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLife_span() {
        return life_span;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public int getAffection_level() {
        return affection_level;
    }

    public void setAffection_level(int affection_level) {
        this.affection_level = affection_level;
    }

    public int getChild_friendly() {
        return child_friendly;
    }

    public void setChild_friendly(int child_friendly) {
        this.child_friendly = child_friendly;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public int getEnergy_level() {
        return energy_level;
    }

    public void setEnergy_level(int energy_level) {
        this.energy_level = energy_level;
    }

    public int getGrooming() {
        return grooming;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public int getHealth_issues() {
        return health_issues;
    }

    public void setHealth_issues(int health_issues) {
        this.health_issues = health_issues;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getShedding_level() {
        return shedding_level;
    }

    public void setShedding_level(int shedding_level) {
        this.shedding_level = shedding_level;
    }

    public int getSocial_needs() {
        return social_needs;
    }

    public void setSocial_needs(int social_needs) {
        this.social_needs = social_needs;
    }

    public int getStranger_friendly() {
        return stranger_friendly;
    }

    public void setStranger_friendly(int stranger_friendly) {
        this.stranger_friendly = stranger_friendly;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public void setVocalisation(int vocalisation) {
        this.vocalisation = vocalisation;
    }

    public int getExperimental() {
        return experimental;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }




}
