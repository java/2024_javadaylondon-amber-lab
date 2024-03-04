package org.paumard.hol.serialization;

import org.paumard.hol.serialization.model.RangeLegacy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class WritingRange {

    public static void main(String[] args) {

        Path path = Path.of("files/range.bin");

        var range = new RangeLegacy(10, 0);
        System.out.println("range = " + range);

        try (var outputStream = Files.newOutputStream(path);
             var objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(range);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
