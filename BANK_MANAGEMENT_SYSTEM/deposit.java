package BANK_MANAGEMENT_SYSTEM;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class deposit extends JFrame implements ActionListener{

    JButton deposit , back ;
    JTextField amount;
    String pin ;

    deposit(String pin){

        this.pin = pin ;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BANK_MANAGEMENT_SYSTEM/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900); 
        add(image);


        JLabel text = new JLabel("ENTER THE AMOUNT TO DEPOSIT");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Sytsem",Font.BOLD,16));
        text.setBounds(200,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font ("Raleway", Font.BOLD,22));
        amount.setBounds(170,340,320,25);
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
        setLocation(300,0);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }
    public static void main(String[] args) {
        new deposit("");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want To Deposit");
            }else{
                try{
                conn conn = new conn();
                String query = "insert into bank values('"+pin+"','"+date+"','deposit','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                setVisible(false);
                new transaction(pin).setVisible(true);
                }catch(Exception b){
                    System.out.println(b);
                }
            }
        }else if (e.getSource()==back){
            setVisible(false);
          new transaction(pin).setVisible(true);
        }
    }
}
