package Files;

import java.io.*;
import java.util.Scanner;

public class File {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String fileName1 = getValidFileName(scanner);
		String fileName2 = getValidFileName(scanner);

		System.out.println("\nBoth files were found successfully.");
		System.out.println("File 1: " + fileName1);
		System.out.println("File 2: " + fileName2);

		readNameFiles(fileName1, fileName2);

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

		try (FileReader fr = new FileReader(fileName)) {

			System.out.println("File found and opened successfully.");
			return true;

		} catch (FileNotFoundException e) {

			System.err.println("Error! File '" + fileName + "' not found. Please try again.");
			return false;

		} catch (IOException e) {
			System.err.println("An I/O error occurred: " + e.getMessage());
			return false;
		}
	}

	public static void readNameFiles(String fileName1, String fileName2) {
		try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
				BufferedReader reader2 = new BufferedReader(new FileReader(fileName2));
				PrintWriter out = new PrintWriter("report.txt")) {

			String line1 = reader1.readLine();
			String line2 = reader2.readLine();
			
			System.out.println("Report generated successfully: report.txt");
			System.out.println("\nReport content:");
			

			while (line1 != null && line2 != null) {
				String[] p1 = line1.split(" ");
				String[] p2 = line2.split(" ");

				int id1 = Integer.parseInt(p1[2]);
				int id2 = Integer.parseInt(p2[0]);

				
				if (id1 < id2) {
					line1 = reader1.readLine();
				} else if (id1 > id2) {
					line2 = reader2.readLine();
				} else {
					int avg = (Integer.parseInt(p2[1]) + Integer.parseInt(p2[2])) / 2;
					out.println(id1 + " " + p1[0] + " " + p1[1] + " " + avg);
					System.out.println(id1 + " " + p1[0] + " " + p1[1] + " " + avg);

					line1 = reader1.readLine();
					line2 = reader2.readLine();
				}
			}


		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
}


