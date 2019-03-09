import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Bank implements BankProc{

	
	private Nod hashtable [];
	
	static protected class Nod
	{
		Acounts acount;
		Nod next;
		Nod prev;
		
		public Nod(Acounts acount)
		{
			this.acount=acount;
		}
	}
	
	public Bank()
	{
		hashtable = new Nod[11];
		this.incarcare();
		
	}
	
	public Nod[] getHashTabel()
	{
		return hashtable;
	}
	
	public int hashFunction(String id)
	{
		int suma=0;
		for (int i=0;i<id.length();i++)
		{
			suma=suma+id.charAt(i);
		}
		return suma%11;
	}
	

	public void addAcount(Acounts acount) {
		
		assert (acount!=null) : "addAcount null exception ";
		assert (this.cautareAcount(acount.getId())==null) : "exista contul";
	    assert  isWellFormed();
		
		String id = acount.getId();
		int n=this.hashFunction(id);
		Nod nod = new Nod(acount);
		if (hashtable[n]==null)
		{
			hashtable[n]=nod;
			nod.next=null;
			nod.prev=null;
		}
		else
		{
			nod.next=hashtable[n];
			nod.prev=null;
			hashtable[n].prev=nod;
			hashtable[n]=nod;
		}
		
		
		assert hashtable[n]==nod;
		assert isWellFormed();
	}
	
	public String afisare()
	{
		String s="";
		for (int i=0;i<11;i++)
			if (hashtable[i]!=null)
			{
				Nod n=hashtable[i];
				while(n!=null)
				{
					//System.out.println(n.acount.getPerson().getNume()+" "+n.acount.getSuma());
					s=s.concat(n.acount.getClass().getName()+" "+n.acount.getPerson().getId()+" "+n.acount.getPerson().getNume()+" "+n.acount.getPerson().getPrenume()+" "+n.acount.getId()+" "+Integer.toString(n.acount.getSuma())+"\n");
					n=n.next;
				}
			}
		return s;
	}

	public void removeAcount(Acounts acount) {
		
		assert acount!=null;
		assert this.cautareAcount(acount.getId())!=null;
		assert isWellFormed();
		
		Nod n1 = cautareAcount(acount.getId());
		Nod n2=hashtable[hashFunction(acount.getId())];
		if (n1.equals(n2))
		{
			hashtable[hashFunction(acount.getId())]=n1.next;
			if (n1.next!=null)
				hashtable[hashFunction(acount.getId())].prev=null;
		}
		else
		{
			n1.prev.next=n1.next;
			if (n1.next!=null)
				n1.next.prev=n1.prev;
			n1.prev=null;
			n1.next=null;
		}
		
		assert this.cautareAcount(acount.getId())==null;
		assert isWellFormed();
	}

	
	public void editAcount(Acounts acount,int suma) {
		
		assert acount!=null;
		assert this.cautareAcount(acount.getId())!=null : "contul nu exista";
		assert isWellFormed();
		
		Nod n =cautareAcount(acount.getId());
		n.acount.depozit(suma);
		
		assert this.cautareAcount(acount.getId())!=null;
		assert isWellFormed();
	}
	
	public Nod cautareAcount(String idCont)
	{
		Nod n=hashtable[hashFunction(idCont)];
		while (n!=null)
		{
			if (idCont.equals(n.acount.getId())==true)
				return n;
			n=n.next;
		}
		return null;
	}
	
	private void incarcare()
	{
		try{
			FileInputStream fstream = new FileInputStream("textfile.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine=br.readLine())!=null)
			{
				String[] str;
				str=strLine.split(" ");
				if (str[0].equals("SavingAcount"))
					this.addAcount(new SavingAcount(new Person(str[1],str[2],str[3]),str[4],Integer.parseInt(str[5])));
				else
					this.addAcount(new SpendingAcount(new Person(str[1],str[2],str[3]),str[4],Integer.parseInt(str[5])));
			}
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	private boolean isWellFormed()
	{
		for (int i=0;i<11;i++)
		{
			Nod tail=hashtable[i];
			if (tail!=null)
				while (tail.next!=null)
					tail=tail.next;
			Nod head=hashtable[i];
			for (Nod p = head;p!=null;p=p.next)
			{
				if (p.prev!=null)
				{
					if (p.prev.next!=p)
						return false;
				}
				else
					if (head!=p)
							return false;
				if (p.next!=null)
				{
					if (p.next.prev!=p)
						return false;
				}
				else
					if (tail!=p)
						return false;
			}
		}
		
		
		for (int i=0;i<11;i++){
			Nod tail=hashtable[i];
			if (tail!=null)
				while (tail.next!=null){
					if (hashFunction(hashtable[i].acount.getId())==hashFunction(tail.acount.getId()))
						tail=tail.next;
					else
						return false;
				}
		}
		
		
		for (int i=0;i<10;i++)
			for (int j=i+1;j<11;j++)
				if (hashtable[i]!=null && hashtable[j]!=null)
					if (hashFunction(hashtable[i].acount.getId())==hashFunction(hashtable[j].acount.getId()))
						return false;
		
		return true;
	}

	

	
}