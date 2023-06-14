package com.pragma.mycats.model;

public class Cat {

    private String id;
    private String name;
    private String origin;
    private String reference_image_id;
    private int affectionLevel;
    private int intelligence;

    public Cat(String id, String name, String origin, String reference_image_id, int affectionLevel, int intelligence) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.reference_image_id = reference_image_id;
        this.affectionLevel = affectionLevel;
        this.intelligence = intelligence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAffectionLevel() {
        return affectionLevel;
    }

    public void setAffectionLevel(int affectionLevel) {
        this.affectionLevel = affectionLevel;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public String getReference_image_id() {
        return reference_image_id;
    }

    public void setReference_image_id(String reference_image_id) {
        this.reference_image_id = reference_image_id;
    }
}
