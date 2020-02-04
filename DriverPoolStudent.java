import java.util.Scanner;
/**
 * This program is used to unit test the Pool class.
 * The format of the dollar amount is not important.
 * You should not be concerned that there are no 
 * dollar signs or there are more than two decimal
 * places.
 * 
 * @Matthew Jacques 
 * @version Spring 2019
 */
public class DriverPoolStudent
{
    public static void main(String args[])
    {
        //1.  Create a Pool object.
        Pool p = new Pool();
        System.out.println(p.entriesAvailable());
        System.out.println(p.poolTotal());
        //2.  Test bounds of the range for pool days
        //2A. day - lower bound test
        System.out.println("day - lower bound test");
        System.out.println("Expect false: " + p.addEntry(-1, 10, "Tst", 14.0));
        System.out.println("Expect false: " + p.addEntry(0, 10, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(1, 10, "Tst", 14.0));
        //2B. day - mid-range test
        System.out.println("day - mid-range test");
        System.out.println("Expect True: " + p.addEntry(2, 10, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(4, 10, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(5, 10, "Tst", 14.0));
        //2C. day - upper bound test
        System.out.println("day - upper bound test");
        System.out.println("Expect True: " + p.addEntry(6, 10, "Tst", 14.0));
        System.out.println("Expect False: " + p.addEntry(8, 10, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(7, 10, "Tst", 14.0));
        //3.  Test the bounds of the range for pool hours
        //3A. hour - lower bound test
        System.out.println("hour - lower bound test");
        System.out.println("Expect False: " + p.addEntry(2, -1, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(3, 0, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(6, 1, "Tst", 14.0));
        //3B. hour - mid-range test
        System.out.println("hour - mid-range test");
        System.out.println("Expect True: " + p.addEntry(2, 12, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(3, 17, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(6, 13, "Tst", 14.0));

        //3C. hour - upper bound test
        System.out.println("hour - upper bound test");
        System.out.println("Expect True: " + p.addEntry(2, 22, "Tst", 14.0));
        System.out.println("Expect True: " + p.addEntry(3, 23, "Tst", 14.0));
        System.out.println("Expect False: " + p.addEntry(6, 24, "Tst", 14.0));

        //4A.  Test pool total; total is based on the pool entries above
        System.out.println("Test pool total");
        System.out.println("Expected output is 182. Actual output: " + p.poolTotal());
        //4B.  Test pool total with a new pool and no entries.
        Pool n = new Pool();
        System.out.println("Expected output is 0. Actual output: " + n.poolTotal());
        //5A.  Test getWinner - winner exists
        System.out.println("Expected output is Tst 14.0. Actual output: " + p.getWinner(6,1));
        //5B.  Test getWinner - no winner
        System.out.println("Expected output is null. Actual output: " + p.getWinner(5,1));
        //6.   print the complete matrix
        System.out.println("\n" + p);

        /*
         * 7. 
         * Use the Pool object, p, you created above.  If there are entries 
         * still available (there should be lots!), ask the user to pick a day 
         * and time.  Keep asking until they have picked one that is not 
         * already used (is null).  Then, add the user to the pool.  You 
         * will need their name and the amount they would like to enter.
         * You only need to enter one user in the pool.
         */
        Scanner scnr = new Scanner(System.in);
        boolean complete = false;
        int day;
        int hour;
        String name;
        double amt;
        while(complete == false){
            System.out.println("Enter a day:");
            day = scnr.nextInt();
            System.out.println("Enter an hour:");
            hour = scnr.nextInt();
            System.out.println("Enter your name:");
            name = scnr.next();
            System.out.println("Enter an amount:");
            amt = scnr.nextDouble();
            if(p.addEntry(day, hour, name, amt)==true){
                p.addEntry(day, hour, name, amt);
                System.out.println("\n" + p);
                complete = true;                 
            }
        }

    }
}
