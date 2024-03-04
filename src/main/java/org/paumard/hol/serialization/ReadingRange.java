package org.paumard.hol.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingRange {

    public static void main(String[] args) {

        Path path = Path.of("files/range.bin");

        try (var inputStream = Files.newInputStream(path);
             var objectInputStream = new ObjectInputStream(inputStream)) {

            var range = objectInputStream.readObject();
            System.out.println("range = " + range);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
