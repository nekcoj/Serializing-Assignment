package com.company;

import java.io.IOException;
import java.util.*;

public class Program {
    public List<Person> persons = new ArrayList<>();

    public Program() throws IOException {
        new NameGenerator();
        new PetStore();
        for (String n : NameGenerator.getNames()) {
            Person p = new Person(n);
            persons.add(p);
        }
        PetStore.sellPets(persons);
        Serializer.getInstance().writeObject(persons.get(1), "Person");
        Objects.requireNonNull(Serializer.getInstance().readObject("Person"));

        Serializer.getInstance().writeObject(PetStore.petList.get(1), "Pet");
        Serializer.getInstance().readObject("Pet");

    }
}