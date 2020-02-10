package com.company;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person implements Serializable {
    String name;
    int age;
    List<Pet> pets = new ArrayList<>();

    public Person(String name) {
        this.name = name;
        this.age =(int) (Math.random() * 33) + 18;
    }

    public String getName() {
        return name;
    }

    public void addPets(List<Pet> pet){
            pets.addAll(pet);
    }

    public List<Pet> getPetListFromPerson(){
        return pets;
    }

    public String getResultOne(){
        Map<String, List<String>> result = pets.stream()
                .collect(Collectors.groupingBy(Pet::getPetType, Collectors.mapping(Pet::getPetName, Collectors.toList())))  ;
        Map<String, List<String>> newResult = new HashMap<>();
        for (String key: result.keySet()) {
            List<String> singOrPlu = result.get(key);
            if(singOrPlu.size() > 1){
                newResult.put(key + "s", singOrPlu);
            } else newResult.put(key, singOrPlu);

        }
        return Stream.of(newResult).filter(pets -> !pets.isEmpty())
                .map(Map::entrySet)
                .collect(Collectors.toList()).toString()
                .replaceAll("\\[", "")
                .replaceAll("]", "")
                .replaceAll("=", ": ");
    }

    @Override
    public String toString() {
        if(pets.size() == 0) return "Person " + name + " (" + age + ") has no pets.";
        if(pets.size() == 1) return "Person " + name.toUpperCase() + " (" + age + ") owns the " + getResultOne();
        return "Person " + name.toUpperCase() + " (" + age + ") owns the animals: [" + getResultOne() + "]";
    }
}
