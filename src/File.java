import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class File {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        String fileName1 = getValidFileName(scanner);
        String fileName2 = getValidFileName(scanner);
        
        System.out.println("\nBoth files were found successfully.");
        System.out.println("File 1: " + fileName1);
        System.out.println("File 2: " + fileName2);
        
        scanner.close();
    }

    public static String getValidFileName(Scanner scanner) {
        String fileName = "";
        boolean fileProcessed = false;
        
        while (!fileProcessed) {
            System.out.print("Please enter the file name (e.g., CS.txt): ");
            fileName = scanner.nextLine();
            
            fileProcessed = tryReadFile(fileName); 
        }
        return fileName;
    }

    public static boolean tryReadFile(String fileName) {
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
            System.out.println("File found and opened successfully.");
            return true; 
        } catch (FileNotFoundException e) {
            System.err.println("Error! File '" + fileName + "' not found. Please try again.");
            return false;
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    System.err.println("Error closing the stream.");
                }
            }
        }
    }
}