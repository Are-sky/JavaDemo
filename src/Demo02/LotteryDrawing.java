package Demo02;


import java.util.Arrays;
import java.util.Scanner;

public class LotteryDrawing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.print("What was the highest numbers you can draw?");
        int n = in.nextInt();

        //fill ana array with numbers 1 2 3 ... n
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i+1;
        }

        //draw k numbers and put them into a second array
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            //make a random index between 0 and n-1;
            int r = (int)(Math.random()*n);

            //pick the element into the location
            result[i] = numbers[r];

            //move the last element into random location
            numbers[r] = numbers[n-1];
            n--;
        }

        Arrays.sort(result);
        System.out.println("Bet the following combination. It'll make you rich.");
        for(int r : result){
            System.out.println(r);
        }

    }
}
