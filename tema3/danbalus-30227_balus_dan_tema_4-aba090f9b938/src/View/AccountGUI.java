package View;

import Model.*;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;

public class AccountGUI extends JFrame{
    
  
	private static final long serialVersionUID = 1089062416294903180L;

    private JTextField txtPrenume = new JTextField();
    private JTextField txtNume = new JTextField();
    private JTextField txtTara = new JTextField();
    private JTextField txtExtrageri = new JTextField();
    private JTextField txtDepuneri = new JTextField();
   
    private JPasswordField pass1 = new JPasswordField();
   
    
    private JButton btBack = new JButton("Inapoi");
    private JButton btSet = new JButton("Seteaza");
    private JButton btNewAcc1 = new JButton("Creeaza un Saving Account");
    @SuppressWarnings("unused")
	private JButton btNewAcc2 = new JButton("Creeaza un Spending Account");

    private JButton btOKAdauga = new JButton("OK");
    private JButton btObtineDobanda = new JButton("Obtine Dobanda");
    
    private JComboBox<String> coBox1 = new JComboBox<String>();
  
    private JComboBox<String> coBoxDepuneri = new JComboBox<String>();

    
    public AccountGUI() {
        setTitle("Freastra Account");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 700));
        
        setVisible(false);
    }
    
	public void init(Bank b) {
		JFrame frame = (JFrame) new Frame();
		frame.getContentPane().removeAll();
		pack();

		setLocationRelativeTo(null);
		setVisible(true);

	}

	
    public String[] getPersonData(){
        String textStringBox[] = new String[5];
        textStringBox[0] = txtPrenume.getText();
        textStringBox[1] = txtNume.getText();
        textStringBox[2] = txtTara.getText();
        textStringBox[3] = String.valueOf(pass1.getPassword());
      
        return textStringBox;
    }
  
	public void setPersonData(String s[]) {
		if (s[0].compareTo("") != 0)
			txtPrenume.setText(s[0]);
		if (s[1].compareTo("") != 0)
			txtNume.setText(s[1]);
		if (s[2].compareTo("") != 0)
			txtTara.setText(s[2]);
		pass1.setText("");
	
	}
    
	public void adaugaListenerBtnBack(ActionListener a) {
		btBack.addActionListener(a);
	}

	public void adaugaListenerBtnSet(ActionListener a) {
		btSet.addActionListener(a);
	}

	public void adaugaListenerBtnNewAcc1(ActionListener a) {
		btNewAcc1.addActionListener(a);
	}


	public void adaugaListenerBtnOKAdauga(ActionListener a) {
		btOKAdauga.addActionListener(a);
	}




	public void addCoBox1ItLis(ItemListener it) {
		coBox1.addItemListener(it);
	}

	public void addCoBoxDepune(ItemListener it) {
		coBoxDepuneri.addItemListener(it);
	}
    
    public void adaugaWindowListener(WindowListener w){
        this.addWindowListener(w);
    }

	public void scrieContDepuneri() {
		String z = "";
		String s = (String) coBoxDepuneri.getSelectedItem();
			z = s.substring(0, 6);
		txtAltCont.setText(z);
	}
    
	public int getAccount(Bank b) {
		
			String textStringBox = (String) coBox1.getSelectedItem();
			textStringBox = textStringBox.substring(0, 6);
			int nr = Integer.parseInt(textStringBox);
			Account a = b.cautareAcount(nr);
			return a.getId();
		
	}


	public void showBalances(Account acc) {
		if (acc.getTipAccount() == 1)
		{
			SavingAccount savAcc = (SavingAccount) acc;
			txtT1I1.setText(String.valueOf(acc.getBalance() - savAcc.getTotalInterests()));
			txtT1I2.setText(String.valueOf(savAcc.getTotalInterests()));
			txtExtrageri.setText("");
		}
		else 
		{
			SpendingAccount sa = (SpendingAccount) acc;
	
			txtDepuneri.setText("");
			txtPlati.setText("");
			txtAdauga.setText("");
		}
	}

}
