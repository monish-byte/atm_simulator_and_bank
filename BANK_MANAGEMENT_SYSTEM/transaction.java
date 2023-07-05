package BANK_MANAGEMENT_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class transaction extends JFrame implements ActionListener{
    JButton exit ,deposit,withdrawl ,fastcash,ministatement,pinchange,balanceenquiry;
    String pin;

    transaction(String pin){
        this.pin = pin ;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BANK_MANAGEMENT_SYSTEM/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); 
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(355,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(355,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

    }

    

    public static void main(String[] args) {
        new transaction("");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new deposit(pin).setVisible(true);
        }else if(e.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pin).setVisible(true);
        }else if(e.getSource()==fastcash){
            setVisible(false);
            new fastcash(pin).setVisible(true);
        }else if(e.getSource()==pinchange){
            setVisible(false);
            new pinChange(pin).setVisible(true);
        }else if(e.getSource()==balanceenquiry){
            setVisible(false);
            new balanceEnquiry(pin).setVisible(true);
        }else if(e.getSource()==ministatement){
            
            new miniStatement(pin).setVisible(true);;
        }
    }
    
}
