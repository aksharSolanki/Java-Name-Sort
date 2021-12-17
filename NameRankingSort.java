import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NameRankingSort {

    public static void main(String[] args) {

        int rank;
        String maleName;
        String femaleName;
        int year;
        int order = 1;
        int limit = 1000;

        //Three Linked lists created to store ranks, male & female names for each year.
        List<String> nameList2017 = new LinkedList<String>();
        List<String> nameList2018 = new LinkedList<String>();
        List<String> nameList2019 = new LinkedList<String>();

        //File object for unsorted names text file
        File unsortedNames = new File("src/Names.txt");

        //File objects for female ranked names text file
        File female2017 = new File("src/FemaleNameRankingSort2017.txt");
        File female2018 = new File("src/FemaleNameRankingSort2018.txt");
        File female2019 = new File("src/FemaleNameRankingSort2019.txt");

        //File objects for male ranked names text file
        File male2017 = new File("src/MaleNameRankingSort2017.txt");
        File male2018 = new File("src/MaleNameRankingSort2018.txt");
        File male2019 = new File("src/MaleNameRankingSort2019.txt");

        //Reading from unsortedNames file object and writing to required objects
        try (Scanner readName = new Scanner(unsortedNames);
                //Female PrintWriter objects for each year
                PrintWriter printFemale2017 = new PrintWriter(female2017);
                PrintWriter printFemale2018 = new PrintWriter(female2018);
                PrintWriter printFemale2019 = new PrintWriter(female2019);
                //Male PrintWriter objects for each year 
                PrintWriter printMale2017 = new PrintWriter(male2017);
                PrintWriter printMale2018 = new PrintWriter(male2018);
                PrintWriter printMale2019 = new PrintWriter(male2019);) {

            while (readName.hasNextLine()) {
                String line = readName.nextLine();
                Scanner token = new Scanner(line);
                rank = token.nextInt();
                maleName = token.next();
                femaleName = token.next();
                year = token.nextInt();

                if (year == 2017) {
                    nameList2017.add(rank + " " + maleName + " " + femaleName);
                } else if (year == 2018) {
                    nameList2018.add(rank + " " + maleName + " " + femaleName);
                } else if (year == 2019) {
                    nameList2019.add(rank + " " + maleName + " " + femaleName);
                }
            }
            for (int i = 0; i < limit; i++) {

                //YEAR : 2017
                for (String name : nameList2017) {
                    /**
                     * By splitting the list using " " as the delimiter, the
                     * first element of nameArray -> nameArray[0] = rank, second
                     * element of nameArray -> nameArray[1] = male name, the
                     * third element of nameArray -> nameArray[2] = female name
                     */
                    String[] nameArray = name.split(" ");

                    if (order == Integer.parseInt(nameArray[0])) {
                        //Writing to female file objects for the year 2017
                        printFemale2017.println("Rank : " + nameArray[0] + "\tName : " + nameArray[2]);

                        //Writing to male file objects for the year 2017
                        printMale2017.println("Rank : " + nameArray[0] + "\tName : " + nameArray[1]);
                    }
                }

                //YEAR : 2018
                for (String name : nameList2018) {
                    String[] nameArray = name.split(" ");

                    if (order == Integer.parseInt(nameArray[0])) {
                        //Writing to female file objects for the year 2018
                        printFemale2018.println("Rank : " + nameArray[0] + "\tName : " + nameArray[2]);

                        //Writing to male file objects for the year 2018
                        printMale2018.println("Rank : " + nameArray[0] + "\tName : " + nameArray[1]);
                    }
                }

                //YEAR : 2019
                for (String name : nameList2019) {
                    String[] nameArray = name.split(" ");

                    if (order == Integer.parseInt(nameArray[0])) {
                        //Writing to female file objects for the year 2019
                        printFemale2019.println("Rank : " + nameArray[0] + "\tName : " + nameArray[2]);

                        //Writing to male file objects for the year 2019
                        printMale2019.println("Rank : " + nameArray[0] + "\tName : " + nameArray[1]);
                    }
                }
                order++;
            }
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }

    }

}
