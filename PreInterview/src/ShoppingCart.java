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
        
        // sums up the total price of the produce, then formats it to a value that makes sense
        total = appleCount*60+orangeCount*25;
        String totalFormat = String.format("%.2f", total/100);

        System.out.println("Total Price: £"+totalFormat);
    }
}
