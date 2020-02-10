package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serializer {
    private static final Serializer INSTANCE = new Serializer();

    public static Serializer getInstance() {
        return Serializer.INSTANCE;
    }



    public final void writeObject(Object x, String filePath){
        Path path = Paths.get(filePath);

        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(x); // Serializes
            System.out.println("serializedFile: " + x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final Object readObject(String filePath) {
        Path path = Paths.get(filePath);
        Object object = null; // De-serializes

        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            object = ois.readObject();
            System.out.println("DeserializedFile -> " + object);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}

