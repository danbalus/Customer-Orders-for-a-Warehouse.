package Controller;

import Model.Account;
import Model.Bank;
import Model.Person;
import View.BankGUI;
import View.LogGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @version mai 2017
 * @author Dan
 */
public class BankListener {

    private LogGUI guiLog;
    private BankGUI guiBank;
    private Bank bank;

    /**
     * Constructorul
     * @param log Obiect de tip LogGUI
     * @param gui Obiect de tip BankGUI
     * @param bk Obiect de tip Bank
     */
    public BankListener(LogGUI log, BankGUI gui, Bank bk) {
        guiLog = log;
        guiBank = gui;
        bank = bk;
        gui.adaugaWindowListener(windowListener);
        gui.adaugaListenerBtnRemove1(actionListenerStergeCrAcc);
     
        gui.adaugaListenerBtnBack(actionListenerExit);
        gui.adaugaRadioListener(adaugareChangeListener);
    }
   
    private WindowListener windowListener = new WindowListener(){
        public void windowClosing(WindowEvent arg0) {
            bank.saveBank();
        }
        public void windowOpened(WindowEvent arg0) {}
        public void windowClosed(WindowEvent arg0) {}
        public void windowIconified(WindowEvent arg0) {}
        public void windowDeiconified(WindowEvent arg0) {}
        public void windowActivated(WindowEvent arg0) {}
        public void windowDeactivated(WindowEvent arg0) {}
    };
    
 
    
    private ActionListener actionListenerStergeCrAcc = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String id = guiBank.getStringId();
                Person pers = bank.readPerson(id);
                bank.removePerson(pers);
            } catch (Exception ex) {
                guiBank.showError(1);
            }
            guiBank.showJos(bank, true);
        }
    };
    
    @SuppressWarnings("unused")
	private ActionListener actionListenerStergeLogAcc = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = guiBank.getIntId();
                Account acc = bank.cautaAccount(id);
                bank.removeAccount(acc);
            } catch (Exception ex) {
                guiBank.showError(1);
            }
            guiBank.showJos(bank, true);
        }
    };
    
    @SuppressWarnings("unused")
	private ActionListener actionListenerStergeLogAdmin = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String date = guiBank.getStringId();
                bank.removeTranzaction(date);
            } catch (Exception ex) {
                guiBank.showError(1);
            }
            guiBank.showJos(bank, true);
        }
    };
    
    @SuppressWarnings("unused")
	private ActionListener actionListenerStergeTotLogAdmin = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                bank.removeAllTranzaction();
            } catch (Exception ex) {
                guiBank.showError(1);
            }
            guiBank.showJos(bank, true);
        }
    };
    
    private ActionListener actionListenerExit = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            guiLog.setVisible(true);
            guiBank.setVisible(false);
        }
    };
    

    private ChangeListener adaugareChangeListener = new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
            guiBank.showJos(bank, false);
        }
    };
}
