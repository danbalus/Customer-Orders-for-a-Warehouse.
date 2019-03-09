package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Bank;
import Model.Person;


public class FereastraAutentificare extends JFrame{
private JButton login =new JButton("Log In");
private JTextField user = new  JTextField("",10);
private JTextField pass = new JTextField("",10);
private JLabel info1 = new JLabel("User :");
private JLabel info2 = new JLabel("Pass :");
private Person pers;
private FereastraCont cont;
private BankGUI bank;
private JFrame frame,frame2;
private BankGUI b;
    public String getuser(){
        return user.getText();
    }
    public String getpass(){
        return pass.getText();
    }
    public FereastraAutentificare(){}
    public FereastraAutentificare(BankGUI b,Person per,FereastraCont co){
    this.b = b;
	this.pers=per;
    this.cont=co;
    this.bank=b;
    this.setTitle("Log In");
    setPreferredSize(new Dimension(250,200));
    setLayout(null);
    setResizable(false);
    info1.setBounds(10,20,50,30);
    add(info1);
    user.setBounds(80,20,100,30);
    add(user);
    info2.setBounds(10,60,50,30);
    add(info2);
    pass.setBounds(80,60,100,30);
    add(pass);
    login.setBounds(80,100,70,40);
    add(login);
 
}
    /**
     * actiunea butonului de Login
     */

    /**
     * adaugarea ascultatorului pentru butonul de login
     * @param b1 
     */
     public void addListenerLogin(ActionListener b1){
              login.addActionListener(b1);
          }
   
}
