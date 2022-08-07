<h1>Software-Testing-Mini-Campaign-Individual</h1>

<h3>Name: Goh Nicholas</h3>
<h3>Student ID: 1005194</h3></br>

<b><h2>Overview</h2></b>
Consider a CSV file that stores a list of records (e.g., records of bank accounts). You are required to write a software
program that reads two such CSV files, compares records stored in these CSV files row by row against a unique combination and <b>records all</b> mismatches as exceptions. Finally, the software program <b>generates another csv file</b> listing the exceptions.</br></br></br>

<b><h2>How does my function work?</h2></b>
In case all sample files are being taken into account instead of just 2. I had pathed to all 3 files in the current directory to compare and contrast their values. 
- They first check if the ID tallies across each of the rows in each of the 3 CSV files
- They then check if the account number tallies across all the CSV files.
- Once tallied, they then check if their account type, currency type and available balance are equal. If they are not, they are sent into and ArrayList.
- Once in the ArrayList, it is then written out into output.csv where all the flagged out records are.</br></br></br> 

<b><h2>How to run it?</h2></b>
One can run it by using the terminal at the directory where the java class is located at by typing:
```
java generateCSV.java
```
Or if one uses IntelliJ or Visual Studio Code(VSC) they can click on the run main function in the java class itself or the run button respectively.</br></br></br>

<b><h2>Blackbox Testing</h2></b>
<b><h3>Equivalence Class partitioning</h3></b>
In equivalence class partitioning, input data units are divided into equivalent partitions that can be used to derive test
cases which reduces time required for testing because of the small number of test cases.

In class generateCSV's scenario:
- The <b>invalid partition</b> would be whether the no. of rows for each CSV are not equal to each other CSV. 
For e.g if rows in samp1 from the first sample file is not equal to the others, it is invalid. Moreover, if the columns for 
currency/type/balance/ID and account number are not arranged in a similar order, then it would be invalid as well.
- The <b>valid partition</b> would be whether the no. of rows for each CSV are equal to each other, with the order of columns
being similar to each of the other sample files as well.

<b><h3>Boundary Value Analysis</h3></b>
Boundary-value analysis is a software testing technique in which tests are designed to include representatives of boundary values in a range. 
The idea comes from the boundary. In this scenario, with sample files 1-3 as reference, any ID number between 0-1000 will return
a list of data alongside the ID number, while anything <0 and >1000 will return nothing. Boundary value analysis would
thus be ```-1,0,1``` and ```999,1000,1001```.</b></b>

However, if we are not able to manually see the number of rows of the csv file then the range would be from 0 to data.length(). 
With boundary value analysis being ```-1,0,1``` for the lower bound and ```data.length()-1, data.length()
, data.length()+1``` for the upper bound.</br></br></br>

<b><h3>Unit/System/Fuzzing Tests</h3></b>
`test.java` is the java file with all the unit tests. After running the file, should there be any errors, System.out.println() will print the error message in console.</br>

The unit tests are:</br>
  - `assertNoSwappingID`: These check account IDs are tallied correctly across each row across both csvs
  - `assertNoSwappingAccount`: These check account numbers are tallied correctly across each row across both csvs
  - `assertHeaders`: Check if headers of each column are correct, checks for any difference due to swapping columns
  - `checkRandomRows`: Check if total number of rows are equal in the csv files being used
  - `assertNoRowsPlusOne`: Checks if a +1 in row counter will result in false equals to Assertion
  - `assertNoRowsMinusOne`: Checks if a -1 in row counter will result in false equals to Assertion
  - `assertOutputAccount`: Checks if output of the entire file each comparison made had equal account numbers as well as IDs to check if the comparertor is correct.
  - `fuzzing`: Checks if the random input row exists or not. Inputs will range from 0-2000, checking if an invalid input of lets say 1900 will get something out of the data exists.





