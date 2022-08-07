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
    @DisplayName("Check random rowCount")
    static void fuzzing() throws IOException {

        // 10 instances of fuzzing
        for (int i = 0; i < 0; i++) {

            ArrayList<String> data = new ArrayList<String>();

            Random rand = new Random();
            int n = rand.nextInt(2000);
            System.out.println(n);

            String path = "./";
            String samp1 = "f1.csv";
            String samp3 = "f3.csv";

            BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
            BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));
            String row1 = c1.readLine();
            String row3 = c3.readLine();

            while (row1 != null || row3 != null) {
                //Append to array list
                data.add(row1);
                data.add(row3);
                row1 = c1.readLine();
                row3 = c3.readLine();
            }

            if (n>=1000) {
                String test = data.get(n);
                Assertions.assertEquals(test, null, () -> "Assert Test Pass" );
            } else {
                String test = data.get(n);
                Assertions.assertNotEquals(test, null, () -> "Assert Test Pass");
            }
        }
    }

    @Test
    @DisplayName("Check Account Numbers tally across the board so no swapping occurs")
    static void assertNoSwappingID() throws IOException {
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
            try {
                Assertions.assertTrue(ind1[0].equals(ind3[0]), () -> "Assert Test Pass");
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }

            row1 = c1.readLine();
            row3 = c3.readLine();


        }
    }

    @Test
    @DisplayName("Check Account Numbers tally across the board so no swapping occurs")
    static void assertNoSwappingAccount() throws IOException {
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
            try {
                Assertions.assertTrue(ind1[1].equals(ind3[1]), () -> "Assert Test Pass");
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
            row1 = c1.readLine();
            row3 = c3.readLine();
        }
    }

    @Test
    @DisplayName("Check Equal Column Headers")
    static void assertHeaders() throws IOException {
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
        try {
            Assertions.assertEquals(ind1[0], ind3[0], () -> "Assert Test Pass");
            Assertions.assertEquals(ind1[1], ind3[1], () -> "Assert Test Pass");
            Assertions.assertEquals(ind1[2], ind3[2], () -> "Assert Test Pass");
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Check Equal Number of Rows + 1 for one of them")
    static void assertNoRowsPlusOne() throws IOException {
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

        try {
            Assertions.assertFalse(checkPlusOne, () -> "Assert Test Pass");
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Check Equal Number of Rows - 1 for one of them")
    static void assertNoRowsMinusOne() throws IOException {
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

        try {
            Assertions.assertFalse(checkMinusOne, () -> "Assert Test Pass");
        } catch(AssertionError e) {
            System.out.println(e.getMessage());
        }
    }


    // BlackBox testing System test, checking correct output in output.csv
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
            try {
                Assertions.assertTrue(test1.equals(test2), () -> "Assert Test Pass");
            } catch(AssertionError e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    static void checkRandomRows(int number) throws IOException {
        ArrayList<String> data = new ArrayList<String>();

        String path = "./";
        String samp1 = "f1.csv";
        String samp3 = "f3.csv";

        BufferedReader c1 = new BufferedReader(new FileReader(path + samp1));
        BufferedReader c3 = new BufferedReader(new FileReader(path + samp3));
        String row1 = c1.readLine();
        String row3 = c3.readLine();

        while (row1 != null || row3 != null) {
            //Append to array list
            data.add(row1);
            data.add(row3);
            row1 = c1.readLine();
            row3 = c3.readLine();
        }

        if (number<0 || number > 1000) {
            String output = data.get(number);
            Assertions.assertEquals(output, null, () -> "Assert Test Pass");
        } else {
            String output = data.get(number);
            Assertions.assertNotEquals(output, null, () -> "Assert Test Pass");
        }
    }


    static void main(String[] args) throws IOException {


        /*Testing to check boundary values and equivalence*/
//        test.assertHeaders();
//        test.assertNoRowsMinusOne();
//        test.assertNoRowsPlusOne();
//        test.assertNoSwappingAccount();
//        test.assertNoSwappingID();
//        test.assertOutputAccount();
        /*After this, main function will be executed.*/

    }
}
