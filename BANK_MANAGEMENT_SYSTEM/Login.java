package BANK_MANAGEMENT_SYSTEM;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

import java.sql.*;

public class Login extends JFrame implements ActionListener{

    JButton login , signup , clear ;
    JTextField cardTextField ;
    JPasswordField pinTextField;

    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        
        // ATM BANK ICON
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BANK_MANAGEMENT_SYSTEM/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(130,10,100,100);
        add(label);

              
       // WELCOME TO ATM TEXT
       JLabel text = new JLabel("WELCOME TO ATM");
       text.setFont(new Font("Osward",Font.BOLD,38));
       text.setBounds(250,40,400,40);
       add(text);

       //CARD NO. TEXT
       JLabel cardno = new JLabel("CARD NO.");
       cardno.setBounds(120,150,150,40);
       cardno.setFont(new Font("raleway",Font.BOLD,29));
       add(cardno);
       
       //CARD NO. TEXT FIELD
       cardTextField = new JTextField();
       cardTextField.setBounds(300,160,230,30);
       cardTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(cardTextField);

       // PIN TEXT
       JLabel pin = new JLabel("PIN");
       pin.setFont(new Font("raleway",Font.BOLD,28));
       pin.setBounds(120,220,400,40);
       add(pin);

       //PIN TEXT FIELD
       pinTextField = new JPasswordField();
       pinTextField.setBounds(300,220,230,30);
       pinTextField.setFont(new Font("Arial",Font.BOLD,14));
       add(pinTextField);


       // LOGIN BUTTON 
       login = new JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.addActionListener(this);
       add(login);
       
       // CLEAR BUTTON
       clear = new JButton("CLEAR");
       clear.setBounds(430,300,100,30);
       clear.addActionListener(this);
       add(clear);

       // SIGN UP BUTTON
       signup = new JButton("SIGN UP");
       signup.setBounds(300,350,230,30);
       signup.addActionListener(this);
       add(signup);


        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    public void actionPerformed(ActionEvent ae){
           if(ae.getSource()==clear){

            cardTextField.setText("");
            pinTextField.setText("");
           }else if(ae.getSource()==login){
            conn conn = new conn();
            String cardnumber = cardTextField.getText();
            String pin = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pin+"'";
            try{
 
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transaction(pin);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin");
                }

            }catch(Exception e){
                System.out.println(e);
            }

           }else if(ae.getSource()==signup){
                setVisible(false);
                new signUpOne().setVisible(true);
           }
    }

    public static void main(String[] args) {
        new Login();
    }
    
}
