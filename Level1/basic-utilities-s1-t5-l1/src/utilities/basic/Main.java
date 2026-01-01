package utilities.basic;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            String directoryPath = args[0];
            DirectoryLister.listDirectoryAlphabetically(directoryPath);
        } else {
            String defaultDirectoryPath = "test-directory";
            DirectoryLister.listDirectoryAlphabetically(defaultDirectoryPath);
        }
    }
}
