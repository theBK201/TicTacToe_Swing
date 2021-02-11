import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    private boolean playerOne = false;
    private boolean playerTwo = false;
    Random chosenPlayer = new Random();

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Tic Tac Toe with Swing Library");
        JPanel gridPanel = new JPanel();
        JPanel bottomButtons = new JPanel();
        JPanel topElements = new JPanel();

        mainFrame.setLayout(new BorderLayout());
        gridPanel.setLayout(new GridLayout(3, 3));
        bottomButtons.setLayout(new FlowLayout());
        topElements.setLayout(new FlowLayout());

        // Defining the Frame and it's basic options
        mainFrame.setSize(500, 500);
        mainFrame.setVisible(true);
        mainFrame.setLocation(450, 100);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        //Defining the buttons and also adding them to the Frame
        JButton play = new JButton("Play");
        JButton newGame = new JButton("New Game");
        bottomButtons.add(play);
        bottomButtons.add(newGame);

        mainFrame.add(bottomButtons, BorderLayout.PAGE_END);
        mainFrame.add(gridPanel, BorderLayout.CENTER);
        mainFrame.add(topElements, BorderLayout.PAGE_START);


        //Defining Labels
        JLabel victory = new JLabel("hat gewonnen !!!");
        JLabel player = new JLabel("");
        victory.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        player.setFont(new java.awt.Font("Arial", Font.BOLD, 15));

        victory.setVisible(false);
        topElements.add(player);
        topElements.add(victory);


        //Game Mechanics
        newGame.setEnabled(false);
        JButton[] buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new java.awt.Font("Arial", Font.BOLD, 30));
            gridPanel.add(buttons[i]);
            buttons[i].setEnabled(false);
        }

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main playerSelect = new Main();
                play.setEnabled(false);
                player.setText(playerSelect.gameStarting());

                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
            }
        });

        Main playerChar = new Main();

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().isEmpty()) {
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(playerChar.playerOne){
                            player.setText("Spieler 1 ist dran");
                        }else {
                            player.setText("Spieler 2 ist dran");
                        }
                        JButton buttonPressed = ((JButton) e.getSource());
                        buttonPressed.setText(playerChar.whichPlayerIsSelected());
                        buttonPressed.setEnabled(false);
                    }
                });
            }
        }
    }

    public String gameStarting() {
        int randomNum = chosenPlayer.nextInt(2) + 1;
        String whichPlayer = "";

        if (randomNum == 1) {
            whichPlayer = "Spieler 1 ist dran.";
            playerOne = true;
        } else {
            whichPlayer = "Spieler 2 ist dran.";
            playerTwo = true;
        }
        return whichPlayer;
    }

    public String whichPlayerIsSelected() {
        String playerChar = "";

        if (playerOne) {
            playerChar = "X";
            playerOne = false;
            playerTwo = true;
        } else {
            playerChar = "O";
            playerTwo = false;
            playerOne = true;
        }
        return playerChar;
    }
}
