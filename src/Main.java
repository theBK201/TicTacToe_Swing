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
        JLabel victory = new JLabel("");
        JLabel player = new JLabel("");
        victory.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        player.setFont(new java.awt.Font("Arial", Font.BOLD, 20));

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
                mechanics.getRandomNum();
                player.setVisible(true);
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
                        player.setText(mechanics.getPlayer());
                        buttonPressed.setText(mechanics.getPlayerChar());
                            if (buttons[0].getText() == "X" && buttons[1].getText() == "X" && buttons[2].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                newGame.setEnabled(true);
                            }
                            if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                newGame.setEnabled(true);
                            }
                            if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                newGame.setEnabled(true);
                            }
                            if (buttons[0].getText() =="X" && buttons[3].getText() == "X" && buttons[6].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                newGame.setEnabled(true);
                        }
                        if (buttons[1].getText() =="X" && buttons[4].getText() == "X" && buttons[7].getText() == "X"){
                            victory.setText("Spieler 1 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[2].getText() =="X" && buttons[5].getText() == "X" && buttons[8].getText() == "X"){
                            victory.setText("Spieler 1 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[0].getText() =="X" && buttons[4].getText() == "X" && buttons[8].getText() == "X"){
                            victory.setText("Spieler 1 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[2].getText() =="X" && buttons[4].getText() == "X" && buttons[6].getText() == "X"){
                            victory.setText("Spieler 1 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }

                        if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[0].getText() =="O" && buttons[3].getText() == "O" && buttons[6].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[1].getText() =="O" && buttons[4].getText() == "O" && buttons[7].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[2].getText() =="O" && buttons[5].getText() == "O" && buttons[8].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[0].getText() =="O" && buttons[4].getText() == "O" && buttons[8].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        if (buttons[2].getText() =="O" && buttons[4].getText() == "O" && buttons[6].getText() == "O"){
                            victory.setText("Spieler 2 hat gewonnen !!!");
                            victory.setVisible(true);
                            player.setVisible(false);
                            for (int h = 0; h < buttons.length; h++){
                                buttons[h].setEnabled(false);
                            }
                            newGame.setEnabled(true);
                        }
                        buttonPressed.setEnabled(false);
                        if( mechanics.movesCounter(+1) == true && !victory.isVisible()){
                            player.setVisible(false);
                            victory.setText("Unentschieden");
                            victory.setVisible(true);
                            newGame.setEnabled(true);
                        }
                    }
                });
            }
       }

      newGame.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              for (int i = 0; i < buttons.length; i++){
                  buttons[i].setText("");
                  buttons[i].setEnabled(true);
                  victory.setVisible(false);
                  newGame.setEnabled(false);
                  play.setEnabled(true);
              }
          }
      });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

class gameMechanics {
    boolean playerOne;
    boolean playerTwo;

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
        String whichPlayer = "";

        if (playerOne) {
            whichPlayer = "Spieler 1 ist dran";
            playerOne = false;
            playerTwo = true;
        }else {
            whichPlayer = "Spieler 2 ist dran";
            playerTwo = false;
            playerOne = true;
        }

        return whichPlayer;
    }

    public String getPlayerChar(){
        String playerChar = "";

        if (playerOne){
            playerChar = "X";
        }else {
            playerChar = "O";
        }

        return playerChar;
    }

    public boolean movesCounter(int counter){
        boolean check =false;
        int moves;
        moves = counter;
        if(moves > 8) {
            moves = 0;
            check = true;
        }
        return check;
    }
}


