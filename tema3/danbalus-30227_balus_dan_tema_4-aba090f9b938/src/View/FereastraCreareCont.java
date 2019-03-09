package View;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Bank;

public class FereastraCreareCont extends JFrame {
    private JButton ok =new JButton("OK");
    private JTextField name = new  JTextField("",10);
    private JTextField user = new  JTextField("",10);
    private JTextField pass = new JTextField("",10);
    private JTextField pass2 = new JTextField("",10);
    private JComboBox combo;
    private String course[] = {"Saving Account","Spending Account"};
    private JLabel info1 = new JLabel("Nume");
    private JLabel info2 = new JLabel("User :");
    private JLabel info3 = new JLabel("Pass :");
    private JLabel info4 = new JLabel("Confirm Pass :");
    private JLabel info5 = new JLabel("Tip cont");
    private Bank bank;
    private JFrame frame;
    
    public FereastraCreareCont(Bank b){
        this.bank=b;
        this.setTitle("Creare Cont");
        setPreferredSize(new Dimension(450,450));
        setLayout(null);
        setResizable(false);
        info1.setBounds(10,20,50,30);
        add(info1);
        name.setBounds(140,20,150,30);
        add(name);
        
        info2.setBounds(10,80,50,30);
        add(info2);
        user.setBounds(140,80,150,30);
        add(user);
        
        info3.setBounds(10,140,50,30);
        add(info3);
        pass.setBounds(140,140,150,30);
        add(pass);
        
        info4.setBounds(10,200,100,30);
        add(info4);
        pass2.setBounds(140,200,150,30);
        add(pass2);
        
        info5.setBounds(10,260,100,30);
        add(info5);
        combo= new JComboBox(course);
        combo.setBounds(140,260,150,30);
        add(combo);
        
        ok.setBounds(70,320,70,40);
        add(ok);
       
    }
    /**
     * actiunea butonului ok
     * 
     */
    public void actok(){
        Integer a= new Integer(combo.getSelectedIndex());
       bank.createAccount(name.getText(), user.getText(), 1);
       if((name.getText().equals(""))||(user.getText().equals(""))||(pass.getText().equals("")))
           JOptionPane.showMessageDialog(frame, " Introduceti in toate campurile datele corespunzatoare" );
         else  if (!(pass.getText().equals(pass2.getText()))){
           JOptionPane.showMessageDialog(frame, " Parola 1 nu corespunde cu parola 2 , reincercati!" ); 
         }
       
       else{
       name.setText("");
       user.setText("");
       pass.setText("");
       this.setVisible(false);}
    }
    /**
     * adaugarea ascultatorului pentru butonul ok
     * @param b1 
     */
     public void addListenerok(ActionListener b1){
              ok.addActionListener(b1);
          }

}
