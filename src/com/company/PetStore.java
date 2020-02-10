package com.company;

import java.util.ArrayList;
import java.util.List;

public class PetStore {
    static List<Pet> petList;
    static List<Pet> petsSold;

    public PetStore() {
        petList = generatePetList();
    }

    private List<Pet> generatePetList(){
        petList = new ArrayList<>();
        do{
            petList.add(new Pet()); }
        while (NameGenerator.availablePetNames.size() > 0);
        return petList;
    }

    public static void sellPets(List<Person> persons){
        for(Person person: persons){
            petsSold = new ArrayList<>();
            int numberOfPets = (int) (Math.random() * 6);
            for(int i = 0; i < numberOfPets; i++){
                int petNamePos = (int)(Math.random() * petList.size());
                Pet petName = petList.get(petNamePos);
                petList.remove(petNamePos);
                petsSold.add(petName);
            }
            person.addPets(petsSold);
        }
    }
}
