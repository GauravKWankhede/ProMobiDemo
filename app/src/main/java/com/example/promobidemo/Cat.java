package com.example.promobidemo;

import io.realm.RealmObject;

public class Cat extends RealmObject  {
    private String imperial;
    private String metric;
    private String id;
    private String name;
    private String cfa_url;
    private String vetstreet_url;
    private String vcahospitals_url;
    private String temperament;
    private String origin;
    private String country_codes;
    private String country_code;
    private String description;
    private String life_span;
    private int indoor;
    private int lap;
    private String alt_names;
    private int adaptability;
    private int affection_level;
    private int child_friendly;
    private int dog_friendly;
    private int energy_level;
    private int grooming;
    private int health_issues;
    private int intelligence;
    private int shedding_level;
    private int social_needs;
    private int stranger_friendly;
    private int vocalisation;
    private int experimental;
    private int hairless;
    private int natural;
    private int rare;
    private int rex;
    private int suppressed_tail;
    private int short_legs;
    private int hypoallergenic;
    private String wikipedia_url;
    private String reference_image_id;
    private Image image;


    public Cat(){}
    public Cat(String imperial, String metric, String id, String name, String cfa_url, String vetstreet_url, String vcahospitals_url, String temperament, String origin, String country_codes, String country_code, String description, String life_span, int indoor, int lap, String alt_names, int adaptability, int affection_level, int child_friendly, int dog_friendly, int energy_level, int grooming, int health_issues, int intelligence, int shedding_level, int social_needs, int stranger_friendly, int vocalisation, int experimental, int hairless, int natural, int rare, int rex, int suppressed_tail, int short_legs, int hypoallergenic, String wikipedia_url, String reference_image_id, Image image) {
        this.imperial = imperial;
        this.metric = metric;
        this.id = id;
        this.name = name;
        this.cfa_url = cfa_url;
        this.vetstreet_url = vetstreet_url;
        this.vcahospitals_url = vcahospitals_url;
        this.temperament = temperament;
        this.origin = origin;
        this.country_codes = country_codes;
        this.country_code = country_code;
        this.description = description;
        this.life_span = life_span;
        this.indoor = indoor;
        this.lap = lap;
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
        this.hairless = hairless;
        this.natural = natural;
        this.rare = rare;
        this.rex = rex;
        this.suppressed_tail = suppressed_tail;
        this.short_legs = short_legs;
        this.hypoallergenic = hypoallergenic;
        this.wikipedia_url = wikipedia_url;
        this.reference_image_id = reference_image_id;
       // this.image = image;
    }

    public String getImperial() {
        return imperial;
    }

    public String getMetric() {
        return metric;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCfa_url() {
        return cfa_url;
    }

    public String getVetstreet_url() {
        return vetstreet_url;
    }

    public String getVcahospitals_url() {
        return vcahospitals_url;
    }

    public String getTemperament() {
        return temperament;
    }

    public String getOrigin() {
        return origin;
    }

    public String getCountry_codes() {
        return country_codes;
    }

    public String getCountry_code() {
        return country_code;
    }

    public String getDescription() {
        return description;
    }

    public String getLife_span() {
        return life_span;
    }

    public int getIndoor() {
        return indoor;
    }

    public int getLap() {
        return lap;
    }

    public String getAlt_names() {
        return alt_names;
    }

    public int getAdaptability() {
        return adaptability;
    }

    public int getAffection_level() {
        return affection_level;
    }

    public int getChild_friendly() {
        return child_friendly;
    }

    public int getDog_friendly() {
        return dog_friendly;
    }

    public int getEnergy_level() {
        return energy_level;
    }

    public int getGrooming() {
        return grooming;
    }

    public int getHealth_issues() {
        return health_issues;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getShedding_level() {
        return shedding_level;
    }

    public int getSocial_needs() {
        return social_needs;
    }

    public int getStranger_friendly() {
        return stranger_friendly;
    }

    public int getVocalisation() {
        return vocalisation;
    }

    public int getExperimental() {
        return experimental;
    }

    public int getHairless() {
        return hairless;
    }

    public int getNatural() {
        return natural;
    }

    public int getRare() {
        return rare;
    }

    public int getRex() {
        return rex;
    }

    public int getSuppressed_tail() {
        return suppressed_tail;
    }

    public int getShort_legs() {
        return short_legs;
    }

    public int getHypoallergenic() {
        return hypoallergenic;
    }

    public String getWikipedia_url() {
        return wikipedia_url;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }

    public Image getImage() {
        return image;
    }

    public void setImperial(String imperial) {
        this.imperial = imperial;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCfa_url(String cfa_url) {
        this.cfa_url = cfa_url;
    }

    public void setVetstreet_url(String vetstreet_url) {
        this.vetstreet_url = vetstreet_url;
    }

    public void setVcahospitals_url(String vcahospitals_url) {
        this.vcahospitals_url = vcahospitals_url;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setCountry_codes(String country_codes) {
        this.country_codes = country_codes;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public void setIndoor(int indoor) {
        this.indoor = indoor;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public void setAlt_names(String alt_names) {
        this.alt_names = alt_names;
    }

    public void setAdaptability(int adaptability) {
        this.adaptability = adaptability;
    }

    public void setAffection_level(int affection_level) {
        this.affection_level = affection_level;
    }

    public void setChild_friendly(int child_friendly) {
        this.child_friendly = child_friendly;
    }

    public void setDog_friendly(int dog_friendly) {
        this.dog_friendly = dog_friendly;
    }

    public void setEnergy_level(int energy_level) {
        this.energy_level = energy_level;
    }

    public void setGrooming(int grooming) {
        this.grooming = grooming;
    }

    public void setHealth_issues(int health_issues) {
        this.health_issues = health_issues;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setShedding_level(int shedding_level) {
        this.shedding_level = shedding_level;
    }

    public void setSocial_needs(int social_needs) {
        this.social_needs = social_needs;
    }

    public void setStranger_friendly(int stranger_friendly) {
        this.stranger_friendly = stranger_friendly;
    }

    public void setVocalisation(int vocalisation) {
        this.vocalisation = vocalisation;
    }

    public void setExperimental(int experimental) {
        this.experimental = experimental;
    }

    public void setHairless(int hairless) {
        this.hairless = hairless;
    }

    public void setNatural(int natural) {
        this.natural = natural;
    }

    public void setRare(int rare) {
        this.rare = rare;
    }

    public void setRex(int rex) {
        this.rex = rex;
    }

    public void setSuppressed_tail(int suppressed_tail) {
        this.suppressed_tail = suppressed_tail;
    }

    public void setShort_legs(int short_legs) {
        this.short_legs = short_legs;
    }

    public void setHypoallergenic(int hypoallergenic) {
        this.hypoallergenic = hypoallergenic;
    }

    public void setWikipedia_url(String wikipedia_url) {
        this.wikipedia_url = wikipedia_url;
    }

    public void setReference_image_id(String reference_image_id) {
        this.reference_image_id = reference_image_id;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
