package View;


import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Bank;

public class FereastraCont extends JFrame{
    private JTextField bani =  new JTextField("",10);
    private JTextField chel =  new JTextField("",10);
    private JTextField addc =  new JTextField("",10);
    private JTextField exep = new JTextField("",10);
    private JTextField tip = new JTextField("",10);
    private JLabel info1 = new JLabel("Bani :");
    private JLabel info2 = new JLabel("Total cheltuit :");
    private JLabel info3 = new JLabel("Adauga in cont :");
    private JLabel info4 = new JLabel("Executa plata  :");
    private JLabel info5 = new JLabel("Tip Cont :");
    private JButton ok1=new JButton("OK");
    private JButton ok2=new JButton("OK");
    private String selected;
    private Bank bank;
    private JFrame frame;
    /**
     * se seteaza selected cu parametrul s
     * @param s 
     */
    public void setselected(String s){
        this.selected=s;
    }
    /**
     * se seteaza valorile pentru a putea fi ulterior folosite
     */
    public void setvalori(){
      ArrayList<String> list = new ArrayList<String>();
   
        bani.setText(list.get(1));
        chel.setText(list.get(2));
        tip.setText(list.get(3));
    }
    public FereastraCont(Bank b){
        this.bank=b;
        
        this.setTitle("Cont");
        setPreferredSize(new Dimension(420,350));
        setLayout(null);
        setResizable(false);
        info1.setBounds(10,20,50,30);
        add(info1);
        bani.setBounds(140,20,150,30);
       
        add(bani);
        info2.setBounds(10,80,100,30);
        add(info2);
        chel.setBounds(140,80,150,30);
        
        add(chel);
        
        info3.setBounds(10,140,100,30);
        add(info3);
        addc.setBounds(140,140,150,30);
        add(addc);
        ok1.setBounds(300,140,80,30);
        add(ok1);
        
        info4.setBounds(10,200,100,30);
        add(info4);
        exep.setBounds(140,200,150,30);
        add(exep);
        
        info5.setBounds(10,260,100,30);
        add(info5);
       
        tip.setEditable(false);
        tip.setBounds(140,260,150,30);
        add(tip);
            
        System.out.println(selected);
        ok2.setBounds(300,200,80,30);
        add(ok2);
    }
    /**
     * actiunea primului buton de ok
     */
    public void actok1(){  
        if (addc.getText()==null) {
             JOptionPane.showMessageDialog(frame, "introduceti un nr in campul din stanga acestui buton" );
      
        }
         ArrayList<String> list = new ArrayList<String>();
     
         String s=addc.getText();
       
         setvalori();
         repaint();
    }
    /**
     * actiunea butonului ok2
     */
    public void actok2(){
         if (exep.getText()==null) {
             JOptionPane.showMessageDialog(frame, "introduceti un nr in campul din stanga acestui buton" );
      
        }
          ArrayList<String> list = new ArrayList<String>();
     
         String s=exep.getText();
        
         setvalori();
         repaint();
    }
    /**
     * adaugarea ascultatorilor
     * @param o1 
     */
     public void addListenerok1(ActionListener o1){
              ok1.addActionListener(o1);
          }
      public void addListenerok2(ActionListener o2){
              ok2.addActionListener(o2);
          }

}
