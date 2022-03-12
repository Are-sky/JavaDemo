package Demo06;

import javax.swing.*;
import java.time.*;


public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePinter();
        var timer = new Timer(1000,listener);
        timer.start();

        JOptionPane.showMessageDialog(null," Quit program ?");
        System.exit(0);
    }
}
