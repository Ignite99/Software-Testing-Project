<h1>Software-Testing-Mini-Campaign-Individual</h1>

<h3>Name: Goh Nicholas</h3>
<h3>Student ID: 1005194</h3></br>

<b><h2>Overview</h2></b>
Consider a CSV file that stores a list of records (e.g., records of bank accounts). You are required to write a software program that reads two such CSV files, compares records stored in these CSV files row by row against a unique combination and <b>records all</b> mismatches as exceptions. Finally, the software program <b>generates another csv file</b> listing the exceptions.</br></br></br>

<b><h2>How does my function work?</h2></b>
In case all sample files are being taken into account instead of just 2. I had pathed to all 3 files in the current directory to compare and contrast their values. 
- They first check if the ID tallies accross each of the rows in each of the 3 CSV files
- They then check if the account number tallies accross all the CSV files.
- Once tallied, they then check if their account type, currency type and available balance are equal. If they are not, they are sent into and ArrayList.
- Once in the ArrayList, it is then written out into output.csv where all the flagged out records are.</br></br></br> 

<b><h2>How to run it?</h2></b>
One can run it by using the terminal at the directory where the java class is located at by typing:
```
java generateCSV.java
```
Or if one uses IntelliJ or Visual Studio Code(VSC) they can click on the run main function in the java class itself or the run button respectively/

