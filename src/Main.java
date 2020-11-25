import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Tic Tac Toe with Swing Library");
        JPanel gridPanel = new JPanel();
        JPanel bottomButtons = new JPanel();
        JPanel topElements = new JPanel();

        mainFrame.setLayout(new BorderLayout());
        gridPanel.setLayout(new GridLayout(3,3));
        bottomButtons.setLayout(new FlowLayout());
        topElements.setLayout(new FlowLayout());

        // Defining the Frame and it's basic options
        mainFrame.setSize(400,400);
        mainFrame.setVisible(true);
        mainFrame.setLocation(450,100);
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
        JButton play = new JButton("Play");
        JButton newgame = new JButton("New Game");

        gridPanel.add(jb1);
        gridPanel.add(jb2);
        gridPanel.add(jb3);
        gridPanel.add(jb4);
        gridPanel.add(jb5);
        gridPanel.add(jb6);
        gridPanel.add(jb7);
        gridPanel.add(jb8);
        gridPanel.add(jb9);
        bottomButtons.add(play);
        bottomButtons.add(newgame);

        mainFrame.add(bottomButtons,BorderLayout.PAGE_END);
        mainFrame.add(gridPanel,BorderLayout.CENTER);
        mainFrame.add(topElements,BorderLayout.PAGE_START);


        //Defining Labels
        JLabel victory = new JLabel("hat gewonnen !!!");
        JLabel player = new JLabel("");
        victory.setFont(new java.awt.Font("Arial",Font.BOLD,20));

        topElements.add(player);
        topElements.add(victory);



        //Game Mechanics
        boolean randomPlayer;

    }
}
