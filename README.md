# Java Utils Exercises 

## Description
This project provides hands-on experience with fundamental Java utilities used in 
real-world software development. You'll learn to manage files and directories, read 
and write data, configure applications flexibly, and protect information with basic 
encryption techniques.

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
    -- Navigate to the source directory: cd src
    -- Compile all Java files: javac -d out src/utilities/basic/*.java
- Execution:
    -- Navigate to the output directory: cd ../out
	-- Run the main class: java -cp out utilities.basic.Main

Level 2: At this level, you will learn to parameterize the behavior of your 
applications, a fundamental step toward making them more flexible, reusable, and 
adaptable to different environments.
You will focus on extracting configuration from the code and moving it to an 
external file, such as a .properties file, widely used in Java projects. You will 
also have the option to explore more advanced libraries like Apache Commons 
Configuration.
Starting from an already completed exercise from the previous level, you will modify 
your program to read the following configuration from a file:
- Which directory should be read.
- What the name and location of the resulting TXT file should be.
This practice will help you better understand how to separate configuration from 
program logic, a key skill in professional environments and in the development of 
scalable applications.

Level 3: In this final level, you will delve into a key concept of computer 
security: data encryption.
You will have to create a utility that enables the encryption and decryption of 
files, applying one of the most widely used algorithms in the real world: 
AES (Advanced Encryption Standard), in ECB or CBC modes, with PKCS5Padding.
You will be able to use Java's standard libraries (javax.crypto) or explore more 
powerful alternatives such as org.apache.commons.crypto.
The goal is to understand how to protect sensitive information using symmetric 
cryptography and apply it to real-world cases, such as files generated in previous 
exercises. This exercise prepares you for professional environments where security 
and privacy are essential.

## Features
- Practice using Java's basic libraries (java.io, java.util, java.nio.file, etc.).
- Learn to navigate directories, create files, read and write text, and work with 
configuration files.
- Understand the process of object serialization and deserialization.
- Discover how to protect data with AES encryption.
- Ensure code portability by using relative paths and File.separator.
+ Familiarize yourself with the manual compilation and execution process of programs.

## Technologies
- Language: Java
- IDE: IntelliJ IDEA
- Build Tool: Maven/Gradle (not applicable in this project)
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