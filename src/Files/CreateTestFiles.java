package Files;

import java.io.*;

public class CreateTestFiles {

	public static void main(String[] args) {
		createCSFile();
		createHedvaFile();
		System.out.println("Test files created successfully.");
	}

	public static void createCSFile() {
		try (PrintWriter out = new PrintWriter("CS.txt")) {
			out.println("Moshe Cohen 1234");
			out.println("Dina Levi 1345");
			out.println("Yosi Svisa 2313");
		} catch (IOException e) {
			System.err.println("Error creating CS.txt: " + e.getMessage());
		}
	}

	public static void createHedvaFile() {
		try (PrintWriter out = new PrintWriter("hedva.txt")) {
			out.println("1234 85 75");
			out.println("1255 56 100");
			out.println("1345 90 86");
			out.println("2313 70 80");
		} catch (IOException e) {
			System.err.println("Error creating hedva.txt: " + e.getMessage());
		}
	}
}
