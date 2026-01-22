# Java Utils Exercises 

## Description
This project provides hands-on experience with fundamental Java utilities used in 
real-world software development. You'll learn to manage files and directories, read 
and write data, configure applications flexibly, and protect information with basic 
encryption techniques.
if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("Error: " + directoryPath + " is not a valid directory.");
            return;
        }src
The exercises are structured in three progressive levels, from basic operations to 
advanced concepts. All activities are designed to be executed from the command line, 
helping you understand how your code operates outside the IDE and preparing you for 
professional environments where terminal proficiency is essential.
  
## Exercise Statement
Level 1: At this first level, we will work with some of Java's basic utilities for 
managing files and directories, as well as for reading and writing information to 
the file system.
You will become familiar with very common operations in the world of development: 
navigating directories, filtering and sorting content, saving data to files, and 
serializing objects.
This set of exercises will allow you to practice:
- Using the File class to access and manage files.
- Working with recursive structures, such as directory trees.
- Manipulating input/output (I/O) streams.
- Persisting objects through serialization.
By the end of this level, you will have created a small set of tools for working 
with the file system that you can reuse or expand in future projects.

## Exercise 1:
All exercises are implemented within the same package with the following organization:
- Main.java: Entry point with a console menu to execute all functionalities
- DirectoryLister.java: Contains methods for exercises 1-3 (file system operations)
- TXTFileReader.java: Handles exercise 4 (configuration-based file reading)
- ObjectSerializer.java: Manages exercise 5 (object serialization/deserialization)
- ExampleData.java: Example class used for serialization demonstrations

Command Line Execution (Git Bash):
- Compilation:
    -- Navigate to the source directory: cd utilities/basic
    -- Compile all Java files: javac -d out utilities/basic/*.java
- Execution:
    -- Navigate to the output directory: cd ../out
	-- Run the main class: java -cp out utilities.basic.Main

Level 2: (Not implemented in this version of the project)

Level 3: File Encryption & Decryption
In this final level, you implemented a file encryption and decryption utility using
industry-standard AES (Advanced Encryption Standard) cryptography with the following
implementation Details:
- Algorithm: AES-128 (Advanced Encryption Standard, 128-bit key)
- Mode: CBC (Cipher Block Chaining) - More secure than ECB as it prevents pattern recognition
- Padding: PKCS5Padding - Ensures proper block alignment for variable-length data
- Library: javax.crypto (Java Cryptography Extension - Standard Java library)

## Features
- Practice using Java's basic libraries (java.io, java.util, java.nio.file, etc.).
- Learn to navigate directories, create files, read and write text, and work with 
configuration files.
- Understand the process of object serialization and deserialization.
- Discover how to protect data with AES encryption.
- Ensure code portability by using relative paths and File.separator.
+ Familiarize yourself with the manual compilation and execution process of programs.

## Project Structure
- All exercises are implemented within the same package with the following organization:
- Main.java: Entry point with a console menu to execute all functionalities
- DirectoryLister.java: Contains methods for exercises 1-3 (file system operations)
- TXTFileReader.java: Handles exercise 4 (configuration-based file reading)
- ObjectSerializer.java: Manages exercise 5 (object serialization/deserialization)
- ExampleData.java: Example class used for serialization demonstrations
- FileEncryptor.java: New class for Level 3 (AES encryption/decryption)

## Technologies
- Language: Java
- IDE: IntelliJ IDEA
- Cryptography Library: javax.crypto (Java Cryptography Extension)
- Version Control: Git

## Installation and Execution
1. Create GitHub repository
2. Open the project in IntelliJ IDEA.
3. Configure JDK (Java 21 or later recommended).
4. Run the main class of each exercise directly from the IDE.
5. To run tests (if applicable)
6. Command Line Compilation & Execution. To manually compile and run the Java exercises 
from the terminal:
6.1. Compile Java source files to bytecode
	javac -d . *.java
6.2. Run the compiled program (replace MainClassName with actual class name)
	java MainClassName

## Demo
Not applicable.

## Diagrams and Technical Decisions
Not applicable.