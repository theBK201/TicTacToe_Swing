import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Random;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Main {
    public static void main(String[] args) {

        gameGUI gui = new gameGUI("Tic Tac Toe using the Swing library");
        gui.setVisible(true);
    }
}

class gameGUI extends JFrame implements ActionListener {

    int seconds,minutes;
    String dSeconds, dMinutes;
    Timer timer;

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
        gridPanel.setBorder(new EmptyBorder(20,0,20,0));

        //Defining the buttons and also adding them to the Frame
        JButton play = new JButton("Play");
        JButton resetBoard = new JButton("Reset Board");
        bottomButtons.add(play);
        bottomButtons.add(resetBoard);

        add(bottomButtons, BorderLayout.PAGE_END);
        add(gridPanel, BorderLayout.CENTER);
        add(topElements, BorderLayout.PAGE_START);


        //Defining Labels
        JLabel victory = new JLabel("");
        JLabel player = new JLabel("");
        JLabel gmcounter = new JLabel("");
        victory.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        player.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        gmcounter.setFont(new java.awt.Font("Arial", Font.BOLD, 20));
        gmcounter.setBorder(new EmptyBorder(0,50,0,0));

        victory.setVisible(false);
        topElements.add(player);
        topElements.add(victory);
        topElements.add(gmcounter);
        resetBoard.setEnabled(false);
        gmcounter.setVisible(true);
        JButton[] buttons = new JButton[9];

