# Java Utils Exercises 

## Description
In this task, we will work with different Java utilities that are fundamental for 
software development in real-world environments. You will learn how to manage files 
and directories, read and write data, configure your code flexibly, and even protect 
information with basic encryption techniques.

We will work step-by-step, from simple functionalities to more advanced operations, 
structured in three levels. Additionally, all activities must be executed from the 
command line: this will help you better understand how your code works outside the 
editor, and it will prepare you for professional environments where mastering the 
terminal is key.
  
## Exercise Statement
Level 1: At this first level, we will work with some of Java's basic utilities for 
managing files and directories, as well as for reading and writing information to 
the file system.
You will become familiar with very common operations in the world of development: 
navigating directories, filtering and sorting content, saving data to files, and 
serializing objects.
This set of exercises will allow you to practice:
- Using the File class to access and manage files.
- orking with recursive structures, such as directory trees.
- Manipulating input/output (I/O) streams.
- Persisting objects through serialization.
By the end of this level, you will have created a small set of tools for working 
with the file system that you can reuse or expand in future projects.

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
- Build Tool: Maven/Gradle (if applicable)
- Version Control: Git

## Installation and Execution
1. Create GitHub repository
2. Open the project in IntelliJ IDEA.
3. Configure JDK (Java 21 or later recommended).
4. Run the main class of each exercise directly from the IDE.
5. To run tests (if applicable)

## Demo
No aplicable.

## Diagrams and Technical Decisions
No aplicable.