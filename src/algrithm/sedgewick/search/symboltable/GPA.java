package algrithm.sedgewick.search.symboltable;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.search.application.ST;

public class GPA {
    public static void main(String[] args) {

        // create symbol table of grades and values
        ST<String, Double> grades = new ST<String, Double>();
        grades.put("A",  4.00);
        grades.put("B",  3.00);
        grades.put("C",  2.00);
        grades.put("D",  1.00);
        grades.put("F",  0.00);
        grades.put("A+", 4.33);
        grades.put("B+", 3.33);
        grades.put("C+", 2.33);
        grades.put("A-", 3.67);
        grades.put("B-", 2.67);


        // read grades from standard input and compute gpa
        int n = 0;
        double total = 0.0;
        for (n = 0; !StdIn.isEmpty(); n++) {
            String grade = StdIn.readString();
            double value = grades.get(grade);
            total += value;
        } 
        double gpa = total / n;
        StdOut.println("GPA = " + gpa);
    }
}