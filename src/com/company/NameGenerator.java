package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NameGenerator {
    Stream<String> petNamesFromFile = Files.lines(Paths.get("pet-names-4.txt"));
    static List<String> petNames;
    static List<String> availablePetNames;
    static List<String> names = Arrays.asList("Raffe", "Hang", "Sofia", "Alexandra", "Michelle", "Joacim", "Janis", "Petru", "Anton", "Tien"
            , "Alexander", "Calle", "Magnus", "Markus", "David", "Daniel");


    public NameGenerator() throws IOException {
        petNames = new ArrayList<>(getPetNamesFromFile());
        availablePetNames = petNames;
    }

    private List<String> getPetNamesFromFile() {
        return Arrays.asList(petNamesFromFile.map(s -> s.replaceAll("\\s", "")
                .replaceAll("\\d+.", " ")
                .replaceAll("\"", "")
                .replaceAll(",", "")
                .strip())
                .filter(s -> !s.isBlank())
                .collect(Collectors.joining()).split("\\s"));
    }

    public void printPetNames(List<String> printList){
        printList.forEach(s -> System.out.printf("%s\n", s));
    }

    public static String getPetName(){
        int petNamePos = (int)(Math.random() * availablePetNames.size());
        String petName = "";
        if(!availablePetNames.isEmpty()) {
             petName = availablePetNames.get(petNamePos);
            availablePetNames.remove(petNamePos);
        }
        return petName;
    }

    public static List<String> getNames(){
        return names;
    }
}
