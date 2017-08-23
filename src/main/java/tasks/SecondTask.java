package tasks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SecondTask {
    public static void main(String[] args) {
        String pathToFile = "src\\main\\resources\\example.csv";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            print(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* In this method we read a text from our .csv file line by line,
     * using " " as line splitter and ";" as a value splitter and write it to a list of string arrays
     */
    private static List<String[]> read(BufferedReader bufferedReader) throws IOException {
        List<String[]> list = new ArrayList<>();
        String lineSplitter = " ";
        String splitter = ";";
        while ((lineSplitter = bufferedReader.readLine()) != null) {
            list.add(lineSplitter.split(splitter, -1));
        }
        return list;
    }

    private static List<Integer> getMaxColumnValues(List<String[]> list) {
        Integer max = 0;
        List<Integer> maxOfColumns = new ArrayList<>();
        /* We go through the columns and find maximal element for each index.
         * And then write them into list of integers.
         */
        for(int i = 0; i < list.get(0).length;i++)
        {
            max = 0;
            for(String[] row : list) {
                if(row[i] != null) {
                    if(row[i].length() > max)
                        max = row[i].length();
                }

            }
            maxOfColumns.add(max);
        }
        return maxOfColumns;
    }

    private static void print(BufferedReader bufferedReader) throws IOException {
        List<String[]> list = read(bufferedReader);
        List<Integer> maxOfColumns =  getMaxColumnValues(list);
        Integer listLength = list.get(0).length;
        Integer length = getLengthOfTable(maxOfColumns, listLength);
        /* Print a line to begin the table */
        printLine(length);
        for (int i = 0; i < list.size(); i++) {
            if (i == 1)
                /* Print a line that divides the first row */
                printLine(length);
            for(int j = 0; j < listLength; j++) {
                /* At first, we print "|" char to divide column, then we print value */
                System.out.print("|");
                System.out.print(list.get(i)[j]);
                /* Here, we need to know how much spaces we need to write for the column to be equal in each row.
                 * So, we subtract length of the current value from the max length value of this column, and get a number of times,
                 * that we need to write " " space after our value.
                 */
                for(int k = 0; k < (maxOfColumns.get(j) - list.get(i)[j].length()); k++) {
                    System.out.print(" ");
                }
            }
            /* Print "|" in the end of a row, and go to the next line */
            System.out.print("|");
            System.out.println("");
        }
        /* Print a line to finish the table */
        printLine(length);
    }


    private static void printLine(Integer length) {
        for(int i = 0; i < length; i++)
            System.out.print("-");
        System.out.println("");
    }

    /* To get length of the table we need to add length of all columns(maxOfColumns array)
     * and also spaces in which char "|" has been printed( length of the list + 1).
     */
    private static Integer getLengthOfTable(List<Integer> maxOfColumns, Integer listLength) {
        Integer length = 0;
        for(Integer element : maxOfColumns)
            length += element;
        return length + listLength + 1;

    }
}
