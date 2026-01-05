package utilities.basic;

import java.io.*;

public class ObjectSerializer {

    private static final String DEFAULT_SERIALIZATION_PATH = "C:\\Users\\fonca\\IdeaProjects\\Sprint1\\T5_Utils\\Level1\\basic-utilities-s1-t5-l1\\test-directory\\serialized_object.ser";

    public static void serializeObject(Object obj, String filePath) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(obj);
            System.out.println("Object serialized successfully to: " + filePath);

        } catch (IOException e) {
            System.err.println("Error serializing object: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static Object deserializeObject(String filePath) {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            Object obj = in.readObject();
            System.out.println("Object deserialized successfully from: " + filePath);
            return obj;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error deserializing object: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void runSerializationDemo(String filePath) {
        System.out.println("\n=== Serialization Demo ===");

        ExampleData originalObject = new ExampleData("Test Object", 42);
        System.out.println("Original object created: " + originalObject);

        System.out.println("\nSerializing object...");
        serializeObject(originalObject, filePath);

        System.out.println("\nDeserializing object...");
        ExampleData deserializedObject = (ExampleData) deserializeObject(filePath);

        if (deserializedObject != null) {
            System.out.println("Deserialized object: " + deserializedObject);
            System.out.println("Are they equal? " + originalObject.equals(deserializedObject));
        }
    }
}