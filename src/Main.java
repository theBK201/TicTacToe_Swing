import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        gameGUI gui = new gameGUI("Tic Tac Toe using the Swing library");
        gui.setVisible(true);
    }
}

class gameGUI extends JFrame implements ActionListener {

    gameGUI(String title) {
        // Defining the Frame and it's basic options
        super(title);
        setSize(500, 500);
        setLocation(450, 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel();
        JPanel bottomButtons = new JPanel();
        JPanel topElements = new JPanel();

        gridPanel.setLayout(new GridLayout(3, 3));
        bottomButtons.setLayout(new FlowLayout());
        topElements.setLayout(new FlowLayout());

        //Defining the buttons and also adding them to the Frame
        JButton play = new JButton("Play");
        JButton newGame = new JButton("New Game");
        bottomButtons.add(play);
        bottomButtons.add(newGame);

        add(bottomButtons, BorderLayout.PAGE_END);
        add(gridPanel, BorderLayout.CENTER);
        add(topElements, BorderLayout.PAGE_START);


        //Defining Labels
        JLabel victory = new JLabel("hat gewonnen !!!");
        JLabel player = new JLabel("");
        victory.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        player.setFont(new java.awt.Font("Arial", Font.BOLD, 15));

        victory.setVisible(false);
        topElements.add(player);
        topElements.add(victory);
        newGame.setEnabled(false);
        JButton[] buttons = new JButton[9];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new java.awt.Font("Arial", Font.BOLD, 30));
            gridPanel.add(buttons[i]);
            buttons[i].setEnabled(false);
        }

        gameMechanics mechanics = new gameMechanics();

        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play.setEnabled(false);
                player.setText(mechanics.getPlayer());
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setEnabled(true);
                }
            }
        });

      for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().isEmpty()) {
                buttons[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton buttonPressed = ((JButton) e.getSource());
                        buttonPressed.setText(mechanics.getPlayerChar());
                        buttonPressed.setEnabled(false);
                        player.setText(mechanics.getPlayer());
                    }
                });
            }
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class gameMechanics {
    boolean playerOne = false;
    boolean playerTwo = false;

    public int getRandomNum() {
        Random chosenPlayer = new Random();
        int randomNum = chosenPlayer.nextInt(2) + 1;

        if(randomNum ==1){

            playerOne = true;
        } else{
            playerTwo = true;
        }
        return randomNum;
    }

    public String getPlayer() {
        getRandomNum();
        String whichPlayer = "";

        if (playerOne) {
            whichPlayer = "Spieler 1 ist dran";
            playerOne = false;
        } else{
            whichPlayer = "Spieler 2 ist dran";
            playerTwo = false;
        }

        return whichPlayer;
    }

    public String getPlayerChar(){
        String playerChar = "";

        if (playerOne){
            playerChar = "X";
            playerOne = false;
        }else {
            playerChar = "O";
            playerTwo = false;
        }

        return playerChar;
    }
}


