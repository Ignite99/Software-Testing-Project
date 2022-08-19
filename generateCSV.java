import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class generateCSV {
    public void writeToFile(String[] filenames) throws Exception {
        ArrayList<String> dataToWrite = new ArrayList<String>();

        File file1 = new File(filenames[0]);
        File file2 = new File(filenames[1]);

        String pathDir = "./";

        BufferedReader c1 = new BufferedReader(new FileReader(pathDir + file1));
        BufferedReader c2 = new BufferedReader(new FileReader(pathDir + file2));

        //enter while loop with the column header being first to parse iin
        String row1 = c1.readLine();
        String row2 = c2.readLine();

        //Debugging purposes
        Integer counter = 0;

        while (row1 != null) {
            //split rows by comma, making checking of each column value per ID easier
            String[] ind1 = row1.split(",");
            String[] ind2 = row2.split(",");

            if (row1 != row2) {
                // checks if account no. is the same

                if (ind1[1].equals(ind2[1])) {
                    // checks if currency, type and balance are the same, if not write to output
                    if (!ind1[2].equals(ind2[2]) || !ind1[3].equals(ind2[3]) || !ind1[4].equals(ind2[4])) {
                        String convertToString1 = String.join(",", ind1);
                        String convertToString2 = String.join(",", ind2);

                        dataToWrite.add(convertToString1);
                        dataToWrite.add(convertToString2);
                    }
                }
            }

            //counter for debugging purposes
            counter = counter + 1;
            //reads next line for all csvs
            row1 = c1.readLine();
            row2 = c2.readLine();

        }

        String filename1 = filenames[0].substring(0, filenames[0].lastIndexOf("."));;
        String filename2 = filenames[1].substring(0, filenames[1].lastIndexOf("."));;;

        //Output to test.csv
        FileWriter fw = new FileWriter("output_"+filename1+"_"+filename2+".csv");
        Writer output = new BufferedWriter(fw);

        //Measures size of array so that it can iterate through all rows and values
        int size = dataToWrite.size();
        for (int i = 0; i < size; i++) {
            output.write(dataToWrite.get(i).toString() + "\n");
        }
        output.close();

    }

    public static void main(String[] args) throws IOException {
        try {
            Scanner inp = new Scanner(System.in);

            boolean exists = false;
            String inp1 = "";
            String inp2 = "";

            while (!exists) {
                System.out.println("Enter first file(will keep looping till a valid file is presented): ");
                String firstFile = inp.nextLine();
                inp1 = firstFile;
                exists = Files.exists(Path.of(firstFile));
            }
            System.out.println("file 1 exists");
            exists = false;

            while (!exists) {
                System.out.println("Enter second file(will keep looping till a valid file is presented): ");
                String secondFile = inp.nextLine();
                inp2 = secondFile;
                exists = Files.exists(Path.of(secondFile));
            }
            System.out.println("file 2 exists");

            String[] inputs = { inp1, inp2 };
            generateCSV genC = new generateCSV();
            genC.writeToFile(inputs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}