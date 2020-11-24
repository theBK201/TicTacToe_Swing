import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Tic Tac Toe with Swing Library");

        GridLayout layout = new GridLayout(3,3);
        mainFrame.setLayout(layout);

        // Defining the Frame and it's basic options
        mainFrame.setSize(500,500);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Defining the buttons and also adding them to the Frame
        JButton jb1 = new JButton();
        JButton jb2 = new JButton();
        JButton jb3 = new JButton();
        JButton jb4 = new JButton();
        JButton jb5 = new JButton();
        JButton jb6 = new JButton();
        JButton jb7 = new JButton();
        JButton jb8 = new JButton();
        JButton jb9 = new JButton();

        mainFrame.add(jb1);
        mainFrame.add(jb2);
        mainFrame.add(jb3);
        mainFrame.add(jb4);
        mainFrame.add(jb5);
        mainFrame.add(jb6);
        mainFrame.add(jb7);
        mainFrame.add(jb8);
        mainFrame.add(jb9);
    }
}
