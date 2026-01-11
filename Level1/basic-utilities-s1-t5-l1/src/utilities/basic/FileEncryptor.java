package utilities.basic;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.SecureRandom;
import java.nio.charset.StandardCharsets;

public class FileEncryptor {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private static final String SECRET_KEY = "MySecretKey12345";

    public static void encryptFile(String inputFile, String outputFile) throws Exception {
        System.out.println("\nEncrypting file: " + inputFile);

        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        SecretKey secretKey = new SecretKeySpec(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            fos.write(iv);
            processFile(cipher, fis, fos);
        }

        System.out.println("Encrypted file created: " + outputFile);
    }

    public static void decryptFile(String inputFile, String outputFile) throws Exception {
        System.out.println("\nDecrypting file: " + inputFile);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] iv = new byte[16];
            fis.read(iv);
            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            SecretKey secretKey = new SecretKeySpec(
                    SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

            processFile(cipher, fis, fos);
        }

        System.out.println("Decrypted file created: " + outputFile);
    }

    private static void processFile(Cipher cipher, InputStream input, OutputStream output)
            throws Exception {
        byte[] buffer = new byte[1024];
        int bytesRead;

        while ((bytesRead = input.read(buffer)) != -1) {
            byte[] processed = cipher.update(buffer, 0, bytesRead);
            if (processed != null) {
                output.write(processed);
            }
        }

        byte[] finalBytes = cipher.doFinal();
        if (finalBytes != null) {
            output.write(finalBytes);
        }
    }

    public static String getHexPreview(String filePath, int bytesToShow) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) return "File not found";

        StringBuilder hexString = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[bytesToShow];
            int bytesRead = fis.read(buffer);

            for (int i = 0; i < bytesRead; i++) {
                hexString.append(String.format("%02X ", buffer[i]));
                if ((i + 1) % 16 == 0 && i < bytesRead - 1) {
                    hexString.append("\n" + " ".repeat(29));
                }
            }
        }
        return hexString.toString();
    }
}