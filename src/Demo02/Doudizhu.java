package Demo02;


import java.util.ArrayList;
import java.util.Collections;

public class Doudizhu {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>();
        ArrayList<String> box = new ArrayList<>();
        ArrayList<String> nums = new ArrayList<>();

        colors.add("♠");
        colors.add("❤");
        colors.add("♣");
        colors.add("♦");

        for (int i = 2; i < 11; i++) {
            nums.add(i + " ");
        }
        nums.add("J");
        nums.add("Q");
        nums.add("K");
        nums.add("A");

        for (String color : colors){
            for (String num : nums){
                box.add(color + num);
            }
        }
        box.add("大王");
        box.add("小王");

        Collections.shuffle(box);

        ArrayList<String> PlayerA = new ArrayList<>();
        ArrayList<String> PlayerB = new ArrayList<>();
        ArrayList<String> PlayerC = new ArrayList<>();
        ArrayList<String> Dipai = new ArrayList<>();

        for (int i = 0; i < box.size(); i++) {
            String card = box.get(i);
            if(i >= 51){
                Dipai.add(card);
            }else if (i%3 == 0){
                PlayerA.add(card);
            }else if (i%3 == 1){
                PlayerB.add(card);
            }else {
                PlayerC.add(card);
            }
        }

        System.out.println("PlayerA " + PlayerA);
        System.out.println("PlayerB " + PlayerB);
        System.out.println("PlayerC " + PlayerC);
        System.out.println("Dipai " + Dipai);

    }
}
