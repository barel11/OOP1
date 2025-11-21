package Files;

import java.io.*;

public class File {
	public static void main(String[] args) {

		try (BufferedReader fileCS = new BufferedReader(new FileReader("CS.txt"));
				BufferedReader fileHedva = new BufferedReader(new FileReader("hedva.txt"));
				PrintWriter output = new PrintWriter(new FileWriter("report.txt"))) {

			String cs = fileCS.readLine();
			String hedva = fileHedva.readLine();

			System.out.println("File created:");
			while (cs != null && hedva != null) {

				String[] infoCS = cs.split(" ");
				String[] infoHedva = hedva.split(" ");

				int id1 = Integer.parseInt(infoCS[infoCS.length - 1]);
				int id2 = Integer.parseInt(infoHedva[0]);

				
				if (id1 == id2) {
					int grade1 = Integer.parseInt(infoHedva[1]);
					int grade2 = Integer.parseInt(infoHedva[2]);
					double avg = (grade1 + grade2) / 2;
					output.println(id1 + " " + infoCS[0] + " " + infoCS[1] + " " + avg);
					System.out.println(id1 + " " + infoCS[0] + " " + infoCS[1] + " " + avg);


					cs = fileCS.readLine();
					hedva = fileHedva.readLine();

				} else if (id1 < id2) {
					cs = fileCS.readLine();

				} else {
					hedva = fileHedva.readLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}