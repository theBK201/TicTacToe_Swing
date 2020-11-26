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
        mainFrame.setSize(500,500);
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

//        ActionListener listener = new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource() instanceof JButton){
//                    String text = (((JButton) e.getSource()).getText());
//                if (text.isEmpty()){
//                    if(playerone){
//                        text = firstPlayer;
//                    }else {
//                        text = secondPlayer;
//                    }
//                }
//                }
//            }
//        };

        JButton[] buttons = new JButton[9];

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("");
            buttons[i].setFont(new java.awt.Font("Arial",Font.BOLD,30));
            gridPanel.add(buttons[i]);
        }

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[0].setText(firstPlayer);
                }else {
                    buttons[0].setText(secondPlayer);
                }
            }
        });
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[1].setText(firstPlayer);
                }else {
                    buttons[1].setText(secondPlayer);
                }
            }
        });
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[2].setText(firstPlayer);
                }else {
                    buttons[2].setText(secondPlayer);
                }
            }
        });
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[3].setText(firstPlayer);
                }else {
                    buttons[3].setText(secondPlayer);
                }
            }
        });
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[4].setText(firstPlayer);
                }else {
                    buttons[4].setText(secondPlayer);
                }
            }
        });
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[5].setText(firstPlayer);
                }else {
                    buttons[5].setText(secondPlayer);
                }
            }
        });
        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[6].setText(firstPlayer);
                }else {
                    buttons[6].setText(secondPlayer);
                }
            }
        });
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[7].setText(firstPlayer);
                }else {
                    buttons[7].setText(secondPlayer);
                }
            }
        });
        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerone){
                    buttons[8].setText(firstPlayer);
                }else {
                    buttons[8].setText(secondPlayer);
                }
            }
        });
    }
}
