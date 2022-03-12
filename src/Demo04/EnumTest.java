package Demo04;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
//        var in = new Scanner(System.in);
//        System.out.println("Enter a size:(SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
//        String input = in.next().toUpperCase();
//        Size size = Enum.valueOf(Size.class,input);
//        System.out.println("Size = " + size);
//        System.out.println("abbreviation = " + size.getAbbreviation());
          Employee e = new Employee("kk",1,1,1,1);
          Class cl = e.getClass();
          System.out.println(e.getClass().getName() + " " + e.getName());
          System.out.println(int.class);
        System.out.println(2.8%1==0);
    }
}

