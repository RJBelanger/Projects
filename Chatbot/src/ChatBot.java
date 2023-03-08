import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatBot extends JFrame {

    //creating the input and output section of the window
    private JTextArea Response = new JTextArea();
    private JTextField input = new JTextField();

    public ChatBot(){
        //creation of chat window
        JFrame chatWin = new JFrame();

        //sets setting for blank jframe that is visble cannot be resized and has a size of 650 by 650
        chatWin.setDefaultCloseOperation(EXIT_ON_CLOSE);
        chatWin.setVisible(true);
        chatWin.setResizable(false);
        chatWin.setLayout(null);
        chatWin.setSize(650,650);
        chatWin.setTitle("Chat Bot");

        chatWin.add(Response);
        chatWin.add(input);
        Response.setSize(550,450);
        Response.setLocation(2,2);
        input.setSize(580,30);
        input.setLocation(2,550);

        input.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String gtext = input.getText().toLowerCase();
                Response.append("YOU ->"+ gtext + "\n");
                input.setText("");

                if(gtext.contains("hi")) {
                    bot("holla");
                }
                else{
                    int rand = (int)(Math.random() * 3 + 1);
                    if(rand == 1) {
                        bot("i do not understand");
                    }
                    else if(rand == 2) {
                        bot("I could not understand what you meant.");
                    }
                    else if(rand == 3) {
                        bot("I could not understand you");
                    }
                }

                //new text being reconized
                if(gtext.contains("how")) {
                    bot("How Are you doing?");
                }
                else{
                    int rand = (int)(Math.random() * 3 + 1);
                    if(rand == 1) {
                        bot("i do not understand");
                    }
                    else if(rand == 2) {
                        bot("I could not understand what you meant.");
                    }
                    else if(rand == 3) {
                        bot("I could not understand you");
                    }
                }
            }
        });
    }
    //Adds title to start of bot response
    private void bot(String s) {
        Response.append("BOT ->" +s+ "\n");
    }


    public static void main(String args[]) {

        new ChatBot();

    }
}