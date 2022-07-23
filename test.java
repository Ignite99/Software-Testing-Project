import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

public class test {

    @Test
    @DisplayName("Check Account Numbers tally across the board so no swapping occurs")
    public static void assertNoSwappingID() throws IOException {
        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));
        String row1 = c1.readLine();
        String row3 = c3.readLine();

        while (row1 != null || row3 != null) {
            String[] ind1 = row1.split(",");
            String[] ind3 = row3.split(",");
            Assertions.assertTrue(ind1[0].equals(ind3[0]), () -> "Assert Test Pass");
            row1 = c1.readLine();
            row3 = c3.readLine();
        }
    }

    @Test
    @DisplayName("Check Account Numbers tally across the board so no swapping occurs")
    public static void assertNoSwappingAccount() throws IOException {
        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));
        String row1 = c1.readLine();
        String row3 = c3.readLine();

        while (row1 != null || row3 != null) {
            String[] ind1 = row1.split(",");
            String[] ind3 = row3.split(",");
            Assertions.assertTrue(ind1[1].equals(ind3[1]), () -> "Assert Test Pass");
            row1 = c1.readLine();
            row3 = c3.readLine();
        }
    }

    @Test
    @DisplayName("Check Equal Column Headers")
    public static void assertHeaders() throws IOException {
        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));

        String row1 = c1.readLine();
        String row3 = c3.readLine();
        String[] ind1 = row1.split(",");
        String[] ind3 = row3.split(",");

        //Check each column header. If it passes, message "Assert Test Pass" will be output out
        Assertions.assertEquals(ind1[0], ind3[0], () -> "Assert Test Pass");
        Assertions.assertEquals(ind1[1], ind3[1], () -> "Assert Test Pass");
        Assertions.assertEquals(ind1[2], ind3[2], () -> "Assert Test Pass");
    }

    @Test
    @DisplayName("Check Equal Number of Rows")
    public static void assertNoRows() throws IOException {
        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));

        String row1 = c1.readLine();
        String row3 = c3.readLine();

        Integer counter1 = 0;
        Integer counter2 = 0;

        while (row1 != null) {
            row1 = c1.readLine();
            counter1 = counter1 + 1;
        }
        while (row3 != null) {
            row3 = c3.readLine();
            counter2 = counter2 + 1;
        }
        Assertions.assertEquals(counter1, counter2, () -> "Assert Test Pass");
    }

    @Test
    @DisplayName("Check Equal Number of Rows + 1 for one of them")
    public static void assertNoRowsPlusOne() throws IOException {
        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));

        String row1 = c1.readLine();
        String row3 = c3.readLine();

        Integer counter1 = 0;
        Integer counter2 = 0;

        while (row1 != null) {
            row1 = c1.readLine();
            counter1 = counter1 + 1;
        }
        while (row3 != null) {
            row3 = c3.readLine();
            counter2 = counter2 + 1;
        }

        //Check boundaries of +1 and -1
        Boolean checkPlusOne = counter1.equals(counter2+1);

        Assertions.assertFalse(checkPlusOne, () -> "Assert Test Pass");
    }

    @Test
    @DisplayName("Check Equal Number of Rows - 1 for one of them")
    public static void assertNoRowsMinusOne() throws IOException {
        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));

        String row1 = c1.readLine();
        String row3 = c3.readLine();

        Integer counter1 = 0;
        Integer counter2 = 0;

        while (row1 != null) {
            row1 = c1.readLine();
            counter1 = counter1 + 1;
        }
        while (row3 != null) {
            row3 = c3.readLine();
            counter2 = counter2 + 1;
        }


        //Check boundaries of +1 and -1
        Boolean checkMinusOne = counter1.equals(counter2-1);

        Assertions.assertFalse(checkMinusOne, () -> "Assert Test Pass");
    }

    @Test
    @DisplayName("Check output AccountID is same")
    public static void assertOutputAccount() throws IOException {
        ArrayList<String> data = new ArrayList<String>();

        String path = "./";
        String output1 = "output.csv";
        BufferedReader c1 = new BufferedReader(new FileReader(path + output1));
        String row1 = c1.readLine();

        while (row1 != null) {
            String[] ind1 = row1.split(",");
            data.add(ind1[1]);
            row1 = c1.readLine();
        }

        for (int i = 0; i < data.size()-1; i+=2) {
            String test1 = data.get(i);
            String test2 = data.get(i+1);

            Assertions.assertTrue(test1.equals(test2), () -> "Assert Test Pass");

        }
    }


    public static void main(String[] args) throws IOException {
        /*Testing to check boundary values and equivalence*/
//        test.assertHeaders();
//        test.assertNoRows();
//        test.assertNoRowsMinusOne();
//        test.assertNoRowsPlusOne();
//        test.assertNoSwappingAccount();
//        test.assertNoSwappingID();
//        test.assertOutputAccount();
        /*After this, main function will be executed.*/
    }
}
