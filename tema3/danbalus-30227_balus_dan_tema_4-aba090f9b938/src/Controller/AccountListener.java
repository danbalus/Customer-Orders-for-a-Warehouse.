package Controller;

import Model.*;
import View.AccountGUI;
import View.LogGUI;
import java.awt.event.*;

/**
 * @version mai 2017
 * @author Dan
 */
public class AccountListener {
	private LogGUI logGui;
	private AccountGUI accGui;
	private Bank bankk;

	/**
	 * Constructorul
	 * 
	 * @param gLog
	 *            obiect de tip LogGUI
	 * @param g
	 *            obiect de tip AccounGUI
	 * @param b
	 *            obiect de tip Bank
	 */
	public AccountListener(LogGUI gLog, AccountGUI g, Bank b) {
		logGui = gLog;
		accGui = g;
		bankk = b;
		g.adaugaWindowListener(windLsn);
		g.adaugaListenerBtnBack(acLisButExit);
		g.adaugaListenerBtnSet(acLisButSet);
		
		
	}

	/**
	 * atunci cand inchidem fereastra.
	 */
	private WindowListener windLsn = new WindowListener() {
		public void windowClosing(WindowEvent arg0) {
			bankk.saveBank();
		}

		public void windowOpened(WindowEvent arg0) {
		}

		public void windowClosed(WindowEvent arg0) {
		}

		public void windowIconified(WindowEvent arg0) {
		}

		public void windowDeiconified(WindowEvent arg0) {
		}

		public void windowActivated(WindowEvent arg0) {
		}

		public void windowDeactivated(WindowEvent arg0) {
		}
	};

	private ActionListener acLisButNewAcc1 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			bankk.createAccount("", null, 1);
			
		
		}

	};
	private ActionListener acLisButNewAcc2 = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			bankk.createAccount("", null, 2);
		
	
		}

	};
	
		public void actionPerformed(ActionEvent e){
			int ok = 0;
			bankk.cautareAcount("");
		};
		
	
	private ActionListener acLisButExit = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			logGui.setVisible(true);
			accGui.setVisible(false);
		}

	};

	private ActionListener acLisButSet = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String prsonalDataGot[] = accGui.getPersonData();
			
			String personalData[] = { "", "", "" };
			
		

			accGui.setPersonData(personalData);
		}

	};

	private ItemListener addItemListener1 = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == 1) {
		
			}
		}
	};

	private ItemListener addItemListenerDepune = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == 1) {
				accGui.scrieContDepuneri();
			}
		}
	};

	private int[] verificaTranzactie(String suma[], int tipAcc1, int tipAcc2) {
		int data[] = { -1, 0, 0, 0 };
		int id = 0, id2 = 0;
		boolean eroare = false;
		int nr, nr2;
		

		
			nr = Integer.parseInt(suma[0]);
			Account acc = bankk.cautaAccount(nr);
			id = acc.getId();
			
			if ((tipAcc1 == 1) && (acc.getTipAccount() != 1))
				eroare = true;
			if ((tipAcc1 == 2) && (acc.getTipAccount() != 2))
				eroare = true;

			
			nr2 = Integer.parseInt(suma[2]);// destinatarul
			Account a2 = bankk.cautaAccount(nr2);
			id2 = a2.getId();
			
			if ((tipAcc2 == 1) && (a2.getTipAccount() != 1))
				eroare = true;
			if ((tipAcc2 == 2) && (a2.getTipAccount() != 2))
				eroare = true;
			
		
		data[1] = id;
		data[3] = id2;

		nr = 0;
		
			nr = Integer.parseInt(suma[1]);
	
		data[2] = nr;
		data[0] = 0;
		return data;
	}

	private ActionListener acLisButAddInterest = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
				int id = accGui.getAccount(bankk);
				Account acc = bankk.cautaAccount(id);
				SavingAccount sa = (SavingAccount) acc;
				bankk.addDobanda(sa);
				accGui.showBalances(acc);
				
			
		}

	};

	private ActionListener acLisButOKAdauga = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int nr[] = verificaTranzactie(accGui.getBaniAdauga(), 2, 0);
			
			Account a = bankk.cautaAccount(nr[1]);
			a.setBalance(a.getBalance() + nr[2]);
			accGui.showBalances(a);
			bankk.makeTranzaction(bankk.cautaAccount(nr[1]), bankk.cautaAccount(nr[3]), nr[2]);
		}
	};
	
	private ActionListener acLisButOKPlateste = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int nr[] = verificaTranzactie(accGui.getBaniAdauga(), 2, 0);
			if (nr[0] == -1)
				return;
			Account acc = bankk.cautaAccount(nr[1]);
			int bani = acc.getBalance();
		

			acc.setBalance(acc.getBalance() - nr[2]);
			SpendingAccount sa = (SpendingAccount) acc;
			sa.addBalanceSpended(nr[2]);
			accGui.showBalances(acc);
			bankk.makeTranzaction(bankk.cautaAccount(nr[1]), bankk.cautaAccount(nr[3]), -nr[2]);
		}

	};
	private ActionListener acLisButOKDepune = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int nr[] = verificaTranzactie(accGui.getBaniDepuneri(), 2, 0);
		
			Account a = bankk.cautaAccount(nr[1]);
			int bani = a.getBalance();
		

			Account a2 = bankk.cautaAccount(nr[3]);
			a2.setBalance(a2.getBalance() + nr[2]);

			a.setBalance(a.getBalance() - nr[2]);
			accGui.showBalances(a);
			bankk.makeTranzaction(bankk.cautaAccount(nr[1]), bankk.cautaAccount(nr[3]), nr[2]);
		}

	};
	private ActionListener acLisButOKExtrage = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			int nr[] = verificaTranzactie(accGui.getBaniExtrageri(), 1, 2);
			 bankk.cautaAccount(nr[1]);
			
			

			Account acc2 = bankk.cautaAccount(nr[3]);
			acc2.setBalance(acc2.getBalance() + nr[2]);

		
			bankk.makeTranzaction(bankk.cautaAccount(nr[1]), bankk.cautaAccount(nr[3]), nr[2]);
		}

	};

}
