package Controller;

import Model.Bank;
import Model.Person;
import View.AccountGUI;
import View.BankGUI;
import View.LogGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LogListener {
    
    private LogGUI gui;
    private AccountGUI guiAcc;
    
    private Bank bank;
    
  
    public LogListener(LogGUI g, BankGUI gBank, AccountGUI gAcc, Bank b){
        gui = g;
        bank = b;
        guiAcc = gAcc;
        g.addBtBankAcList(acLisButAdmin);
        g.addBtAccountLoginAcList(acLisButAccountL);
        g.addBtAccountCreateAcList(acLisButAccountC);
        g.adaugaWindowListener(windowListener);
    }

    private WindowListener windowListener = new WindowListener(){
        public void windowOpened(WindowEvent e) {}
        public void windowClosing(WindowEvent e) {
            bank.saveBank();
        }
   
    };
    
	private ActionListener acLisButAccountL = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String accountDataGot[] = gui.getAccountLog(2);
			if (!"0".equals(accountDataGot[0])) 
			{
				gui.setLoginMessage(Integer.parseInt(accountDataGot[0]));
				return;
			}
			
		}
	};
    
    
	private ActionListener acLisButAccountC = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String log[] = gui.getAccountLog(1);
			if (!"0".equals(log[0])) {
				gui.setLoginMessage(Integer.parseInt(log[0]));
				return;
			}
			
		}

	};
    
    private ActionListener acLisButExit = new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            bank.saveBank();
            System.exit(0);
        }

    };

	private ActionListener acLisButAdmin = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String log[] = gui.getAccountLog(3);
			if (!"0".equals(log[0]))
			{
				gui.setLoginMessage(Integer.parseInt(log[0]));
				return;
			}
			
		}

	};    
    
    
}
