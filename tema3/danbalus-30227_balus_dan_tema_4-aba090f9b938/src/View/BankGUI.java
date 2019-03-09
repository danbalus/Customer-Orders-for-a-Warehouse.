
package View;

import Model.Bank;
import Model.Person;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

/**
 * @version mai 2017
 * @author Dan
 */
public class BankGUI extends JFrame{
    
	ArrayList<String> id = null;
	private static final long serialVersionUID = 358073909179566788L;
	private JPanel panelCentral;
    private JPanel pnSus;
    private JScrollPane scroolPanelJos;
    
    private int nrAles;
    
    private ButtonGroup bgroup = new ButtonGroup();
    
    private JRadioButton radio1 = new JRadioButton("Arata toate persoanele");
    private JRadioButton radio2 = new JRadioButton("SArata toate conturile");

    double balance;
    private JButton butonInapoi = new JButton("Inapoi");
    private JButton butonSterge1 = new JButton("Sterge");
 
    private JTable tablou;
    
    private DefaultTableModel defTableModel;
    
    public BankGUI() {
        setTitle("Fereastra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 700));
        
        setVisible(false);
    }
    
    public void init(Bank bank){
		panelCentral = new JPanel();
		pnSus = new JPanel();
		// pnJos = new JPanel();
		scroolPanelJos = new JScrollPane();
		JPanel panel;
        setContentPane(panelCentral);
        panelCentral.setLayout(new GridLayout(2, 1));
        panelCentral.add(pnSus);
        panelCentral.add(scroolPanelJos);
        bgroup.add(radio1);
   
                
        pnSus.setLayout(new GridLayout(4, 1));
        //pnJos.setLayout(new GridLayout(1,1));
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(radio1);
        panel.add(butonSterge1);
        panel.add(new JLabel());
        pnSus.add(panel);   
        butonSterge1.setEnabled(false);
        pack();
        setLocationRelativeTo(null);  
        setVisible(true);
        showJos(bank, false);
    }
    
	public void showJos(Bank bank, boolean fortat) {
		int nrVechiAles = nrAles;
		nrAles = 0;
		if (radio1.isSelected())
			nrAles = 1;
		else if (radio2.isSelected())
			nrAles = 2;
		nrAles = 3;
		if (nrAles == nrVechiAles)
		
		butonSterge1.setEnabled(false);
	
		tablou = new JTable();
		if (nrAles == 0)
			return;
		repaint();

		if (nrAles == 1) 
		{
			butonSterge1.setEnabled(true);

			ArrayList<Object[]> lista = bank.getPersons();
			String[] strg = new String[]{ "ID Persoana", "Data Creare", "Prenume", "Nume", "Tara", "Parola", "Numar conturi" };
			defTableModel = new DefaultTableModel(new Object[][] {},strg);
			tablou.setModel(defTableModel);
			for (int i = 0; i < lista.size(); i++)
			{
				defTableModel.addRow(lista.get(i));
			}

		} 
		else if (nrAles == 2) 
		{
			
			String[] strg = new String[]{ "ID Account", "Data Creare","Balanta", "Tip Account", "Dobanda Obtinuta", "Suma Cheltuita", "ID Persoana", "Nume Persoana"};
			ArrayList<Object[]> lista = bank.getAccounts();
			defTableModel = new DefaultTableModel(new Object[][] {},strg);
			tablou.setModel(defTableModel);
			for (int i = 0; i < lista.size(); i++) 
			{
				defTableModel.addRow(lista.get(i));
			}

		} 
		else
		{
			String[] strg = new String[] { "Data", "Account 1", "Persoana 1", "Account 2", "Persoana 2", "Suma" };
			ArrayList<Object[]> tranz = bank.getTranzactions();
			defTableModel = new DefaultTableModel(new Object[][] {},strg);
			tablou.setModel(defTableModel);
			for (int i = 0; i < tranz.size(); i++) 
			{
				defTableModel.addRow(tranz.get(i));
			}

		}

		scroolPanelJos.setViewportView(tablou);
		setPreferredSize(getSize());
		pack();
	}
    
    public void adaugaListenerBtnBack(ActionListener a){
        butonInapoi.addActionListener(a);
    } 
    
    public void adaugaListenerBtnRemove1(ActionListener a){
        butonSterge1.addActionListener(a);
    }
    

    
    public void adaugaWindowListener(WindowListener w){
        this.addWindowListener(w);
    }
    
    public void adaugaRadioListener(ChangeListener c){
        radio1.addChangeListener(c);
        radio2.addChangeListener(c);

    }
    
	public void showError(int id) {
	
	}

    public String getStringId(){
        return (String)defTableModel.getValueAt(tablou.getSelectedRow(), 0);
    }
    public int getIntId(){
        return (int)defTableModel.getValueAt(tablou.getSelectedRow(), 0);
    }


	public Person readPerson(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	public void stergCont(String s) {
		// TODO Auto-generated method stub
		
	}

	public void Account() {
	    balance = 0.0;
	}

	// Instance methods

	public void setBalance() {
	    balance = Math.random() * 1000;
	    balance = Math.round((balance * 100.0)+.5) / 100.0;
	}
	
	public void deposit(double amount) {
	    balance = getBalance() + amount;
	}

	public void withdraw(double amount) {
	    balance = balance - amount;
	}

	public double getBalance() {
	    balance = Math.round((balance * 100.0)+.5) / 100.0;
	    return balance;
	}

	public void close() {
	    balance = 0.0;
	}

	public boolean readlogin(String text, String text2) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<String> getinfoCont(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getidConturi(String string) {
		
		
		return id;
	}
    
}
