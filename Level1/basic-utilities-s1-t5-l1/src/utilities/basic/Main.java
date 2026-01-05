package utilities.basic;

import java.io.File;
import java.util.Scanner;

public class Main {

    private static final String OUTPUT_PATH = "C:\\Users\\fonca\\IdeaProjects\\Sprint1\\T5_Utils\\Level1\\basic-utilities-s1-t5-l1\\test-directory\\directory_tree_output.txt";
    private static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        cleanOutputFile();

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
        System.out.print("Enter your choice (1, 2, 3 or 4): ");

        Scanner scanner = new Scanner(System.in);

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
                ReadAndWriteFile();
            }else {
                System.out.println("\nInvalid choice! Defaulting to Exercise 1.");
                System.out.println("Exercise 1: Alphabetical List");
                DirectoryLister.listDirectoryAlphabetically(directory);
            }

        } catch (Exception e) {
            System.err.println("Error: Please enter a valid number (1 or 2)");
            System.err.println("Using default Exercise 1...");
            DirectoryLister.listDirectoryAlphabetically("test-directory");
        }
    }

    private static void cleanOutputFile() {
        File outputFile = new File(OUTPUT_PATH);

        if (outputFile.exists()) {
            if (outputFile.delete()) {
                System.out.println("Previous output file deleted: " + OUTPUT_PATH);
            } else {
                System.err.println("Warning: Could not delete previous output file: " + OUTPUT_PATH);
            }
        }
    }

    private static void ReadAndWriteFile() {
        System.out.print("File Path: ");
        String filePath = scanner.nextLine();
        System.out.print("File Name: ");
        String fileName = scanner.nextLine();

        TXTFileReader fileReader = new TXTFileReader();
        fileReader.readAndShow(filePath, fileName);
    }

}
