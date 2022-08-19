import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class test {
    @Test
    @DisplayName("check swaps")
    public void swapping() throws Exception {
        generateCSV genC = new generateCSV();

        //2 columns swapped, but rows same
        String inp1 = "f1_swappedColumns.csv";
        String inp2 = "f3_swappedColumns.csv";
        String[] inputsColumn = { inp1, inp2 };
        genC.writeToFile(inputsColumn);

        //Columns same, but some rows swapped
        String inp3 = "f1_swappedRows.csv";
        String inp4 = "f3_swappedRows.csv";
        String[] inputsRow = { inp3, inp4 };
        genC.writeToFile(inputsRow);

        //different number of rows
        String inp5 = "f1_differentNumRows.csv";
        String inp6 = "f3_differentNumRows.csv";
        String[] inputsNumRows = { inp5, inp6 };
        genC.writeToFile(inputsNumRows);

    }
}
