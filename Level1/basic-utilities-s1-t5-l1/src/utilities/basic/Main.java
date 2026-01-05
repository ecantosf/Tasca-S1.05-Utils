package utilities.basic;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static final String OUTPUT_PATH = "C:\\Users\\fonca\\IdeaProjects\\Sprint1\\T5_Utils\\Level1\\basic-utilities-s1-t5-l1\\test-directory\\directory_tree_output.txt";
    private static final String SERIALIZATION_PATH = "C:\\Users\\fonca\\IdeaProjects\\Sprint1\\T5_Utils\\Level1\\basic-utilities-s1-t5-l1\\test-directory\\serialized_object.ser";
    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        cleanOutputFile();
        cleanSerializationFile();

        if (args.length > 0) {
            String directoryPath = args[0];
            DirectoryLister.listDirectoryAlphabetically(directoryPath);
        } else {
            showSimpleMenu();
        }
    }

    private static void showSimpleMenu() {
        System.out.println("Directory Lister:");
        System.out.println("\nSelect Exercise:");
        System.out.println("1. Alphabetically (Exercise 1)");
        System.out.println("2. Directory Tree (Exercise 2)");
        System.out.println("3. Save Directory Tree to TXT file (Exercise 3)");
        System.out.println("4. Read and Show from TXT file (Exercise 4)");
        System.out.println("5. Serialize/Deserialize Objects (Exercise 5)");
        System.out.print("Enter your choice (1, 2, 3, 4 or 5): ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            String directory = "test-directory";
            String outputPath = OUTPUT_PATH;

            if (choice == 1) {
                System.out.println("\nExercise 1: Alphabetical List");
                DirectoryLister.listDirectoryAlphabetically(directory);
            } else if (choice == 2) {
                System.out.println("\nExercise 2: Directory Tree");
                DirectoryLister.listDirectoryTree(directory);
            } else if (choice == 3) {
                System.out.println("\nExercise 3: Save Directory Tree to TXT File");
                System.out.println("Saving directory tree to: " + outputPath);
                DirectoryLister.saveDirectoryTreeToFile(directory, outputPath);
            } else if (choice == 4) {
                System.out.println("\nExercise 4: Read and Show TXT File");
                readAndWriteFile();
            } else if (choice == 5) {
                System.out.println("\nExercise 5: Serialize/Deserialize Objects");
                objectSerializerDemo();
            } else {
                System.out.println("\nInvalid choice! Defaulting to Exercise 1.");
                System.out.println("Exercise 1: Alphabetical List");
                DirectoryLister.listDirectoryAlphabetically(directory);
            }

        } catch (Exception e) {
            System.err.println("Error: Please enter a valid number (1 to 5)");
            System.err.println("Using default Exercise 1...");
            DirectoryLister.listDirectoryAlphabetically("test-directory");
        }
    }

    private static void cleanOutputFile() {
        File outputFile = new File(Main.OUTPUT_PATH);

        if (outputFile.exists()) {
            if (outputFile.delete()) {
                System.out.println("Previous output file deleted: " + Main.OUTPUT_PATH);
            } else {
                System.err.println("Warning: Could not delete previous output file: " + Main.OUTPUT_PATH);
            }
        }
    }

    private static void cleanSerializationFile() {
        File serFile = new File(Main.SERIALIZATION_PATH);
        deleteFileIfExists(serFile, Main.SERIALIZATION_PATH);
    }

    private static void deleteFileIfExists(File file, String filePath) {
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Previous file deleted: " + filePath);
            } else {
                System.err.println("Warning: Could not delete previous file: " + filePath);
            }
        }
    }

    private static void readAndWriteFile() {
        System.out.print("File Path: ");
        String filePath = Main.scanner.nextLine();
        System.out.print("File Name: ");
        String fileName = Main.scanner.nextLine();

        TXTFileReader fileReader = new TXTFileReader();
        fileReader.readAndShow(filePath, fileName);
    }

    private static void objectSerializerDemo() {
        System.out.println("\n=== Object Serialization Demo ===");

        System.out.print("Enter object name: ");
        String name = scanner.nextLine();

        System.out.print("Enter integer value: ");
        try {
            int value = Integer.parseInt(scanner.nextLine());

            ExampleData customObject = new ExampleData(name, value);
            System.out.println("Object created: " + customObject);

            System.out.println("\nSerializing object...");
            ObjectSerializer.serializeObject(customObject, SERIALIZATION_PATH);

            System.out.println("\nDeserializing object...");
            ExampleData restoredObject = (ExampleData) ObjectSerializer.deserializeObject(SERIALIZATION_PATH);

            if (restoredObject != null) {
                System.out.println("\nRestored object: " + restoredObject);
                System.out.println("\nComparison:");
                System.out.println("Original: " + customObject);
                System.out.println("Restored: " + restoredObject);
                System.out.println("Same name? " + customObject.getName().equals(restoredObject.getName()));
                System.out.println("Same value? " + (customObject.getValue() == restoredObject.getValue()));
            }
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid integer value entered. Using default values.");

            ExampleData defaultObject = new ExampleData("Default Object", 100);
            System.out.println("Using default object: " + defaultObject);

            ObjectSerializer.serializeObject(defaultObject, SERIALIZATION_PATH);
            ExampleData restoredObject = (ExampleData) ObjectSerializer.deserializeObject(SERIALIZATION_PATH);

            if (restoredObject != null) {
                System.out.println("\nRestored object: " + restoredObject);
            }
        }
    }
}
