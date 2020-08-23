
/**
 * Write a description of class login here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.imageio.*;
import java.awt.*;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class login extends JFrame
{
    private JButton login,register,exit;
    private JLabel welcome,username,password;
    private JTextField textName;
    private JPasswordField passwordField;
    private JRadioButton lecture, student;
    private ButtonGroup radioGroup;
    private boolean lecture1;
    private boolean student1;
    
    private String name;
    private String stnumber;
    private int points;
    private String player;
    public login()
    {
        super("login");
        setLayout(null);
        ButtonHandler h= new ButtonHandler();

        welcome= new JLabel("Do you want to creat a new Account? Click here ");
        welcome.setBounds(50,50,400,30);
        add(welcome);

        lecture = new JRadioButton("Lecture",false);
        add(lecture);
        lecture.setBounds(350,130,100,50);
        lecture.setBackground(Color.green);

        student = new JRadioButton("Student",false);
        add(student);
        student.setBounds(450,130,150,50);
        student.setBackground(Color.green);

        RadioButtonHandler check = new RadioButtonHandler();
        lecture.addItemListener(check);
        student.addItemListener(check);

        radioGroup = new ButtonGroup();
        radioGroup.add(lecture);
        radioGroup.add(student);

        username = new JLabel("UserName");
        textName = new JTextField(20);
        username.setBounds(200,200,80,30);
        textName.setBounds(300,200,150,25);
        add(username);
        add(textName);

        password = new JLabel("Password");
        passwordField = new JPasswordField(null);
        passwordField.addActionListener( h );
        password.setBounds(200,230,80,30);
        passwordField.setBounds(300,230,150,25);
        add(password);
        add(passwordField);

        login = new JButton("Login");
        login.setBounds(350,350,80,30);
        login.addActionListener(h);
        add(login);

        register = new JButton("Register");
        register.setBounds(320,50,150,30);
        register.addActionListener(h);
        add(register);
        
        exit = new JButton("Exit");
        exit.setBounds(340,10,80,30);
        exit.addActionListener(h);
        add(exit);
    }

    private class RadioButtonHandler implements ItemListener
    {    
        public void itemStateChanged(ItemEvent event)
        {
            if (lecture.isSelected()== true)
            {
                lecture1 = true;
            }
            if (student.isSelected()== true)
            {
                student1 = true;
            }

        }
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String password = "Java";
            boolean password1 = false;

            if (e.getSource() == login)
            {
                if ((student1 == true))
                {
                    Student learners = new Student(name,stnumber,player,points);
                    JOptionPane.showMessageDialog(null,"You are logged in as a student");
                    Loggedin in = new Loggedin();
                    in.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    in.setSize(900, 700);
                    in.setVisible(true);
                    dispose();
                }
                else if ((lecture1 == true))
                {
                    Lecture teachers = new Lecture(name,stnumber,player);
                    JOptionPane.showMessageDialog(null,"You are logged in as a lecture");
                    Details my = new Details();
                    my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    my.setSize(1500, 1000);
                    my.setVisible(true);
                    dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Access denied!");
                }
                /*Loggedin my = new Loggedin();
                my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                my.setSize(900, 700);
                my.setVisible(true);
                dispose();*/

            }
            if (e.getSource() == register)
            {
                Register_Form reg = new Register_Form();
                reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reg.setSize(900, 700);
                reg.setVisible(true);
                dispose();

            }
            if(e.getSource() == exit)
            {
                int exit = JOptionPane.showConfirmDialog(null,"Do you want exit?"," Exit Message", JOptionPane.YES_NO_OPTION);
                if (exit == JOptionPane.YES_OPTION)
                {
                    JOptionPane.showMessageDialog(null, "Have a great day.");
                    System.exit(0);
                }
            }
        }
    }
}
