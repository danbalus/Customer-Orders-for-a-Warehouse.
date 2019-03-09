package View;



import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 * Fereastra Administrator
 * @author Alex
 */
public class FereastraAdministrator extends JFrame {
    private JButton remove=new JButton("Remove");
    private JButton showacc=new JButton("Conturi");
    private String[] columnNames = {"Account Id","Bani","Cheltuieli","Tip cont","User",};
    private JTable table = new JTable();
    private String[][] data =new String[20][6];
    private BankGUI bank;
    private Object[][] dat={{"","","",""}};
    private JFrame frame;
    public FereastraAdministrator(){}
    public FereastraAdministrator(BankGUI b){
        this.bank=b;
        this.setTitle("Administrator");
        setPreferredSize(new Dimension(500,500));
        setLayout(null);
        setResizable(false);
        showacc.setBounds(30,20,120,40);
        add(showacc);
        remove.setBounds(200,20,120,40);
        add(remove);
       
        table.setVisible(false);
        add(table);
    }
    /**
     * actiunea butonului remove
     */
    public void actremove(){
        System.out.println("aici");
        String s=(String)table.getValueAt(table.getSelectedRow(),0);
      
        refr();
        JOptionPane.showMessageDialog(frame, "Contul "+s+" va fi sters la urmatoarea deschidere a aplicatiei!" );
        System.out.println(s);
    }
    /**
     * refresh la tabel 
     */
    public void refr(){
        ArrayList<String> idconturi = null,useri = null,info = null;//=new ArrayList<String>();
   
        int k=0;
            data[k][0]="Id contur";
            data[k][1]="Bani";
            data[k][2]="Cheltuiala";
            data[k][3]="Tip cont";
            data[k][4]="User ";
            k++;
        for( int i=0;i<useri.size();i++){
            
            data[k][0]=idconturi.get(i);
            data[k][1]=info.get(1);
            data[k][2]=info.get(2);
            if ((info.get(3)).equals("0")) data[k][3]="Saving"; else data[k][3]="Spending";
            System.out.println(useri.get(i));
            data[k][4]=useri.get(i);
            }
            
        }
      
   
    /**
     * actiunea butonului show accounts
     */
    public void actshowacc(){
        repaint();
        remove(table);
        refr();
        table = new JTable(dat,columnNames);
        table.setBounds(30,80,400,300);
        table.setVisible(true);
        add(table);
        pack();
        
    }
    /**
     * adaugarea ascultatorilor
     * @param rem 
     */
   public void addListenerremove(ActionListener rem){
              remove.addActionListener(rem);
          }
   public void addListenershowacc(ActionListener sc){
              showacc.addActionListener(sc);
          }
}
