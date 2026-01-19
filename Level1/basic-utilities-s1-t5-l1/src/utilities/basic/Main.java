package utilities.basic;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static final Path OUTPUT_PATH = Paths.get("test-directory", "directory_tree_output.txt");
    private static final Path SERIALIZATION_PATH = Paths.get("test-directory", "serialized_object.ser");

    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        cleanOutputFile();
        cleanSerializationFile();
        cleanEncryptedFiles();

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
        System.out.println("6. Encrypt/Decrypt File with AES (Exercise 6)");
        System.out.print("Enter your choice (1-6): ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            String directory = "test-directory";
            // Utilitzar toString() quan es necessiti String
            String outputPath = OUTPUT_PATH.toString();

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
            } else if (choice == 6) {
                System.out.println("\nExercise 6: File Encryption/Decryption with AES");
                fileEncryptionDemo();
            } else {
                System.out.println("\nInvalid choice! Defaulting to Exercise 1.");
                System.out.println("Exercise 1: Alphabetical List");
                DirectoryLister.listDirectoryAlphabetically(directory);
            }

        } catch (Exception e) {
            System.err.println("Error: Please enter a valid number (1 to 6)");
            System.err.println("Using default Exercise 1...");
            DirectoryLister.listDirectoryAlphabetically("test-directory");
        }
    }

    private static void cleanOutputFile() {
        File outputFile = OUTPUT_PATH.toFile();

        if (outputFile.exists()) {
            if (outputFile.delete()) {
                System.out.println("Previous output file deleted: " + OUTPUT_PATH);
            } else {
                System.err.println("Warning: Could not delete previous output file: " + OUTPUT_PATH);
            }
        }
    }

    private static void cleanSerializationFile() {
        File serFile = SERIALIZATION_PATH.toFile();
        deleteFileIfExists(serFile, SERIALIZATION_PATH.toString());
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
            ObjectSerializer.serializeObject(customObject, SERIALIZATION_PATH.toString());

            System.out.println("\nDeserializing object...");
            ExampleData restoredObject = (ExampleData) ObjectSerializer.deserializeObject(SERIALIZATION_PATH.toString());

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

            ObjectSerializer.serializeObject(defaultObject, SERIALIZATION_PATH.toString());
            ExampleData restoredObject = (ExampleData) ObjectSerializer.deserializeObject(SERIALIZATION_PATH.toString());

            if (restoredObject != null) {
                System.out.println("\nRestored object: " + restoredObject);
            }
        }
    }

    private static void fileEncryptionDemo() {
        System.out.println("\nAES File Encryption Demo (CBC Mode):\n");

        Path basePath = Paths.get("test-directory");
        String inputFile = basePath.resolve("fileToRead.txt").toString();
        String encryptedFile = basePath.resolve("fileToRead.enc").toString();
        String decryptedFile = basePath.resolve("fileToRead.dec.txt").toString();

        try {
            File input = new File(inputFile);

            System.out.println("Encryption details:");
            System.out.println("- Algorithm: AES-128");
            System.out.println("- Mode: CBC (Cipher Block Chaining)");
            System.out.println("- Padding: PKCS5Padding");
            System.out.println("- Original file: " + input.length() + " bytes");
            System.out.println();

            System.out.println("Original file content (first 3 lines):");
            showFilePreview(inputFile, 3);
            System.out.println();

            FileEncryptor.encryptFile(inputFile, encryptedFile);

            String hexPreview = FileEncryptor.getHexPreview(encryptedFile, 48);
            System.out.println("Hex preview (first 48 bytes): " + hexPreview);

            FileEncryptor.decryptFile(encryptedFile, decryptedFile);

            System.out.println("Decrypted file content (first 3 lines):");
            showFilePreview(decryptedFile, 3);
            System.out.println();

            System.out.println("Original file:  " + new File(inputFile).length() + " bytes");
            System.out.println("Encrypted file: " + new File(encryptedFile).length() + " bytes");
            System.out.println("Decrypted file: " + new File(decryptedFile).length() + " bytes");

        } catch (Exception e) {
            System.err.println("\n✗ Error: " + e.getMessage());
        }
    }

    private static void cleanEncryptedFiles() {
        Path basePath = Paths.get("test-directory");
        Path[] filesToDelete = {
                basePath.resolve("fileToRead.enc"),
                basePath.resolve("fileToRead.dec.txt")
        };

        for (Path filePath : filesToDelete) {
            File file = filePath.toFile();
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Deleted: " + filePath);
                } else {
                    System.err.println("Warning: Could not delete: " + filePath);
                }
            }
        }
    }

    private static void showFilePreview(String filePath, int numLines) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null && lineCount < numLines) {
                System.out.println("  " + line);
                lineCount++;
            }
        }
    }
}