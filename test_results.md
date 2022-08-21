#Week 13 Report

###Bugs discovered
Name: Guo Yuchen 1004885
Note: All relevant files are stored in the week 13 folder

1) <b>Without ID column, cannot generate output</b>
   The comparisons of both file base use the ID column as the root to see if the row is being compared to the right row. As a result, without it, no output was generated.</br>
   The csv file `test1_with_IDcolumnMissing` was compared with file `test1_without_IDcolumnMissing`. Both of these files are based of the `f1.csv` and `f3.csv` files with ID99,199 and 298 being the points to be output out. However, as with the case of `test1_output.csv`. Nothing is output out.</br></br>
2) <b>With ID column swapped, cannot generate output</b>
   This issue is similar to the previous one where without the ID columnm no output was generated. For this issue, should the ID column be swapped out from the first column to any other column, no output will be generated as well.</br>
   The csv file `test1_with_IDcolumnSwapped` was compared with file `test1_without_IDcolumnSwapped`. Both of these files are based of the `f1.csv` and `f3.csv` files with ID99,199 and 298 being the points to be output out. However, as with the case of `test2_output.csv`. Nothing is output out.</br></br>
3) <b>Cannot detect duplicated row</b>
   To ensure that rows remain similar, `test3_duplicatedrow9` has duplicated row 9 only once while `test3_duplicatedrow10` has duplicated row 10 only once.</br>
   Both of these files are based of the `f1.csv` and `f3.csv` files with ID99,199 and 298 being the points to be output out. However, ID9 and ID10 were not output out. As can be seen in `test3_output.csv`, ID99,199 and 298 were written here, but not the ID9 and ID10</br></br>