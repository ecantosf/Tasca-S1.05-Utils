package utilities.basic;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class DirectoryLister {
    // Exercici 1: Llistar contingut alfabètic
    // Exercici 2: Llistar arbre directoris amb D/F i data
    // Exercici 3: Guardar resultat en fitxer TXT

    public static void listDirectoryAlphabetically(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.err.println("Error: Directory " + directoryPath + " does not exist.");
            return;
        }

        if(!directory.isDirectory()) {
            System.err.println("Error: Directory " + directoryPath + " is not directory.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.err.println("Error: Directory " + directoryPath + " is empty.");
            return;
        }

        assert files != null;
        Arrays.sort(files, Comparator.comparing(File::getName));

        System.out.println("Directory contents: " + directoryPath);

        for (File file : files) {
            String type = file.isDirectory() ? "[Directory]" : "[File]";
            System.out.println("\t" + type + " " + file.getName());
        }

    }
}
