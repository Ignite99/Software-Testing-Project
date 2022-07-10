import java.io.*;
import java.util.ArrayList;

public class generateCSV {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList dataToWrite = new ArrayList<>();

        String path="./";
        String samp1="sample_file_1.csv";
        String samp2="sample_file_2.csv";
        String samp3="sample_file_3.csv";

        BufferedReader c1 = new BufferedReader(new FileReader(path+samp1));
        BufferedReader c2 = new BufferedReader(new FileReader(path+samp2));
        BufferedReader c3 = new BufferedReader(new FileReader(path+samp3));

        //enter while loop with the column header being first to parse iin
        String row1 = c1.readLine();
        String row2 = c2.readLine();
        String row3 = c3.readLine();

        //Debugging purposes
        Integer counter = 0;

        while(row1 != null) {
            //split rows by comma, making checking of each column value per ID easier
            String[] ind1 = row1.split(",");
            String[] ind2 = row2.split(",");
            String[] ind3 = row3.split(",");


            if (row1 != row2 || row1 != row3 || row2 != row3) {
                // checks if account no. is the same

                if(ind1[1].equals(ind2[1])) {
                    // checks if currency, type and balance are the same, if not write to output
                    if (!ind1[2].equals(ind2[2]) || !ind1[3].equals(ind2[3]) || !ind1[4].equals(ind2[4])) {
                        String convertToString1 = String.join(",", ind1);
                        String convertToString2 = String.join(",", ind2);

                        dataToWrite.add(convertToString1);
                        dataToWrite.add(convertToString2);
                    }
                } else if(ind1[1].equals(ind3[1])) {
                    if (!ind1[2].equals(ind3[2]) || !ind1[3].equals(ind3[3]) || !ind1[4].equals(ind3[4])) {
                        String convertToString1 = String.join(",", ind1);
                        String convertToString3 = String.join(",", ind3);

                        dataToWrite.add(convertToString1);
                        dataToWrite.add(convertToString3);
                    }
                } else if(ind2[1].equals(ind3[1])) {
                    if (!ind2[2].equals(ind3[2]) || !ind2[3].equals(ind3[3]) || !ind2[4].equals(ind3[4])) {
                        String convertToString2 = String.join(",", ind2);
                        String convertToString3 = String.join(",", ind3);

                        dataToWrite.add(convertToString2);
                        dataToWrite.add(convertToString3);
                    }
                }
            }

            //counter for debugging purposes
            counter = counter+1;
            //reads next line for all csvs
            row1 = c1.readLine();
            row2 = c2.readLine();
            row3 = c3.readLine();

        }

        //Output to test.csv
        FileWriter fw = new FileWriter("output.csv");
        Writer output = new BufferedWriter(fw);

        //Measures size of array so that it can iterate through all rows and values
        int size = dataToWrite.size();
        for (int i = 0; i < size; i++) {
            output.write(dataToWrite.get(i).toString() + "\n");
        }
        output.close();

    }
}