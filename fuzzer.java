import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class fuzzer {
    public void fuzzExistingFile(String[] filenames) throws Exception {
        ArrayList<String> dataToWrite1 = new ArrayList<String>();
        ArrayList<String> dataToWrite2 = new ArrayList<String>();

        Random rand = new Random();

        int total_rows = rand.nextInt(1000);;
        int count = 0;

        //Changes random row to another value
        int row_to_change1 = rand.nextInt(total_rows);
        int row_to_change2 = rand.nextInt(total_rows);

        while (row_to_change1 == row_to_change2) {
            row_to_change2 = rand.nextInt(total_rows);
        }

        //+1 due to header being present
        int ID_change1 = row_to_change1+1;
        int ID_change2 = row_to_change2+1;


        String pathDir = "./";

        BufferedReader c1 = new BufferedReader(new FileReader(pathDir + "fuzzer_template.csv"));
        String row1 = c1.readLine();

        String header = "\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"";
        dataToWrite1.add(header);
        dataToWrite2.add(header);

        row1 = c1.readLine();

        while (count != total_rows) {
            String[] ind1 = row1.split(",");

            if (count == row_to_change1) {

                //Changes currency, balance except for Account number, type and ID
                String[] arr={"CAD", "EUR", "INR", "GBP", "AUD", "CHF", "HKD", "SEK", "SGD", "USD"};
                int randomNumber= rand.nextInt(arr.length);
                String currency = arr[randomNumber];

                int balance = rand.nextInt(2000000);
                String type = "CURRENT";

                ind1[2] = currency;
                ind1[3] = type;
                ind1[4] = Integer.toString(balance);

                String convertToString1 = String.join(",", ind1);
                dataToWrite1.add(convertToString1);


                List<String> list = new ArrayList<String>(Arrays.asList(arr));
                list.remove(currency);
                String[] str_array = list.toArray(new String[0]);
                int randomNumber_weird= rand.nextInt(arr.length);
                String currency_weird = str_array[randomNumber_weird];

                int balance_weird = rand.nextInt(10000000-2000000) + 2000000;

                String type_weird = "SAVINGS";

                ind1[2] = currency_weird;
                ind1[3] = type_weird;
                ind1[4] = Integer.toString(balance_weird);

                String convertToString2 = String.join(",", ind1);
                dataToWrite2.add(convertToString2);

            } else if (count == row_to_change2) {
                //Changes currency, balance except for Account number, type and ID
                String[] arr={"CAD", "EUR", "INR", "GBP", "AUD", "CHF", "HKD", "SEK", "SGD", "USD"};
                int randomNumber= rand.nextInt(arr.length);
                String currency = arr[randomNumber];

                int balance = rand.nextInt(2000000);
                String type = "SAVINGS";

                ind1[2] = currency;
                ind1[3] = type;
                ind1[4] = Integer.toString(balance);

                String convertToString1 = String.join(",", ind1);
                dataToWrite1.add(convertToString1);


                List<String> list = new ArrayList<String>(Arrays.asList(arr));
                list.remove(currency);
                String[] str_array = list.toArray(new String[0]);
                int randomNumber_weird= rand.nextInt(arr.length);
                String currency_weird = str_array[randomNumber_weird];

                int balance_weird = rand.nextInt(10000000-2000000) + 2000000;

                String type_weird = "CURRENT";

                ind1[2] = currency_weird;
                ind1[3] = type_weird;
                ind1[4] = Integer.toString(balance_weird);

                String convertToString2 = String.join(",", ind1);
                dataToWrite2.add(convertToString2);

            } else {
                String convertToString1 = String.join(",", ind1);
                dataToWrite1.add(convertToString1);
                dataToWrite2.add(convertToString1);
            }

            row1 = c1.readLine();
            count++;
        }

        // Writes into 2 fuzzed files
        FileWriter fw1 = new FileWriter("fuzzer_1.csv");
        FileWriter fw2 = new FileWriter("fuzzer_2.csv");
        Writer output1 = new BufferedWriter(fw1);
        Writer output2 = new BufferedWriter(fw2);

        int size1 = dataToWrite1.size();
        int size2 = dataToWrite2.size();
        for (int i = 0; i < size1; i++) {
            output1.write(dataToWrite1.get(i).toString() + "\n");
        }
        output1.close();
        for (int i = 0; i < size2; i++) {
            output2.write(dataToWrite2.get(i).toString() + "\n");
        }
        output2.close();

        //ID to match with the answer
        String str_ID1 = Integer.toString(ID_change1);
        String str_ID2 = Integer.toString(ID_change2);
        //Place input files into generateCSV()
        generateCSV genC = new generateCSV();
        String inp1 = "fuzzer_1.csv";
        String inp2 = "fuzzer_2.csv";
        String[] inputsColumn = { inp1, inp2 };
        genC.writeToFile(inputsColumn);

        ArrayList<String> dataToCheck = new ArrayList<String>();

        //Get answer file so that can compare which rows were extracted in generateCSV by comparing with the random number
        //generated at ID_change1 and ID_change2
        BufferedReader ans = new BufferedReader(new FileReader(pathDir + "output_fuzzer_1_fuzzer_2.csv"));
        String ans1 = ans.readLine();
        while (ans1 != null) {
            dataToCheck.add(ans1);
            ans1 = ans.readLine();
        }

        int size = dataToCheck.size();
        //Counts the number of similar
        int count_true = 0;
        for (int i = 0; i < size; i++) {
            if (dataToCheck.get(i).toString().contains(str_ID1) || dataToCheck.get(i).toString().contains(str_ID2)) {
                count_true++;
            }
        }

        //Since only changed 2 rows, should see 4 comparisons output from generateCSV
        Assertions.assertEquals(4, count_true, () -> "Assert Test Pass");
        System.out.println("Fuzzing Test Succeeded");
    }

    @Test
    public static void main(String[] args) throws IOException {
        try {
            fuzzer fuz = new fuzzer();
            String[] inputs = { "test" };
            fuz.fuzzExistingFile(inputs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