        //Colors for the Game
        Color defaultColor = UIManager.getColor( "Panel.background");
        Color pOneWin = Color.RED;
        Color pTwoWin = Color.GREEN;


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new java.awt.Font("Arial", Font.BOLD, 30));
            gridPanel.add(buttons[i]);
            buttons[i].setEnabled(false);
            buttons[i].setBorder(new LineBorder(Color.black,1));
        }

        gameMechanics mechanics = new gameMechanics();
        DecimalFormat timerFormat = new DecimalFormat("00");

        Timer gameTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                dSeconds = timerFormat.format(seconds);
                dMinutes = timerFormat.format(minutes);
                gmcounter.setText(dMinutes+ ":" + dSeconds);

                if (seconds == 60){
                    seconds = 0;
                    minutes++;
                    dSeconds = timerFormat.format(seconds);
                    dMinutes = timerFormat.format(minutes);
                    gmcounter.setText(dMinutes+ ":" + dSeconds);
                }
            }
        });

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
                seconds = 0;
                minutes = 0;
                gmcounter.setText("00:00");
                gmcounter.setVisible(true);
                gameTimer.start();
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
                                topElements.setBackground(pOneWin);
                                buttons[0].setBackground(pOneWin);
                                buttons[1].setBackground(pOneWin);
                                buttons[2].setBackground(pOneWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[3].getText() == "X" && buttons[4].getText() == "X" && buttons[5].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                topElements.setBackground(pOneWin);
                                buttons[3].setBackground(pOneWin);
                                buttons[4].setBackground(pOneWin);
                                buttons[5].setBackground(pOneWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[6].getText() == "X" && buttons[7].getText() == "X" && buttons[8].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                topElements.setBackground(pOneWin);
                                buttons[6].setBackground(pOneWin);
                                buttons[7].setBackground(pOneWin);
                                buttons[8].setBackground(pOneWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[0].getText() =="X" && buttons[3].getText() == "X" && buttons[6].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                topElements.setBackground(pOneWin);
                                buttons[0].setBackground(pOneWin);
                                buttons[3].setBackground(pOneWin);
                                buttons[6].setBackground(pOneWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                        }
                            if (buttons[1].getText() =="X" && buttons[4].getText() == "X" && buttons[7].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                topElements.setBackground(pOneWin);
                                buttons[1].setBackground(pOneWin);
                                buttons[4].setBackground(pOneWin);
                                buttons[7].setBackground(pOneWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[2].getText() =="X" && buttons[5].getText() == "X" && buttons[8].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                topElements.setBackground(pOneWin);
                                buttons[2].setBackground(pOneWin);
                                buttons[5].setBackground(pOneWin);
                                buttons[8].setBackground(pOneWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[0].getText() =="X" && buttons[4].getText() == "X" && buttons[8].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                victory.setVisible(true);
                                player.setVisible(false);
                                topElements.setBackground(pOneWin);
                                buttons[0].setBackground(pOneWin);
                                buttons[4].setBackground(pOneWin);
                                buttons[8].setBackground(pOneWin);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[2].getText() =="X" && buttons[4].getText() == "X" && buttons[6].getText() == "X"){
                                victory.setText("Spieler 1 hat gewonnen !!!");
                                victory.setVisible(true);
                                player.setVisible(false);
                                topElements.setBackground(pOneWin);
                                buttons[2].setBackground(pOneWin);
                                buttons[4].setBackground(pOneWin);
                                buttons[6].setBackground(pOneWin);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }

                            if (buttons[0].getText() == "O" && buttons[1].getText() == "O" && buttons[2].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[0].setBackground(pTwoWin);
                                buttons[1].setBackground(pTwoWin);
                                buttons[2].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[3].getText() == "O" && buttons[4].getText() == "O" && buttons[5].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[3].setBackground(pTwoWin);
                                buttons[4].setBackground(pTwoWin);
                                buttons[5].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[6].getText() == "O" && buttons[7].getText() == "O" && buttons[8].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[6].setBackground(pTwoWin);
                                buttons[7].setBackground(pTwoWin);
                                buttons[8].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[0].getText() =="O" && buttons[3].getText() == "O" && buttons[6].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[0].setBackground(pTwoWin);
                                buttons[3].setBackground(pTwoWin);
                                buttons[6].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[1].getText() =="O" && buttons[4].getText() == "O" && buttons[7].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[1].setBackground(pTwoWin);
                                buttons[4].setBackground(pTwoWin);
                                buttons[7].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[2].getText() =="O" && buttons[5].getText() == "O" && buttons[8].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[2].setBackground(pTwoWin);
                                buttons[5].setBackground(pTwoWin);
                                buttons[8].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[0].getText() =="O" && buttons[4].getText() == "O" && buttons[8].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[0].setBackground(pTwoWin);
                                buttons[4].setBackground(pTwoWin);
                                buttons[8].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                            if (buttons[2].getText() =="O" && buttons[4].getText() == "O" && buttons[6].getText() == "O"){
                                victory.setText("Spieler 2 hat gewonnen !!!");
                                topElements.setBackground(pTwoWin);
                                buttons[2].setBackground(pTwoWin);
                                buttons[4].setBackground(pTwoWin);
                                buttons[6].setBackground(pTwoWin);
                                victory.setVisible(true);
                                player.setVisible(false);
                                for (int h = 0; h < buttons.length; h++){
                                    buttons[h].setEnabled(false);
                                }
                                resetBoard.setEnabled(true);
                                gameTimer.stop();
                            }
                        buttonPressed.setEnabled(false);
                        mechanics.movescounter ++;
                        if( mechanics.movesCounter() == true && !victory.isVisible()){
                            player.setVisible(false);
                            victory.setText("Unentschieden");
                            victory.setVisible(true);
                            resetBoard.setEnabled(true);
                            gameTimer.stop();
                        }
                    }
                });
            }
       }

      resetBoard.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              for (int i = 0; i < buttons.length; i++){
                  buttons[i].setText("");
                  gmcounter.setText("");
                  buttons[i].setEnabled(false);
                  buttons[i].setBackground(defaultColor);
                  victory.setVisible(false);
                  resetBoard.setEnabled(false);
                  mechanics.movescounter = 0;
                  play.setEnabled(true);
                  topElements.setBackground(defaultColor);
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
    int movescounter;

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

    public boolean movesCounter(){
        boolean check =false;
        if(movescounter > 8) {
            movescounter = 0;
            check = true;
        }
        return check;
    }
}


