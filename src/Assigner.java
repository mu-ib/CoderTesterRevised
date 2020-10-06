import java.util.ArrayList;

/**This class will assign partners from arraylists
 * and prints the output**/
public class Assigner {
    ArrayList<Integer> coderTaken = new ArrayList<Integer>(), testerTaken = new ArrayList<Integer>(); //arrays that will hold the people that have been assigned groups
    //array holding all the students and coders and testers
    ArrayList<String> codersAr = new ArrayList<String>(), testersAr = new ArrayList<String>(), studentsAr = new ArrayList<String>();

    public Assigner(ArrayList<String> ar) {
        studentsAr = ar;
        String randomStudent;
        //GENERATE CODERS AND TESTERS
        for (int i = 0; i < ar.size(); i++) {
            //Generate a random coder
            int c = giveStudentNotTaken(coderTaken);
            if (c != -1) {
                randomStudent = ar.get(c);
                coderTaken.add(c); //add the random number to the taken array
                //assign the random student to their spot in the array
                codersAr.add(randomStudent);
            }
            //Generate a random tester
            int t = giveStudentNotTaken(testerTaken);
            if (t != -1) {
                randomStudent = ar.get(t);
                testerTaken.add(t); //add the random number to the taken array
                //assign the random student to their spot in the array
                testersAr.add(randomStudent);
            }
        }

    }
    //method to print the output
    public void printGroups() {
        //convert the arraylists to arrays
        String[] codersArray = new String[codersAr.size()], testersArray = new String[testersAr.size()];
        for(int i = 0; i < codersArray.length; i++)
            codersArray[i] = codersAr.get(i);
        for(int i = 0; i < testersArray.length; i++)
            testersArray[i] = testersAr.get(i);
        for (int i = 0; i < studentsAr.size(); i++) {
            for (int j = i + 1; j < studentsAr.size(); j++) {
                if (codersArray[i].compareTo(codersArray[j]) > 0) {
                    String temp = codersArray[i];
                    String temp2 = testersArray[i];
                    codersArray[i] = codersArray[j];
                    testersArray[i] = testersArray[j];
                    codersArray[j] = temp;
                    testersArray[j] = temp2;
                }
            }
        }
        //print the output for coder first
        System.out.format("%-25s %-25s", "Coder", "Tester");
        System.out.println();
        System.out.format("%-25s %-25s", "Last Name", "Last Name");
        System.out.println("\n----------------------------------------");
        for (int i = 0; i < codersAr.size(); i++) {
            System.out.format("%-25s %-25s", codersArray[i], testersArray[i]);
            System.out.println();
        }
        System.out.println("\n");

        for (int i = 0; i < studentsAr.size(); i++) {
            for (int j = i + 1; j < studentsAr.size(); j++) {
                if (testersArray[i].compareTo(testersArray[j]) > 0) {
                    String temp = testersArray[i];
                    String temp2 = codersArray[i];
                    testersArray[i] = testersArray[j];
                    codersArray[i] = codersArray[j];
                    testersArray[j] = temp;
                    codersArray[j] = temp2;
                }
            }
        }
        //print the output for tester first
        System.out.format("%-25s %-25s", "Tester", "Coder");
        System.out.println();
        System.out.format("%-25s %-25s", "Last Name", "Last Name");
        System.out.println("\n----------------------------------------");
        for (int i = 0; i < codersAr.size(); i++) {
            System.out.format("%-25s %-25s", testersArray[i], codersArray[i]);
            System.out.println();
        }
    }
    //method to test if a person is already assigned a partner
    public boolean isTaken(int value, ArrayList<Integer> taken) {
        //go through the list that is taken and if there is a match then return true
        for (int element : taken) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }

    //method to give a student that has not already been taken
    public int giveStudentNotTaken(ArrayList<Integer> taken) {
        boolean found = false;
        int r = -1;
        //create random numbers until one that has not been used is found
        do {
            r = (int) Math.floor((Math.random() * studentsAr.size()));
            found = !(isTaken(r, taken));
        } while (!found);

        return r;
    }
}
