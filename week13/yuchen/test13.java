package week13.yuchen;

public class test13 {
    public void test1() throws Exception {
        try {
            String[] filenames = {"./test1_with_IDcolumnMissing.csv", "./test1_without_IDcolumnMissing.csv", "out/test1_output.csv"};
            CompareFile compareFile = new CompareFile();
            compareFile.compareAnswer(filenames);
        } catch (Exception e) {
            System.out.println(e);
            ;
        }
    }
    public void test2() throws Exception {
        try {
            String[] filenames = {"./test2_with_IDcolumnSwapped.csv", "./test2_without_IDcolumnSwapped.csv", "out/test2_output.csv"};
            CompareFile compareFile = new CompareFile();
            compareFile.compareAnswer(filenames);
        } catch (Exception e) {
            System.out.println(e);
            ;
        }
    }
    public void test3() throws Exception {
        try {
            String[] filenames = {"./test3_duplicatedrow9.csv", "./test3_duplicatedrow10.csv", "out/test3_output.csv"};
            CompareFile compareFile = new CompareFile();
            compareFile.compareAnswer(filenames);
        } catch (Exception e) {
            System.out.println(e);
            ;
        }
    }
    public static void main(String[] args) throws Exception {

        test13 test = new test13();
        test.test1();
        test.test2();
        test.test3();

    }
}
