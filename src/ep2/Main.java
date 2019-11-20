package ep2;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws FontFormatException {
        Menu frame = new Menu();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("comecou thread");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
