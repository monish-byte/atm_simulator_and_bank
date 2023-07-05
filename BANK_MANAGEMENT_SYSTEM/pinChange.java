package BANK_MANAGEMENT_SYSTEM;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pinChange extends JFrame implements ActionListener{

    JPasswordField pin ,repin;
    JButton change , back;
    String pinnumber;

    pinChange(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BANK_MANAGEMENT_SYSTEM/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); 
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(250,280,500,35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        JLabel repintext = new JLabel("RE-ENTER THE PIN:");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setBounds(330,360,180,25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355,460,150,30);
        image.add(change);
        change.addActionListener(this);

        back = new JButton("BACK");
        back.setBounds(355,490,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new pinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
       try{
        String npin = pin.getText();
        String rpin = repin.getText();
        if(!npin.equals(rpin)){
            JOptionPane.showMessageDialog(null, "Entered pin does not match");
            return;
        }
        if(npin.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter PIN");
            return;
        }

        conn con = new conn();
        String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
        String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
        String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";

        con.s.executeUpdate(query1);
        con.s.executeUpdate(query2);
        con.s.executeUpdate(query3);

        JOptionPane.showMessageDialog(null,"PIN changed successfully");
        setVisible(false);
        new transaction(npin).setVisible(true);
       }catch(Exception ae){

       }
    }else{
        setVisible(false);
        new transaction(pinnumber).setVisible(true);
    }
}
}
