import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        JButton play = new JButton("Play");
        JButton newgame = new JButton("New Game");
        bottomButtons.add(play);
        bottomButtons.add(newgame);

        mainFrame.add(bottomButtons,BorderLayout.PAGE_END);
        mainFrame.add(gridPanel,BorderLayout.CENTER);
        mainFrame.add(topElements,BorderLayout.PAGE_START);


        //Defining Labels
        JLabel victory = new JLabel("hat gewonnen !!!");
        JLabel player = new JLabel("");
        victory.setFont(new java.awt.Font("Arial",Font.BOLD,20));
        player.setFont(new java.awt.Font("Arial", Font.BOLD,15));

        victory.setVisible(false);
        topElements.add(player);
        topElements.add(victory);


        //Game Mechanics
        boolean playerone = false;
        String firstPlayer = "X";
        String secondPlayer = "O";

        newgame.setEnabled(false);

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean playerone;

                if(Math.random() < 0.5){
                    player.setText("Spieler 1 ist dran.");
                    playerone = true;
                } else {
                    player.setText("Spieler 2 ist dran.");
                }
                play.setEnabled(false);
            }
        });

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() instanceof JButton){
                    String text = (((JButton) e.getSource()).getText());
                if (text.isEmpty()){
                    if(playerone){
                        text = firstPlayer;
                    }else {
                        text = secondPlayer;
                    }
                }
                }
            }
        };

        JButton[] buttons = new JButton[9];

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("");
            gridPanel.add(buttons[i]);
        }
    }
}
