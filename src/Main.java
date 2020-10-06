/**
 * @author Muhammad Ibrahim
 * Coder-Tester
 * 6 October 2020
 **/

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        //store the file in a string and create a buffered reader to read it
        String classList = "src\\SD_ClassList.txt";
        Reader reader = new Reader(classList);

        Assigner assigner = new Assigner(reader.studentsAr); //assign partners from block 1
        System.out.println();
        assigner.printGroups(); //output
    }
}
