package com.company;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Pet implements Serializable {
    List<String> petTypes = Arrays.asList("Snake", "Pig", "Dog", "Cat", "Spider");
    public String petType = "";
    public String petName;

    public Pet() {
        petName = NameGenerator.getPetName();
        if(!petName.equals(""))
        this.petType = petTypes.get((int)(Math.random() * 5));
    }

    public String getPetType() {
        return this.petType;
    }

    public String getPetName() {
        return this.petName;
    }

    @Override
    public String toString() {
        return petType + ": " + petName;
    }
}
