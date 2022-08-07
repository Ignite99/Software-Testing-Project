import java.io.*;
import java.util.ArrayList;


public class generateCSV {
    private String input1;
    private String input2;

    void inp(String input1, String input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String> dataToWrite = new ArrayList<String>();
        generateCSV newInputs = new generateCSV();

        String path = "./";
        newInputs.inp("f1.csv", "f3.csv");

        String first = newInputs.input1;
        String second = newInputs.input2;

        BufferedReader c1 = new BufferedReader(new FileReader(path + first));
        BufferedReader c2 = new BufferedReader(new FileReader(path + second));

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