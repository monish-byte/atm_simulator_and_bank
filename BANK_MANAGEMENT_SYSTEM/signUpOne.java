package BANK_MANAGEMENT_SYSTEM;

import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

import javax.swing.*;

public class signUpOne extends JFrame implements ActionListener{

    long rand ;
    JTextField nameTextField ,fNameTextField, emailTextField, addressTextField, cityTextField,
    stateTextField,pincodeTextField;
    JButton next ;
    JRadioButton male , female , r1 , r2;
    JDateChooser  dateChooser;

    signUpOne(){
        setLayout(null);
        Random ran = new Random();
        rand = Math.abs((ran.nextLong()%9000L)+1000L);
        JLabel form = new JLabel("APPLICATION FORM NO " + rand );
        form.setFont(new Font("raleway",Font.BOLD,30));
        form.setBounds(200,20,600,40);
        add(form);


        JLabel personDetail = new JLabel("PAGE 1: PERSONAL DETAILS");
        personDetail.setFont(new Font("raleway",Font.BOLD,22));
        personDetail.setBounds(250,80,600,30);
        add(personDetail);

        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

         nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(325,140,400,30);
        add(nameTextField);

        JLabel Fname = new JLabel("FATHER'S NAME:");
        Fname.setFont(new Font("raleway",Font.BOLD,20));
        Fname.setBounds(100,190,300,30);
        add(Fname);

        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fNameTextField.setBounds(325,190,400,30);
        add(fNameTextField);

        JLabel dob = new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,300,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway",Font.BOLD,14));
        dateChooser.setBounds(325, 240, 400,30);   
        add(dateChooser);     

        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,290,300,30);
        add(gender);

        male = new JRadioButton("MALE");        
        female = new JRadioButton("FEMALE");
        male.setBackground(Color.WHITE); 
        female.setBackground(Color.WHITE); 
        male.setBounds(325,290,75,30);
        female.setBounds(450,290,75,30);
        
        add(male);       
        add(female);       

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("EMAIL ADDRESS:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,340,300,30);
        add(email);

         emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(325,340,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("MARITAL STATUS:");
        marital.setFont(new Font("raleway",Font.BOLD,20));
        marital.setBounds(100,390,300,30);
        add(marital);

        r1 = new JRadioButton("MARRIED");        
        r2 = new JRadioButton("UNMARRIED");
        r1.setBackground(Color.WHITE); 
        r2.setBackground(Color.WHITE); 
        r1.setBounds(325,390,125,30);
        r2.setBounds(450,390,125,30);
        
        add(r1);       
        add(r2);       

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(r1);
        maritalGroup.add(r2);
        

        JLabel address = new JLabel("ADRRESS:");
        address.setFont(new Font("raleway",Font.BOLD,20));
        address.setBounds(100,440,300,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(325,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("CITY:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,490,300,30);
        add(city);

        cityTextField= new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(325,490,400,30);
        add(cityTextField);

        JLabel state = new JLabel("STATE:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,540,300,30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(325,540,400,30);
        add(stateTextField);

        JLabel pincode = new JLabel("PINCODE:");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,590,300,30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(325,590,400,30);
        add(pincodeTextField);



        next = new JButton("NEXT");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(643,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        new signUpOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = ""+rand;
        String name  = nameTextField.getText();
        String fname = fNameTextField.getText();
        String dob =((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "MALE";
        }else if(female.isSelected()){
            gender = "FEMALE";
        }
       String email = emailTextField.getText();
       String marital = null ;
       if(r1.isSelected()){
        marital = "MARRIED";
       }else if (r2.isSelected()){
        marital = "UNMARRIED";
       }
       String address = addressTextField.getText();
       String city = cityTextField.getText();
       String state = stateTextField.getText();
       String pin = pincodeTextField.getText();

       try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required!!");
            }else{
                conn c = new conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signUpTwo(formno).setVisible(true);
                
            }
       }catch(Exception b){
        System.out.println(b);
       }
 
    }
}
