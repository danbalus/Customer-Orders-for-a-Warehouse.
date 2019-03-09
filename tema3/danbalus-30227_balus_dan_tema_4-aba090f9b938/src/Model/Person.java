/**
 * Clasa care salveaza o persoana cu urmatoarele date:
 * id-ul unic al persoanei, primul nume, al doilea nume, tara, parola,
 * nr de conturi pe care le detine, data crearii persoanei.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * @version mai 2017
 * @author Dan
 */
public class Person implements Serializable, Observer{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2584289159851341501L;
	private String id, prenume, nume, tara, parola;
    private int nrAcc;
    private Date data;
    private String adresa, email,nrTel;
    private int varsta;
    /**
     * Constructorul care creeaza o persoana
     * @param id id-ul unic de tip String
     * @param pass parola acelei persoane
     * @param nrAcc numarul de conturi initiale
     */
    public Person(String id, String pass, int nrAcc){
        this.id = id;
        this.nrAcc = nrAcc;
        prenume = "";
        nume = "";
        tara = "";
        data = new Date();
        parola = pass;
    }
    public Person(String id, String pass, int nrAcc, String adresa, String email, String pass1, String nrTel, int varsta){
    	 this.id = id;
         this.nrAcc = nrAcc;
         prenume = "";
         nume = "";
         tara = "";
         data = new Date();
         parola = pass1;
    
       this.adresa = adresa;
       this.email =email;
       this.nrTel = nrTel;
       this.varsta = varsta;
    }
    
    /**
     * Constructorul 2 de creare a unei persoane
     * @param id id-ul unic al persoanei
     * @param pass parola.
     */
    public Person(String id, String pass){
        this(id, pass, 1);
    }

    public String getId(){
        return id;
    }
    
    public String getPrenume(){
        return prenume;
    }
    
    public String getNume(){
        return nume;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getEmail() {
        return email;
    }

    public int getVarsta() {
        return varsta;
    }
    public String getNrTel() {
        return nrTel;
    }
    public String toString() {
		return " [person: idC=" + id+ " numeC=" + nume + " adresaC=" + adresa + " emailC=" + email+ " varstaC=" + varsta + " nrtelC="+nrTel+"] " ;}
	
    public String getTara(){
        return tara;
    }
    
    public String getPassword(){
        return parola;
    }
    
    public Date getDate(){
        return data;
    }
    
    public int getNrAcc(){
        return nrAcc;
    }
    
    public void setPrenume(String pren){
        prenume = pren;
    }
    public void setNume(String num){
        nume = num;
    }
    public void setTara(String t){
        tara = t;
    }
    public void setPassword(String pass){
        parola = pass;
    }
    
    public void addNrAcc(){
        nrAcc++;
    }
    
    public void decNrAcc(){
        nrAcc--;
    }

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Ma numesc " + nume +" " 
				+ prenume + " am id-ul: " + id +" si am suferit modificari");
		
	}
    
    
}
