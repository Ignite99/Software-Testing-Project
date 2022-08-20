import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class test {
    @ParameterizedTest
    @DisplayName("check swaps")
    public void swapping() throws Exception {
        generateCSV genC = new generateCSV();
        String pathDir = "./";

        //2 columns swapped, but rows same
        int right_answer1 = 0;
        String inp1 = "f1_swappedColumns.csv";
        String inp2 = "f3_swappedColumns.csv";
        String[] inputsColumn = { inp1, inp2 };
        genC.writeToFile(inputsColumn);

        BufferedReader ans = new BufferedReader(new FileReader(pathDir + "output_f1_swappedColumns_f3_swappedColumns.csv"));
        String ans1 = ans.readLine();
        while (ans1 != null) {
            String[] ind1 = ans1.split(",");
            if (ind1[0].contains("99") || ind1[0].contains("199") || ind1[0].contains("298")) {
                right_answer1++;
            }
            ans1 = ans.readLine();
        }
        Assertions.assertEquals(4, right_answer1);


        //Columns same, but some rows swapped
        String inp3 = "f1_swappedRows.csv";
        String inp4 = "f3_swappedRows.csv";
        String[] inputsRow = { inp3, inp4 };
        genC.writeToFile(inputsRow);

        BufferedReader cans = new BufferedReader(new FileReader(pathDir + "output_f1_swappedRows_f3_swappedRows.csv"));
        String cans1 = cans.readLine();
        while (cans1 != null) {
            String[] ind1 = cans1.split(",");
            if (ind1[0].contains("99") || ind1[0].contains("199") || ind1[0].contains("298")) {
                right_answer1++;
            }
            cans1 = cans.readLine();
        }
        Assertions.assertEquals(8, right_answer1);



        //different number of rows
        String inp5 = "f1_differentNumRows.csv";
        String inp6 = "f3_differentNumRows.csv";
        String[] inputsNumRows = { inp5, inp6 };
        genC.writeToFile(inputsNumRows);

        BufferedReader xans = new BufferedReader(new FileReader(pathDir + "output_f1_swappedColumns_f3_swappedColumns.csv"));
        String xans1 = xans.readLine();
        while (xans1 != null) {
            String[] ind1 = xans1.split(",");
            if (ind1[0].contains("99") || ind1[0].contains("199") || ind1[0].contains("298")) {
                right_answer1++;
            }
            xans1 = xans.readLine();
        }
        Assertions.assertEquals(12, right_answer1);

    }
}
