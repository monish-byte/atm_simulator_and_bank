package BANK_MANAGEMENT_SYSTEM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;



public class fastcash extends JFrame implements ActionListener{
    JButton exit ,b1, b2, b3, b4, b5, b6;
    String pin;

    fastcash(String pin){
        this.pin = pin ;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BANK_MANAGEMENT_SYSTEM/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); 
        add(image);

        JLabel text = new JLabel("Please Select Withdrawl Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        b1 = new JButton("Rs 100");
        b1.setBounds(170,415,150,30);
        b1.addActionListener(this);
        image.add(b1);

        b2 = new JButton("Rs 500");
        b2.setBounds(355,415,150,30);
        b2.addActionListener(this);
        image.add(b2);

        b3 = new JButton("Rs 1000");
        b3.setBounds(170,450,150,30);
        b3.addActionListener(this);
        image.add(b3);

        b4 = new JButton("Rs 2000");
        b4.setBounds(355,450,150,30);
        b4.addActionListener(this);
        image.add(b4);

        b5 = new JButton("Rs 5000");
        b5.setBounds(170,485,150,30);
        b5.addActionListener(this);
        image.add(b5);

        b6 = new JButton("Rs 10000");
        b6.setBounds(355,485,150,30);
        b6.addActionListener(this);
        image.add(b6);

        exit = new JButton("BACK");
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
        new fastcash("");
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new transaction(pin).setVisible(true);
        }else {
            String amount = ((JButton)e.getSource()).getText().substring(3);
            conn c = new conn();
            try{
                 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                 int balance =0 ;
                 while(rs.next()){

                    if(rs.getString("type").equals("deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                 }

                 if(e.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                 }

                Date date = new Date();
                String query = "insert into bank values('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount +" Debited Successfully");
                setVisible(false);
                new transaction(pin).setVisible(true);
            }catch(Exception ae){
                System.out.println(ae);
            }
        }
    }
    
}