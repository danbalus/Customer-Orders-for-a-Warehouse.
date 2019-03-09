package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import javax.swing.*;

/**
 * @version mai 2017
 * @author Dan
 */
public class LogGUI extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6433325712112893412L;
	private JButton butonAccLogin = new JButton("Logare Account");
    private JButton butonAccCreate = new JButton("Creare Account");
    private JButton butonAdmin = new JButton("Administrator");

    private JPanel panelCentral = new JPanel();
    
    public LogGUI() {
        setTitle("Fereastra Principala");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 500));
        
        setContentPane(panelCentral);
        panelCentral.setLayout(new GridLayout(7,1));
        panelCentral.add(new JLabel("Selectare:",JLabel.CENTER));
        JPanel panel;
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1, 10, 10));
        panel.add(new JLabel());
        panel.add(butonAccCreate);
        panel.add(new JLabel());
        panelCentral.add(panel);
        
        
       
        panelCentral.add(panel);
        
 
        panelCentral.add(new JLabel());
        
        pack();
        setLocationRelativeTo(null);  
        setVisible(true);
    }
    
  
    
    public String[] getAccountLog(int id){
        String[] log = new String[3];
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JTextField jTextField = new JTextField("");
        JPasswordField jPassField1 = new JPasswordField("");
        JPasswordField jPassField2 = new JPasswordField("");
       
        @SuppressWarnings("unused")
		String numeFereastra;
        @SuppressWarnings("unused")
		Object[] obj;
        if (id == 1)
        {
            label1.setText("Alege un nickname unic:");
            label2.setText("Alege o parola:");
            label3.setText("Repeta parola:");
            numeFereastra="Inregistrare account nou";
            obj = new Object[]{label1, jTextField, label2, jPassField1, label3, jPassField2};
        }
        else if (id == 2)
        {
            label1.setText("Nickname");
            label2.setText("Parola:");
            numeFereastra = "Logare Account";
            obj = new Object[]{label1, jTextField, label2, jPassField1};
        }
       
        return log;
    }
    public void addBtBankAcList(ActionListener a){
        butonAdmin.addActionListener(a);
    }
    
    public void addBtAccountLoginAcList(ActionListener a){
        butonAccLogin.addActionListener(a);
    }
    
    public void addBtAccountCreateAcList(ActionListener a){
        butonAccCreate.addActionListener(a);
    }

   
    public void setLoginMessage(int id){
		
    }

    public void adaugaWindowListener(WindowListener w){
        this.addWindowListener(w);
    }
    
}
