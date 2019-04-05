import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Author Jason Abbatiello 4/5/2019
 * This Class demonstrates a simple checkout system for apples and oranges
 */
public class ShoppingCart {
    public static void main(String[] args){

        Scanner kbrd = new Scanner(System.in);
        String input;
        int appleCount = 0;
        int orangeCount = 0;
        double total;


        System.out.println("Apples - 60p\nOranges - 25p");
        System.out.println("Please enter a list of comma delimited Apples and Oranges [EX: Apple, Orange, Apple, Orange]:");
        input = kbrd.nextLine();

        // takes user string and splits it into a list of items
        List<String> produce = Arrays.asList(input.split("\\s*,\\s*"));

        // iterates through the list to get the number of apples and oranges
        for (String temp : produce) {
            if (temp.equalsIgnoreCase("Apple")){
                appleCount++;
            }
            else if (temp.equalsIgnoreCase("Orange")){
                orangeCount++;
            }
        }

        // outputs the number of apples and oranges
        System.out.println("Apples: "+appleCount+"\nOranges: "+orangeCount);

        total = checkout(appleCount, orangeCount);

        String totalFormat = String.format("%.2f", total/100);

        System.out.println("Total Price: £"+totalFormat);

    }

    /**
     * This class calculates the total of purchased apples and oranges, with Buy one Get one Apples,
     * and Buy 3 for the price of 2 Oranges
     * @param appleCount
     * @param orangeCount
     * @return total of purchase
     */
    public static double checkout(int appleCount, int orangeCount){

        double total;
        // for every two apples, charge for 1.
        if (appleCount % 2 == 0){
            appleCount = appleCount/2;
        }
        else if (appleCount % 2 == 1){
            appleCount = ((appleCount-1)/2)+1;
        }

        //for every 3 oranges, charge for 2
        //get remainder of oranges after sets of 3
        int remainder = orangeCount%3;
        //get the number or oranges in multiples of 3
        int orangeSplit = orangeCount-remainder;
        //charge for 2 oranges every 3, then add the remainder back
        int orangesCharged = ((orangeSplit/3)*2)+remainder;

        // sums up the total price of the produce, then formats it to a value that makes sense
        total = appleCount*60+orangesCharged*25;
        return total;
    }
}
