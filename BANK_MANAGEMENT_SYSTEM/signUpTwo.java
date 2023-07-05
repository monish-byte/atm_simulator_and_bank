package BANK_MANAGEMENT_SYSTEM;

import java.awt.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

import javax.swing.*;

public class signUpTwo extends JFrame implements ActionListener{

    
    JTextField panTextField, adharTextField;
    JButton next ;
    JRadioButton male , female , r1 , r2 , syes , sno , ayes , ano;
    JDateChooser  dateChooser;
    JComboBox<String> religionBox , categoryBox, incomeBox ,educationBox , occupationBox;
    String formno;

    signUpTwo(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
       


        JLabel additionalDetail = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionalDetail.setFont(new Font("raleway",Font.BOLD,22));
        additionalDetail.setBounds(250,80,600,30);
        add(additionalDetail);

        JLabel religion = new JLabel("RELIGION:");
        religion.setFont(new Font("raleway",Font.BOLD,20));
        religion.setBounds(100,140,150,30);
        add(religion);
           
        String[] religionChoices = {"HINDU","MUSLIM","CHRISTIAN","BUDDHIST","SIKH","JAIN","PARSI","JEW"};
        religionBox = new JComboBox<>(religionChoices);
        religionBox.setFont(new Font("Raleway",Font.BOLD,14));
        religionBox.setBounds(325,140,400,30);
        add(religionBox);

        JLabel category = new JLabel("CATEGORY:");
        category.setFont(new Font("raleway",Font.BOLD,20));
        category.setBounds(100,190,300,30);
        add(category);

        String[] categoryChoices = {"GENERAL","OBC","SC","ST"};
        categoryBox = new JComboBox<>(categoryChoices);
        categoryBox.setFont(new Font("Raleway",Font.BOLD,14));
        categoryBox.setBounds(325,190,400,30);
        add(categoryBox);

        JLabel income = new JLabel("INCOME:");
        income.setFont(new Font("raleway",Font.BOLD,20));
        income.setBounds(100,240,300,30);
        add(income);

        String[] incomeChoices = {"NULL","< 1,50,000","< 2,50,000","< 5,00,000","UPTO 10,00,000"};
        incomeBox = new JComboBox<>(incomeChoices);
        incomeBox.setFont(new Font("Raleway",Font.BOLD,14));
        incomeBox.setBounds(325, 240, 400,30);   
        add(incomeBox);     

        JLabel gender = new JLabel("EDUCATIONAL");
        gender.setFont(new Font("raleway",Font.BOLD,20));
        gender.setBounds(100,290,300,30);
        add(gender);
        JLabel email = new JLabel("QUALIFICATION:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,315,300,30);
        add(email);
        
        String[] educationChoices = {"NON-GRADUATE","GRADUATE","POST-GRADUATE","DOCTRATE","OTHERS"};
        educationBox = new JComboBox<>(educationChoices);
        educationBox.setFont(new Font("Raleway",Font.BOLD,14));
        educationBox.setBounds(325, 315, 400,30);   
        add(educationBox); 
         

        JLabel occupation = new JLabel("OCCUPATION:");
        occupation.setFont(new Font("raleway",Font.BOLD,20));
        occupation.setBounds(100,390,300,30);
        add(occupation);

        String[] occupationChoices = {"SALARIED","SELF EMPLOYED","BUSSINESS","STUDENT","RETIRED","OTHERS"};
        occupationBox = new JComboBox<>(occupationChoices);
        occupationBox.setFont(new Font("Raleway",Font.BOLD,14));
        occupationBox.setBounds(325, 390, 400,30);   
        add(occupationBox);
        

        JLabel pan = new JLabel("PAN NO:");
        pan.setFont(new Font("raleway",Font.BOLD,20));
        pan.setBounds(100,440,300,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(325,440,400,30);
        add(panTextField);

        JLabel adhar = new JLabel("ADHAR NO:");
        adhar.setFont(new Font("raleway",Font.BOLD,20));
        adhar.setBounds(100,490,300,30);
        add(adhar);

        adharTextField= new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        adharTextField.setBounds(325,490,400,30);
        add(adharTextField);

        JLabel seniorCitizen = new JLabel("SENIOR CITIZEN:");
        seniorCitizen.setFont(new Font("raleway",Font.BOLD,20));
        seniorCitizen.setBounds(100,540,300,30);
        add(seniorCitizen);

        syes = new JRadioButton("YES");
        syes.setBounds(325,540,50,30);
        syes.setBackground(Color.WHITE);
        add(syes);
        sno = new JRadioButton("NO");
        sno.setBounds(400,540,50,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);

        JLabel pincode = new JLabel("EXISTING ACCOUNT:");
        pincode.setFont(new Font("raleway",Font.BOLD,20));
        pincode.setBounds(100,590,300,30);
        add(pincode);

        ayes = new JRadioButton("YES");
        ayes.setBounds(325,590,50,30);
        ayes.setBackground(Color.WHITE);
        add(ayes);
        ano = new JRadioButton("NO");
        ano.setBounds(400,590,50,30);
        ano.setBackground(Color.WHITE);
        add(ano);

        ButtonGroup agroup = new ButtonGroup();
        agroup.add(ayes);
        agroup.add(ano);



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
        new signUpTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sreligion  = religionBox.getSelectedItem().toString();
        String scategory = categoryBox.getSelectedItem().toString();
        String sincome = incomeBox.getSelectedItem().toString();
        String seducation = educationBox.getSelectedItem().toString();
        String soccupation = occupationBox.getSelectedItem().toString();
        String seniorcitizen = null;
        if(syes.isSelected()){
            seniorcitizen = "YES";
        }else if(sno.isSelected()){
            seniorcitizen = "NO";
        }

        String existingaccount = null;
        if(ayes.isSelected()){
            existingaccount = "YES";
        }else if(ano.isSelected()){
            existingaccount = "NO";
        }

      
       String span = panTextField.getText();
       String sadhar = adharTextField.getText();
       

       try{
            
                conn c = new conn();
                String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);


                setVisible(false);
                new signUpThree(formno);
          
            }catch(Exception b){
        System.out.println(b);
       }

    }
}