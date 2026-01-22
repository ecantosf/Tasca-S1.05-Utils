package utilities.basic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DirectoryLister {

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

    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void listDirectoryTree(String directoryPath) {
        File rootDir = new File(directoryPath);

        if (!rootDir.exists()) {
            System.err.println("Error: Directory " + directoryPath + " does not exist.");
            return;
        }

        if (!rootDir.isDirectory()) {
            System.err.println("Error: " + directoryPath + " is not a directory.");
            return;
        }

        System.out.println("\nDirectory Tree: " + directoryPath);
        System.out.println("=".repeat(70)); //Revisar

        listDirectoryTreeRecursive(rootDir, "", 0);
    }

    private static void listDirectoryTreeRecursive(File currentDir, String indent, int depth) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }

        Arrays.sort(files, Comparator.comparing(File::getName));

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            boolean isLast = (i == files.length - 1);
            String currentIndent = indent + (isLast ? "└── " : "├── ");

            String type = file.isDirectory() ? "D" : "F";

            Date lastModified = new Date(file.lastModified());
            String dateStr = DATE_FORMAT.format(lastModified);

            System.out.printf("%s%s %-45s %s%n",
                    currentIndent, type, file.getName(), dateStr);

            if (file.isDirectory()) {
                String newIndent = indent + (isLast ? "    " : "│   ");
                listDirectoryTreeRecursive(file, newIndent, depth + 1);
            }
        }
    }

    public static void saveDirectoryTreeToFile(String directoryPath, String outputFilePath) {
        StringBuilder result = new StringBuilder();

        File rootDir = new File(directoryPath);

        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("Error: " + directoryPath + " is not a valid directory.");
            return;
        }

        result.append("Directory Tree: ").append(directoryPath).append("\n");
        result.append("=".repeat(70)).append("\n");

        saveDirectoryTreeRecursive(rootDir, "", 0, result);

        try (FileWriter writer = new FileWriter(outputFilePath)) {
            writer.write(result.toString());
            System.out.println("Directory tree successfully saved to: " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static void saveDirectoryTreeRecursive(File currentDir, String indent, int depth, StringBuilder result) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            return;
        }

        Arrays.sort(files, Comparator.comparing(File::getName));

        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            boolean isLast = (i == files.length - 1);
            String currentIndent = indent + (isLast ? "└── " : "├── ");

            String type = file.isDirectory() ? "D" : "F";

            Date lastModified = new Date(file.lastModified());
            String dateStr = DATE_FORMAT.format(lastModified);

            result.append(String.format("%s%s %-45s %s%n",
                    currentIndent, type, file.getName(), dateStr));

            if (file.isDirectory()) {
                String newIndent = indent + (isLast ? "    " : "│   ");
                saveDirectoryTreeRecursive(file, newIndent, depth + 1, result);
            }
        }
    }

}
