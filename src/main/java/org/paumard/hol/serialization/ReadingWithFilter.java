package org.paumard.hol.serialization;

import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReadingWithFilter {

    public static void main(String[] args) {

        ObjectInputFilter onlyRecords =
                filterInfo -> {
                    System.out.println(filterInfo.serialClass());
                    return filterInfo.serialClass().isRecord() ?
                            ObjectInputFilter.Status.ALLOWED : ObjectInputFilter.Status.REJECTED;
                };

        ObjectInputFilter classesFromModelPackage =
                ObjectInputFilter.Config.createFilter("org.paumard.hol.serialization.model.*");

        ObjectInputFilter recordsFromModel = ObjectInputFilter.merge(onlyRecords, classesFromModelPackage);
        ObjectInputFilter.Config.setSerialFilter(recordsFromModel);

        Path path = Path.of("files/range.bin");
//        Path path = Path.of("files/range-legacy-10-0.bin");

        try (var inputStream = Files.newInputStream(path);
             var objectInputStream = new ObjectInputStream(inputStream)) {

            var allowRangeLegacy =
                    ObjectInputFilter.Config.createFilter("org.paumard.hol.serialization.model.RangeLegacy");
            objectInputStream.setObjectInputFilter(allowRangeLegacy);
            var range = objectInputStream.readObject();
            System.out.println("range = " + range);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
